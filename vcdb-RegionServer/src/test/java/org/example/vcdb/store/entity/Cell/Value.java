package org.example.vcdb.store.entity.Cell;

import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class Value {
    /**
     * cf_name : 列族名称
     * c_name : 列名
     * value : 值
     */
    private String cf_name;
    private String c_name;
    private String value;

    public String getCf_name() {
        return cf_name;
    }

    public String getC_name() {
        return c_name;
    }

    public String getValue() {
        return value;
    }

    public void setCf_name(String cf_name) {
        this.cf_name = cf_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+cf_name.getBytes().length+4+c_name.getBytes().length+4+value.getBytes().length];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,cf_name.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,cf_name.getBytes(),0,cf_name.getBytes().length);

        pos= Bytes.putInt(bytes,pos,c_name.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,c_name.getBytes(),0,c_name.getBytes().length);

        pos= Bytes.putInt(bytes,pos,value.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,value.getBytes(),0,value.getBytes().length);

        return bytes;
    }

}
