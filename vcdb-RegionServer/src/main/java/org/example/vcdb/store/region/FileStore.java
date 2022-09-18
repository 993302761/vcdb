package org.example.vcdb.store.region;


import org.example.vcdb.store.mem.KV;
import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
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
    private int length = 0;

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return length;
    }

    public int getPageTrailerLength(List<KVRange> pageTrailer) {
        int count = 0;
        for (KVRange kvRange : pageTrailer) {
            count += 4 + kvRange.getLength();
        }
        return count;
    }

    /*
        int columnMetaIndex;4
        int pageTrailerIndex;4
        int dataSetIndex;4
        long min=Long.MIN_VALUE;8
        long max=Long.MAX_VALUE;8
        boolean unique;1
        boolean isNull;1
        byte type;1
        */
    public byte[] getHeadPage() {
        Trailer trailer = getTrailer();
        int dataSetIndex = trailer.getDataSetIndex();
        return Bytes.subByte(this.data, 0, dataSetIndex);
    }

    public FileStore(byte[] data) {
        this.data = data;
        this.length = data.length;
    }

    public FileStore(ColumnFamilyMeta columnFamilyMeta,
                     List<KVRange> pageTrailer, KeyValueSkipListSet dataSet) {
        //fileStoreMeta也会随时更新
        this.data = new byte[4 * 1024 * 16];
        int pos = 16;
        pos = Bytes.putBytes(this.data, pos, columnFamilyMeta.getData(), 0, 19);

        pos = Bytes.putInt(this.data, pos, pageTrailer.size());
        for (KVRange kvRange : pageTrailer) {
            pos = Bytes.putInt(this.data, pos, kvRange.getLength());
            pos = Bytes.putBytes(this.data, pos, kvRange.getData(), 0, kvRange.getLength());
        }
        pos = (pos % (1024 * 4) + 1) * (1024 * 4);
        //分页管理可以改变trailer的参数
        Trailer trailer = new Trailer(
                4 * 3,
                4 * 3 + 19,
                pos);
        Bytes.putInt(this.data, 0, trailer.getColumnMetaIndex());
        Bytes.putInt(this.data, 4, trailer.getPageTrailerIndex());
        Bytes.putInt(this.data, 8, trailer.getDataSetIndex());
        int dataSetCount = dataSet.size();
        pos = Bytes.putInt(this.data, pos, dataSetCount);
        //获取key和value的set
        for (KV kv : dataSet) {
            pos = Bytes.putInt(this.data, pos, kv.getLength());
            pos = Bytes.putBytes(this.data, pos, kv.getData(), 0, kv.getLength());
        }
        this.length = this.data.length;
    }


    public List<KVRange> getPageTrailer() {
        Trailer trailer = getTrailer();
        int pos = trailer.getPageTrailerIndex();
        List<KVRange> pageTrailer = new ArrayList<>();
        int kvRangeCount = Bytes.toInt(this.data, pos, 4);
        pos += 4;
        for (int i = 0; i < kvRangeCount; i++) {
            int rangeLength = Bytes.toInt(this.data, pos, 4);
            pos += 4;
            pageTrailer.add(new KVRange(Bytes.subByte(this.data, pos, rangeLength)));
            pos += rangeLength;
        }
        return pageTrailer;
    }

    /*
    int columnMetaIndex;4
    int pageTrailerIndex;4
    int dataSetIndex;4
    long min=Long.MIN_VALUE;8
    long max=Long.MAX_VALUE;8
    boolean unique;1
    boolean isNull;1
    byte type;1
    */
    public Trailer getTrailer() {
        return new Trailer(Bytes.toInt(this.data, 0, 4),
                Bytes.toInt(this.data, 4, 4),
                Bytes.toInt(this.data, 8, 4));
    }
    public ColumnFamilyMeta getColumnFamilyMeta(){
        return new ColumnFamilyMeta(Bytes.subByte(this.data,12,19));
    }
    public void setColumnFamilyMeta(ColumnFamilyMeta columnFamilyMeta){
        Bytes.putBytes(this.data, 12, columnFamilyMeta.getData(), 0, 19);
    }
    /*-----------------------------------------------------------------*/
    public int getColumnMetaIndex() {
        return Bytes.toInt(this.data, 0, 4);
    }

    public int getTrailerIndex() {
        return Bytes.toInt(this.data, 4, 4);
    }

    public int getDataSetIndex() {
        return Bytes.toInt(this.data, 8, 4);
    }
    public long getMin(){
        return Bytes.toLong(this.data,12,8);
    }
    public long getMax(){
        return Bytes.toLong(this.data,20,8);
    }
    public boolean isUnique(){
        return this.data[28] != 20;
    }
    public boolean isNull(){
        return this.data[29]!=0;
    }
    public byte getType(){
        return this.data[30];
    }
    public void setColumnMetaIndex(int val) {
        Bytes.putInt(this.data, 0, val);
    }

    public void setTrailerIndex(int val) {
        Bytes.putInt(this.data, 4, val);
    }

    public void setDataSetIndex(int val) {
        Bytes.putInt(this.data, 8, val);
    }
    public void setMin(long val){
         Bytes.putLong(this.data,12,val);
    }
    public void setMax(long val){
         Bytes.putLong(this.data,20,val);
    }
    public void setUnique(boolean val){
        Bytes.putByte(this.data,28, (byte) (val?1:0));
    }
    public void setNull(boolean val){
        Bytes.putByte(this.data,29, (byte) (val?1:0));

    }
    public void setType(byte val){
        Bytes.putByte(this.data,28, val);
    }
    /*----------------------------------------------------*/
    //DataChannel<=============>fileStore
    //update/add
    public void addData(KV kv) {
        int dataSetIndex = getDataSetIndex();
        int pageIndex = getPageByKV(kv);
    }
    public void updateData(KV kv) {
        int dataSetIndex = getDataSetIndex();
        int pageIndex = getPageByKV(kv);
    }
    private int getPageByKV(KV kv) {
        return 99;
    }

    public KeyValueSkipListSet getDataSet() {
        Trailer trailer = getTrailer();
        int pos = trailer.getDataSetIndex();
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
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

}
