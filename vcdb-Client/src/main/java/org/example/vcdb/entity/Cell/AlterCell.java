package org.example.vcdb.entity.Cell;

import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class AlterCell {

    private String cfName;

    private String old_cfName;

    private String method;

    public String getCfName() {
        return cfName;
    }

    public String getOld_cfName() {
        return old_cfName;
    }

    public String getMethod() {
        return method;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public void setOld_cfName(String old_cfName) {
        this.old_cfName = old_cfName;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+cfName.getBytes().length+4+old_cfName.getBytes().length+4+method.getBytes().length];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,cfName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,cfName.getBytes(),0,cfName.getBytes().length);

        pos= Bytes.putInt(bytes,pos,old_cfName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,old_cfName.getBytes(),0,old_cfName.getBytes().length);

        pos= Bytes.putInt(bytes,pos,method.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,method.getBytes(),0,method.getBytes().length);

        return bytes;
    }
}
