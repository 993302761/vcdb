package org.example.vcdb.entity.Cell;


import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */


public class ColumnFamilyCell{
    private String cf_name;
    private byte type=100;
    private String min;
    private String max;
    private Boolean unique;
    private Boolean isNull;


    public String getCf_name() {
        return cf_name;
    }

    public byte getType() {
        return type;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public Boolean isUnique() {
        return unique;
    }

    public Boolean isNull() {
        return isNull;
    }




    public void setCf_name(String cf_name) {
        this.cf_name = cf_name;
    }

    public void setType(byte type) {
        this.type = type;
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

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+cf_name.getBytes().length+1+8+8+1+1];
        byte uni=0;
        byte isNil=0;
        if (unique==null){
        }else if (unique){
            uni=1;
        }
        if (isNull==null){
        }else if (isNull){
            isNil=1;
        }
        int pos=0;
        pos= Bytes.putInt(bytes,pos,cf_name.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,cf_name.getBytes(),0,cf_name.getBytes().length);

        pos= Bytes.putInt(bytes,pos,min.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,min.getBytes(),0,min.getBytes().length);

        pos= Bytes.putInt(bytes,pos,max.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,max.getBytes(),0,max.getBytes().length);

        pos=Bytes.putByte(bytes,pos,type);
        pos=Bytes.putByte(bytes,pos,uni);
        pos=Bytes.putByte(bytes,pos,isNil);
        return bytes;
    }

}
