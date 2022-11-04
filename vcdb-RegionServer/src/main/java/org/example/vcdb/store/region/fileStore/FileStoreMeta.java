package org.example.vcdb.store.region.fileStore;

import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.example.vcdb.store.region.fileStore.FileStore.kvsToByteArray;

/*
 * 数据格式
 * encodeName.meta
 * encodeName*/

//存储a region的具体信息(元数据)
public class FileStoreMeta {

//    //Region 创建的时间戳
//    long timeStamp;
//    private boolean split = false;
//    //该region对应的文件名
//    private String encodedName = null;
//    private byte[] endKey;
//    private byte[] startKey;
//    private String tableName = null;
//    private String nameSpace = null;

    private byte[] data;


    public FileStoreMeta(byte[] data) {
        this.data = data;

    }

    public FileStoreMeta(long timeStamp, boolean split, String encodedName,
                         byte[] endKey, byte[] startKey) {
        byte spl = 0;
        if (split) {
            spl = 1;
        }
        int pos = 0;
//        byte[] bytes = new byte[8 + 1 + 4 + encodedName.getBytes().length + 4 + startKey.length + 4 + endKey.length + 4 + tableName.getBytes().length + 4 + nameSpace.getBytes().length + 4 + getPageTrailerLength(pageTrailer)];
        byte[] bytes = new byte[4 * 1024];
        pos = Bytes.putLong(bytes, pos, timeStamp);
        pos = Bytes.putByte(bytes, pos, spl);

        pos = Bytes.putInt(bytes, pos, encodedName.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, encodedName.getBytes(), 0, encodedName.getBytes().length);

        pos = Bytes.putInt(bytes, pos, startKey.length);
        pos = Bytes.putBytes(bytes, pos, startKey, 0, startKey.length);

        pos = Bytes.putInt(bytes, pos, endKey.length);
        pos = Bytes.putBytes(bytes, pos, endKey, 0, endKey.length);


        pos = Bytes.putInt(bytes, pos, 1);
        KVRange kvRange = new KVRange(new Date().getTime(),0, " ", "zzzzzzzzzzzzzzzzz");
        pos = Bytes.putInt(bytes, pos, kvRange.getLength());
        pos = Bytes.putBytes(bytes, pos, kvRange.getData(), 0, kvRange.getLength());
        this.data = bytes;
    }


    public FileStoreMeta(long timeStamp, boolean split, String encodedName,
                         byte[] endKey, byte[] startKey, List<KVRange> pageTrailer) {
        byte spl = 0;
        if (split) {
            spl = 1;
        }
        this.data = createByteArray(timeStamp, spl, encodedName, endKey, startKey, pageTrailer);

    }

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return this.data.length;
    }

    private int getPageTrailerLength(List<KVRange> pageTrailer) {
        int length = 0;
        for (KVRange kvRange : pageTrailer) {
            length = length + 4 + kvRange.getLength();
        }
        return length;
    }

    private byte[] createByteArray(long timeStamp, byte spl,
                                   String encodedName, byte[] endKey,
                                   byte[] startKey,List<KVRange> pageTrailer) {
        int pos = 0;
//        byte[] bytes = new byte[8 + 1 + 4 + encodedName.getBytes().length + 4 + startKey.length + 4 + endKey.length + 4 + tableName.getBytes().length + 4 + nameSpace.getBytes().length + 4 + getPageTrailerLength(pageTrailer)];
        byte[] bytes = new byte[4 * 1024];
        pos = Bytes.putLong(bytes, pos, timeStamp);
        pos = Bytes.putByte(bytes, pos, spl);

        pos = Bytes.putInt(bytes, pos, encodedName.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, encodedName.getBytes(), 0, encodedName.getBytes().length);

        pos = Bytes.putInt(bytes, pos, startKey.length);
        pos = Bytes.putBytes(bytes, pos, startKey, 0, startKey.length);

        pos = Bytes.putInt(bytes, pos, endKey.length);
        pos = Bytes.putBytes(bytes, pos, endKey, 0, endKey.length);


        pos = Bytes.putInt(bytes, pos, pageTrailer.size());
        for (KVRange kvRange : pageTrailer) {
            pos = Bytes.putInt(bytes, pos, kvRange.getLength());
            pos = Bytes.putBytes(bytes, pos, kvRange.getData(), 0, kvRange.getLength());
        }
        return bytes;
    }


    public long getTimeStamp() {
        return Bytes.toLong(this.data, 0, 8);
    }

    public boolean isSplit() {
        return this.data[9] != 0;
    }

    public int getEncodeNameLength() {
        return Bytes.toInt(this.data, 9, 4);
    }

    public String getEncodedName() {
        return Bytes.toString(this.data, 13, getEncodeNameLength());
    }

    public int getStartKeyLength() {
        return Bytes.toInt(this.data, 13 + getEncodeNameLength(), 4);
    }

    public byte[] getStartKey() {
        return Bytes.subByte(this.data, 17 + getEncodeNameLength(), getStartKeyLength());
    }

    public int getEndKeyLength() {
        return Bytes.toInt(this.data, 17 + getEncodeNameLength() + getStartKeyLength(), 4);
    }

    public byte[] getEndKey() {
        return Bytes.subByte(this.data, 21 + getEncodeNameLength() + getStartKeyLength(), getEndKeyLength());
    }


    public List<KVRange> getPageTrailer() {
        int pos = 21 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength();
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

    public void dis() {
        System.out.println(getTimeStamp());
        System.out.println(isSplit());
        System.out.println(getEncodeNameLength());
        System.out.println(getEncodedName());
        System.out.println(getStartKeyLength());
        System.out.println(Arrays.toString(getStartKey()));
        System.out.println(getEndKeyLength());
        System.out.println(Arrays.toString(getEndKey()));
        System.out.println(getPageTrailer());
    }

    public void setPageTrailer(List<KVRange> pageTrailer) {
        int pos = 21 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength();
        pos = Bytes.putInt(this.data, pos, pageTrailer.size());
        for (KVRange kvRange : pageTrailer) {
            pos = Bytes.putInt(this.data, pos, kvRange.getLength());
            pos = Bytes.putBytes(this.data, pos, kvRange.getData(), 0, kvRange.getLength());
        }
    }

    public void updatePageLength(int pageIndex,int length){
        List<KVRange> pageTrailer = getPageTrailer();
        KVRange kvRange= pageTrailer.get(pageIndex-1);
        kvRange.setPageLength(length);
        pageTrailer.set(pageIndex-1,kvRange);
        setPageTrailer(pageTrailer);
    }
//    public void initSetPageTrailer(KeyValueSkipListSet kvs) {
//        byte[] bytes = kvsToByteArray(kvs);
//
//        String minKey = "";
//        String maxKey = "";
//        List<KVRange> kvRanges=new ArrayList<>();
//        int pageLength = 4 + kvsToByteArray(kvs).length;
//        for (KV kv : kvs) {
//            if (minKey.compareTo(kv.getRowKey()) < 0) {
//                minKey = kv.getRowKey();
//            }
//            if (maxKey.compareTo(kv.getRowKey()) > 0) {
//                maxKey = kv.getRowKey();
//            }
//        }
//        kvRanges.add(new KVRange(pageLength, minKey, maxKey));
//        this.setPageTrailer(kvRanges);
//    }
}
