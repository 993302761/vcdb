package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

import java.util.Arrays;

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

    public byte[] getData() {
        return data;
    }

    public DataBase(byte[] data) {
        this.data = data;
    }

    public long getTime(){
        return Bytes.toLong(this.data,0,8);
    }

    public byte getType(){
        return this.data[8];
    }

    public int getDbNameLength(){
        return Bytes.toInt(this.data,9,4);
    }


    public String getDbName(){
        return Bytes.toString(this.data,13,getDbNameLength());
    }


    @Override
    public String toString() {
        return "DataBase{" +
                " time=" + getTime() +
                " type=" + getType() +
                " dbName=" + getDbName() +
                '}';
    }
}
