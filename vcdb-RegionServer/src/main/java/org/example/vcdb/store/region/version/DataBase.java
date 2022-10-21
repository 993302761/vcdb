package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

/**
 * @ClassName DB
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/20 下午6:11
 * @Version 1.0
 */

public class DataBase {
    byte[] data;
    public DataBase(long timeStamp, byte type, String dbName){
        data=new byte[8+1+dbName.getBytes().length];
        int pos=0;
        pos= Bytes.putLong(this.data,pos,timeStamp);

        pos= Bytes.putByte(this.data,pos,type);

        pos= Bytes.putInt(this.data,pos,dbName.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,dbName.getBytes(),0,dbName.getBytes().length);
    }
}
