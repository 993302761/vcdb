package org.example.vcdb.entity.Cell;

import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */

/*修改表结构*/

public class AlterCell {

    private String cfName;

    private String old_cfName;
    
    private String min;

    private String max;

    private byte type=0;

    private byte  method=0;

    private Boolean unique;

    private Boolean isNull;



    public String getCfName() {
        return cfName;
    }

    public String getOld_cfName() {
        return old_cfName;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public byte getMethod() {
        return method;
    }

    public byte getType() {
        return type;
    }

    public boolean isUnique() {
        return unique;
    }

    public Boolean isNull() {
        return isNull;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public void setOld_cfName(String old_cfName) {
        this.old_cfName = old_cfName;
    }

    public void setMethod(byte method) {
        this.method = method;
    }
    
    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setNull(boolean isNull) {
        this.isNull=isNull;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+cfName.getBytes().length+4 +old_cfName.getBytes().length+
                4+min.getBytes().length+4+max.getBytes().length+1+1+1+1];
        int pos=0;
        byte uni=0;
        byte isNil=0;
        if (unique){
            uni=1;
        }
        if (isNull){
            isNil=1;
        }
        
        pos= Bytes.putInt(bytes,pos,cfName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,cfName.getBytes(),0,cfName.getBytes().length);

        pos= Bytes.putInt(bytes,pos,old_cfName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,old_cfName.getBytes(),0,old_cfName.getBytes().length);

        pos= Bytes.putInt(bytes,pos,min.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,min.getBytes(),0,min.getBytes().length);

        pos= Bytes.putInt(bytes,pos,max.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,max.getBytes(),0,max.getBytes().length);

        pos=Bytes.putByte(bytes,pos,type);

        pos=Bytes.putByte(bytes,pos,method);

        pos=Bytes.putByte(bytes,pos,uni);

        pos=Bytes.putByte(bytes,pos,isNil);

        return bytes;
    }
}
