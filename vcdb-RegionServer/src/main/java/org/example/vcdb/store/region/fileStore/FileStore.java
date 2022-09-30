package org.example.vcdb.store.region.fileStore;


import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.region.RegionServer;
import org.example.vcdb.util.Bytes;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @ClassName Region
 * @Description TODO
 * @Author lqc
 * @Date 2022/8/9 下午10:25
 * @Version 1.0
 */
/*Region的最小单位Store,一个store对应一个列族*/
public class FileStore {
    /*Trailer纪录了RegionMetaIndex、Data Index、Meta Index块的起始位置，Data Index和Meta Index索引的数量等。
     * meta 主要存放meta信息，即BloomFilter信息。
     * data 存储多个kv对*/
    /*
     * Trailer (offset of other member)(根据offset,可以拿到整个region的大小)包含RegionMeta (类）
     * pageCount
     * CF_Meta      这个列族的元数据，包括列族的限制（ColumnFamilyCell）
     * regionInfo
     * pageTrailer(KVRange(startKey,endKey))得固定
     * DataSet   (不分，一直往后累加，不用打乱排序）
     * */
    //pageCountMax=2^31/2^11=2^20
    private byte[] data = null;

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return this.data.length;
    }

    /*
    boolean unique;1
    boolean isNull;1
    long min=Long.MIN_VALUE;8
    long max=Long.MAX_VALUE;8
    byte type;1
    */

    public FileStore(byte[] data) {
        this.data = data;
    }

    public FileStore(ColumnFamilyMeta columnFamilyMeta, KeyValueSkipListSet dataSet) {
        //fileStoreMeta也会随时更新
        this.data = new byte[4 * 1024 * 16];
        int pos=0;
        pos=Bytes.putBytes(this.data, pos, columnFamilyMeta.getData(), 0, 19);
        appendPage(1,dataSet);
    }
    public void appendPage(int pageIndex,KeyValueSkipListSet dataSet){
        int pos=pageIndex*(1024 * 4);
        int dataSetCount = dataSet.size();
        pos = Bytes.putInt(this.data, pos, dataSetCount);
        //获取key和value的set
        for (KV kv : dataSet) {
            pos = Bytes.putInt(this.data, pos, kv.getLength());
            pos = Bytes.putBytes(this.data, pos, kv.getData(), 0, kv.getLength());
        }
        System.out.println("----------------------");
    }
    public static byte[] kvsToByteArray(KeyValueSkipListSet dataSet){
        byte[] bytes = new byte[4 * 1024];
        int pos=0;
        for (KV kv : dataSet) {
            pos = Bytes.putInt(bytes, pos, kv.getLength());
            pos = Bytes.putBytes(bytes, pos, kv.getData(), 0, kv.getLength());
        }
        return bytes;
    }
    public static byte[] kvsToPageByteArray(KeyValueSkipListSet dataSet){
        byte[] bytes = new byte[4 * 1024];
        int pos=0;
        int dataSetCount = dataSet.size();
        pos = Bytes.putInt(bytes, pos, dataSetCount);
        for (KV kv : dataSet) {
            pos = Bytes.putInt(bytes, pos, kv.getLength());
            pos = Bytes.putBytes(bytes, pos, kv.getData(), 0, kv.getLength());
        }
        System.out.println("++++++++++"+pos);
        return bytes;
    }
    /*
    long min=Long.MIN_VALUE;8
    long max=Long.MAX_VALUE;8
    boolean unique;1
    boolean isNull;1
    byte type;1
    */
    public ColumnFamilyMeta getColumnFamilyMeta(){
        return new ColumnFamilyMeta(Bytes.subByte(this.data,0,19));
    }
    public void setColumnFamilyMeta(ColumnFamilyMeta columnFamilyMeta){
        Bytes.putBytes(this.data, 0, columnFamilyMeta.getData(), 0, 19);
    }

    /*-----------------------------------------------------------------*/
    public boolean isUnique(){
        return this.data[0] != 0;
    }
    public boolean isNull(){
        return this.data[1]!=0;
    }
    public long getMin(){
        return Bytes.toLong(this.data,2,8);
    }
    public long getMax(){
        return Bytes.toLong(this.data,10,8);
    }
    public byte getType(){
        return this.data[18];
    }

    public void setMin(long val){
         Bytes.putLong(this.data,0,val);
    }
    public void setMax(long val){
         Bytes.putLong(this.data,8,val);
    }
    public void setUnique(boolean val){
        Bytes.putByte(this.data,16, (byte) (val?1:0));
    }
    public void setNull(boolean val){
        Bytes.putByte(this.data,17, (byte) (val?1:0));
    }
    public void setType(byte val){
        Bytes.putByte(this.data,18, val);
    }

    /*---------------------action-------------------------------*/
    public void dis(){
        System.out.println(isUnique());
        System.out.println(isNull());
        System.out.println(getMin());
        System.out.println(getMax());
        System.out.println(ColumnFamilyMeta.byteToCFType(getType()));
        System.out.println(getDataSet(1));
    }

    public Map<Integer,List<KV>> splitKVsByPage(List<KVRange> pageTrailer, List<KV> kvSet){
        Map<Integer,List<KV>> integerListMap=new ConcurrentHashMap<>();
        for (KV kv:kvSet){
            int i=1;
            for (KVRange kvRange:pageTrailer){
                if (kv.getRowKey().compareTo(Bytes.toString(kvRange.getEndKey()))<=0){
                    if (integerListMap.containsKey(i)){
                        List<KV> kvs=new ArrayList<>();
                        kvs.add(kv);
                        integerListMap.put(i,kvs);
                    }else {
                        List<KV> kvs=integerListMap.get(i);
                        kvs.add(kv);
                    }
                }
            }
        }
        return integerListMap;
    }
    //DataChannel<=============>fileStore
    //update/add
    public void SplitPage(String metaName,List<KV> kvSet) {
        List<KVRange> pageTrailer = RegionServer.getPageTrailer(metaName);
        Map<Integer, List<KV>> integerListMap = splitKVsByPage(pageTrailer, kvSet);
        for (Map.Entry<Integer, List<KV>> entry : integerListMap.entrySet()) {
            int index = entry.getKey();
            List<KV> kvList = entry.getValue();
            if (isSplitPage(index, kvList)) {
                insertBigKVs(index, kvList);
            } else {
                insertKVstoPage(entry.getValue());
            }
        }
    }

    private void insertBigKVs(int index, List<KV> kvList) {
        setNewPage(index,kvList);
        updateTrailer(index);
    }

    private void setNewPage(int index, List<KV> kvList) {
    }


    private void updateTrailer(int index) {

    }
    private void insertKVstoPage(List<KV> value) {

    }

    private boolean isSplitPage(Integer key, List<KV> kvs) {
        int pageIndex=4*1024*key;
        int valueLength=0;
        for (KV kv:kvs){
            valueLength+=4+kv.getLength();
        }
        int pageContentLength = getPageContentLength(pageIndex);
        return pageContentLength + valueLength > 4 * 1024;
    }

    private int getPageContentLength(int pageIndex) {
        int pos=4*1024*pageIndex;
        int kvCount = Bytes.toInt(this.data, pos, 4);
        for (int i = 0; i < kvCount; i++) {
            int kvLength = Bytes.toInt(this.data, pos, 4);
            pos += 4;
            pos += kvLength;
        }
        return pos;
    }

    public void deleteKVs(List<KVRange> pageTrailer, List<KV> kvSet){
        Map<Integer, List<KV>> integerListMap = splitKVsByPage(pageTrailer,kvSet);
    }

    public KeyValueSkipListSet getDataSet(int pageIndex) {
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        int pos=pageIndex*(1024 * 4);
        int kvCount = Bytes.toInt(this.data, pos, 4);
        pos += 4;
        for (int i = 0; i < kvCount; i++) {
            int kvLength = Bytes.toInt(this.data, pos, 4);
            pos += 4;
            kvs.add(new KV(Bytes.subByte(this.data, pos, kvLength)));
            pos += kvLength;
        }
        return kvs;
    }
    public static void disDataSet(KeyValueSkipListSet kvs){
        for (KV kv:kvs){
            kv.dis();
            System.out.println("______________________________");
        }
    }
}
