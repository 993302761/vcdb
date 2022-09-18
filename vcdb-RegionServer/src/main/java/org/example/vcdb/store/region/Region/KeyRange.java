package org.example.vcdb.store.region.Region;

import org.example.vcdb.util.Bytes;

/**
 * @ClassName KeyRange
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/18 下午9:56
 * @Version 1.0
 */

public class KeyRange {
    byte[] data;

    public byte[] getData() {
        return data;
    }

    public KeyRange(String cfName, String startKey, String endKey) {
        data=new byte[1024*4];
        int pos=0;
        pos=Bytes.putInt(this.data,pos,cfName.getBytes().length);
        pos = Bytes.putBytes(this.data, pos, cfName.getBytes(), 0,cfName.getBytes().length);
        pos=Bytes.putInt(this.data,pos,startKey.getBytes().length);
        pos = Bytes.putBytes(this.data, pos, startKey.getBytes(), 0,startKey.getBytes().length);
        pos=Bytes.putInt(this.data,pos,endKey.getBytes().length);
        pos = Bytes.putBytes(this.data, pos, endKey.getBytes(), 0,endKey.getBytes().length);
    }
}
