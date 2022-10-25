package org.example.vcdb.store.region.fileStore;


import org.example.vcdb.store.mem.KV;
import org.example.vcdb.util.Bytes;

import java.util.Arrays;


/**
 * @ClassName KVRange
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/5 下午10:00
 * @Version 1.0
 */

public class KVRange {
    //    String startKey;
//    String endKey;
    byte[] bytes;

    public KVRange(byte[] bytes) {
        this.bytes = bytes;
    }

    public KVRange(long timestamp,int pageLength,String startKey, String endKey) {
        int pos = 0;
        this.bytes = new byte[8+4+4 + startKey.getBytes().length + 4 + endKey.getBytes().length];
        pos = Bytes.putLong(bytes,pos,timestamp);
        pos = Bytes.putInt(bytes, pos, pageLength);
        pos = Bytes.putInt(bytes, pos, startKey.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, startKey.getBytes(), 0, startKey.getBytes().length);
        pos = Bytes.putInt(bytes, pos, endKey.getBytes().length);
        pos = Bytes.putBytes(bytes, pos, endKey.getBytes(), 0, endKey.getBytes().length);
    }
    public long getTimestamp(){
        return Bytes.toLong(this.bytes,0,8);
    }

    public int getPageLength(){
        return Bytes.toInt(this.bytes, 8, 4);
    }
    public int getStartKeyLength() {
        return Bytes.toInt(this.bytes, 12, 4);
    }

    public byte[] getStartKey() {
        return Bytes.subByte(this.bytes, 16, getStartKeyLength());
    }

    public int getEndKeyLength() {
        return Bytes.toInt(this.bytes, 16 + getStartKeyLength(), 4);
    }

    public byte[] getEndKey() {
        return Bytes.subByte(this.bytes, 20 + getStartKeyLength(), getEndKeyLength());
    }

    public byte[] getData() {
        return bytes;
    }

    public int getLength() {
        return bytes.length;
    }

    public void dis(){
        System.out.println(getPageLength());
        System.out.println(getStartKeyLength());
        System.out.println(Arrays.toString(getStartKey()));
        System.out.println(getEndKeyLength());
        System.out.println(Arrays.toString(getEndKey()));
    }

    @Override
    public String toString() {
        return "KVRange{" +"\n"+
                "timestamp="+getTimestamp()+"\n"+
                "pageLength="+getPageLength()+"\n"+
                "startKey=" + Bytes.toString(getStartKey()) +"\n"+
                "endKey=" + Bytes.toString(getEndKey()) +
                '}'+"\n";
    }

    public void setMinKey(KV kv) {
        int pos=8;
        pos = Bytes.putInt(bytes, pos, kv.getRowKey().getBytes().length);
        pos = Bytes.putBytes(bytes, pos, kv.getRowKey().getBytes(), 0, kv.getRowKey().getBytes().length);
    }

    public void setMaxKey(KV kv) {
        int pos=12 + getStartKeyLength();
        pos = Bytes.putInt(bytes, pos, kv.getRowKey().getBytes().length);
        pos = Bytes.putBytes(bytes, pos, kv.getRowKey().getBytes(), 0, kv.getRowKey().getBytes().length);
    }
}
