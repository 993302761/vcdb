package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

/**
 * @ClassName Table
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/20 下午6:11
 * @Version 1.0
 */

public class Table {
    byte[] data;

    public byte[] getData() {
        return data;
    }

    public Table(long timeStamp, byte type, String tabName){
        data=new byte[8+1+tabName.getBytes().length];
        int pos=0;
        pos= Bytes.putLong(this.data,pos,timeStamp);

        pos= Bytes.putByte(this.data,pos,type);

        pos= Bytes.putInt(this.data,pos,tabName.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,tabName.getBytes(),0,tabName.getBytes().length);

    }

    public Table(byte[] data) {
        this.data = data;
    }
}
