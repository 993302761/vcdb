package org.example.vcdb.store.region.fileStore;

import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private final byte[] data;
    private int length = 0;

    public FileStoreMeta(byte[] data) {
        this.data = data;
        this.length = data.length;
    }

    public FileStoreMeta(long timeStamp, boolean split, String encodedName, byte[] endKey, byte[] startKey, String tableName, String nameSpace, List<KVRange> pageTrailer) {
        byte spl = 0;
        if (split) {
            spl = 1;
        }
        this.data = createByteArray(timeStamp, spl, encodedName, endKey, startKey, tableName, nameSpace,pageTrailer);
        this.length = this.data.length;
    }

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return length;
    }
    private int getPageTrailerLength(List<KVRange> pageTrailer) {
        int length=0;
        for (KVRange kvRange:pageTrailer) {
            length=length+4+kvRange.getLength();
        }
        return length;
    }
    private byte[] createByteArray(long timeStamp, byte spl,
                                   String encodedName, byte[] endKey,
                                   byte[] startKey, String tableName, String nameSpace,List<KVRange> pageTrailer) {
        int pos = 0;
        byte[] bytes = new byte[8 + 1 + 4 + encodedName.getBytes().length + 4 + startKey.length + 4 + endKey.length + 4 + tableName.getBytes().length + 4 + nameSpace.getBytes().length+4+getPageTrailerLength(pageTrailer)];
        pos = Bytes.putLong(bytes, pos, timeStamp);
        pos = Bytes.putByte(bytes, pos, spl);

        pos = Bytes.putInt(bytes, pos, encodedName.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, encodedName.getBytes(), 0, encodedName.getBytes().length);

        pos = Bytes.putInt(bytes, pos, startKey.length);
        pos = Bytes.putBytes(bytes, pos, startKey, 0, startKey.length);

        pos = Bytes.putInt(bytes, pos, endKey.length);
        pos = Bytes.putBytes(bytes, pos, endKey, 0, endKey.length);

        pos = Bytes.putInt(bytes, pos, tableName.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, tableName.getBytes(), 0, tableName.getBytes().length);

        pos = Bytes.putInt(bytes, pos, nameSpace.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, nameSpace.getBytes(), 0, nameSpace.getBytes().length);

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

    public int getTableNameLength() {
        return Bytes.toInt(this.data, 21 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength(), 4);
    }

    public String getTableName() {
        return Bytes.toString(this.data, 25 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength(), getTableNameLength());
    }

    public int getNameSpaceLength() {
        return Bytes.toInt(this.data, 25 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength() + getTableNameLength(), 4);
    }

    public String getNameSpace() {
        return Bytes.toString(this.data, 29 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength() + getTableNameLength(), getNameSpaceLength());
    }

    public List<KVRange> getPageTrailer() {
        int pos = 29 + getEncodeNameLength() + getEndKeyLength() + getStartKeyLength() + getTableNameLength()+getNameSpaceLength();
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
    public void dis(){
        System.out.println(getTimeStamp());
        System.out.println(isSplit());
        System.out.println(getEncodeNameLength());
        System.out.println(getEncodedName());
        System.out.println(getStartKeyLength());
        System.out.println(Arrays.toString(getStartKey()));
        System.out.println(getEndKeyLength());
        System.out.println(Arrays.toString(getEndKey()));
        System.out.println(getTableNameLength());
        System.out.println(getTableName());
        System.out.println(getNameSpaceLength());
        System.out.println(getNameSpace());
        System.out.println(getPageTrailer());
    }
}
