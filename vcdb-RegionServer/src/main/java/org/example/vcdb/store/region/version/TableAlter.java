package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

/**
 * @ClassName TableAlter
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/20 下午6:23
 * @Version 1.0
 */

public class TableAlter {
    byte[] data;
    public TableAlter(long timestamp, byte method, byte type,boolean unique, boolean isNull,
                      String min, String max, String tableName,
                      String cfName, String oldCfName){
        data=new byte[8+1+1+1+1+4+min.getBytes().length+4+max.getBytes().length+
                4+tableName.getBytes().length+4+cfName.getBytes().length+4+oldCfName.getBytes().length];
        int pos=0;
        byte uni=0;
        byte isNil=0;
        if (unique){
            uni=1;
        }
        if (isNull){
            isNil=1;
        }
        pos= Bytes.putLong(this.data,pos,timestamp);

        pos= Bytes.putByte(this.data,pos,method);

        pos= Bytes.putByte(this.data,pos,type);

        pos= Bytes.putByte(this.data,pos,uni);

        pos= Bytes.putByte(this.data,pos,isNil);

        pos= Bytes.putInt(this.data,pos,min.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,min.getBytes(),0,min.getBytes().length);

        pos= Bytes.putInt(this.data,pos,max.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,max.getBytes(),0,max.getBytes().length);

        pos= Bytes.putInt(this.data,pos,tableName.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,tableName.getBytes(),0,tableName.getBytes().length);

        pos= Bytes.putInt(this.data,pos,cfName.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,cfName.getBytes(),0,cfName.getBytes().length);

        pos= Bytes.putInt(this.data,pos,oldCfName.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,oldCfName.getBytes(),0,oldCfName.getBytes().length);
    }
}
