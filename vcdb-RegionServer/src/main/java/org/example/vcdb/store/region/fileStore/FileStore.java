package org.example.vcdb.store.region.fileStore;


import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.util.Bytes;
import java.util.List;



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
    public FileStore(ColumnFamilyMeta columnFamilyMeta) {
        //fileStoreMeta也会随时更新
        this.data = new byte[4 * 1024 * 16];
        int pos=0;
        pos=Bytes.putBytes(this.data, pos, columnFamilyMeta.getData(), 0, columnFamilyMeta.getData().length);
    }

    public FileStore(ColumnFamilyMeta columnFamilyMeta, KeyValueSkipListSet dataSet) {
        //fileStoreMeta也会随时更新
        this.data = new byte[4 * 1024 * 16];
        int pos=0;
        pos=Bytes.putBytes(this.data, pos, columnFamilyMeta.getData(), 0, columnFamilyMeta.getData().length);
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

    public static int getKVsLength(KeyValueSkipListSet dataSet){
        int length=0;
        for (KV kv:dataSet){
            length+=4+kv.getLength();
        }
        return length;
    }

    public static int getKVsLength(List<KV> dataSet){
        int length=0;
        for (KV kv:dataSet){
            length+=4+kv.getLength();
        }
        return length;
    }

    public static byte[] kvsToByteArray(KeyValueSkipListSet dataSet){
        int pos=0;
        int length=0;
        for (KV kv:dataSet){
            length+=4+kv.getLength();
        }
        byte[] bytes = new byte[length];
        for (KV kv : dataSet) {
            pos = Bytes.putInt(bytes, pos, kv.getLength());
            pos = Bytes.putBytes(bytes, pos, kv.getData(), 0, kv.getLength());
        }
        return bytes;
    }

    public static byte[] kvsToByteArray(List<KV> dataSet){
        int pos=0;
        int length=0;
        for (KV kv:dataSet){
            length+=4+kv.getLength();
        }
        byte[] bytes = new byte[length];
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

    public static byte[] kvsToPageByteArray(List<KV> dataSet){
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

    public static KeyValueSkipListSet byteArrayToKvs(byte[] byteArray){
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        int pos=0;
        int kvCount = Bytes.toInt(byteArray, pos, 4);
        pos += 4;
        if (kvCount!=0){
            for (int i = 0; i < kvCount; i++) {
                int kvLength = Bytes.toInt(byteArray, pos, 4);
                pos += 4;
                KV kv = new KV(Bytes.subByte(byteArray, pos, kvLength));
                if (kvs.contains(kv.getRowKey())){
                    KV kv1 = kvs.get(kv.getRowKey());
                    List<KV.ValueNode> values1 = kv1.getValues();
                    List<KV.ValueNode> values2 = kv.getValues();
                    values1.addAll(values2);
                    kv1.setValues(values1);
                    kvs.add(kv1);
                }else {
                    kvs.add(kv);
                }
                pos += kvLength;
            }
        }
        return kvs;
    }
    /*
    long min=Long.MIN_VALUE;8
    long max=Long.MAX_VALUE;8
    boolean unique;1
    boolean isNull;1
    byte type;1
    */

    public ColumnFamilyMeta getColumnFamilyMeta(){
        int minLength=Bytes.toInt(this.data,0,4);
        String min=Bytes.toString(this.data,4,minLength);

        int maxLength=Bytes.toInt(this.data,4+minLength,4);
        String max=Bytes.toString(this.data,8+minLength,maxLength);

        boolean isUnique=data[8+minLength+maxLength] != 0;
        boolean isNull=data[9+minLength+maxLength] != 0;
        byte cfType=data[10+minLength+maxLength];

        return new ColumnFamilyMeta(min,max,isUnique,isNull,ColumnFamilyMeta.byteToCFType(cfType));
    }
    public void setColumnFamilyMeta(ColumnFamilyMeta columnFamilyMeta){
        Bytes.putBytes(this.data, 0, columnFamilyMeta.getData(), 0, columnFamilyMeta.getData().length);
    }

    /*-----------------------------------------------------------------*/

    /*---------------------action-------------------------------*/
    public void dis(){
        ColumnFamilyMeta columnFamilyMeta = getColumnFamilyMeta();

        System.out.println(columnFamilyMeta.getMin());
        System.out.println(columnFamilyMeta.getMax());
        System.out.println(columnFamilyMeta.isUnique());
        System.out.println(columnFamilyMeta.isNull());
        System.out.println(columnFamilyMeta.getType());

        System.out.println(getDataSet(1));
    }


//    DataChannel<=============>fileStore
//    update/add
//    public void SplitPage(String metaName,List<KV> kvSet) {
//        List<KVRange> pageTrailer = RegionServer.getPageTrailer(metaName);
//        Map<Integer, List<KV>> integerListMap = splitKVsByPage(pageTrailer, kvSet);
//        for (Map.Entry<Integer, List<KV>> entry : integerListMap.entrySet()) {
//            int index = entry.getKey();
//            List<KV> kvList = entry.getValue();
//            if (isSplitPage(index, kvList)) {
//                insertBigKVs(index, kvList);
//            } else {
//                insertKVstoPage(entry.getValue());
//            }
//        }
//    }

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

    public KeyValueSkipListSet getDataSet(int pageIndex) {
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        int pos=pageIndex*(1024 * 4);
        int kvCount = Bytes.toInt(this.data, pos, 4);
        pos += 4;
        if (kvCount!=0){
            for (int i = 0; i < kvCount; i++) {
                int kvLength = Bytes.toInt(this.data,pos, 4);
                pos += 4;
                KV kv1 = new KV(Bytes.subByte(this.data, pos, kvLength));
                System.out.println("kv1:"+kv1);
                if (kvs.contains(kv1.getRowKey())){
                    KV kv2 = kvs.get(kv1.getRowKey());
                    List<KV.ValueNode> values1 = kv1.getValues();
                    System.out.println("values1:"+values1);
                    List<KV.ValueNode> values2 = kv2.getValues();
                    System.out.println("values2:"+values2);
                    values1.addAll(values2);
                    KV kv=new KV(kv1.getRowKey().getBytes(),0,kv1.getRowKey().getBytes().length,
                            values1);
                    kvs.add(kv);
                } else {
                    kvs.add(kv1);
                }
                pos += kvLength;
            }
        }
        return kvs;
    }
    public static void disDataSet(KeyValueSkipListSet kvs){
        for (KV kv:kvs){
//            kv.dis();
            System.out.println(kv.getRowKey());
            System.out.println("______________________________");
        }
    }
}
