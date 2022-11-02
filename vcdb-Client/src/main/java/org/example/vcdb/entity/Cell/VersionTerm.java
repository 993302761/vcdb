package org.example.vcdb.entity.Cell;

import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class VersionTerm {
    String rowKey;
    String cfName;
    int versionFrom=-1;
    int versionTo=-1;

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+rowKey.getBytes().length+4+cfName.getBytes().length+4+4];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,rowKey.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,rowKey.getBytes(),0,rowKey.getBytes().length);

        pos= Bytes.putInt(bytes,pos,cfName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,cfName.getBytes(),0,cfName.getBytes().length);

        pos= Bytes.putInt(bytes,pos,versionFrom);

        pos= Bytes.putInt(bytes,pos,versionTo);
        return bytes;
    }

    public void setVersionFrom(int versionFrom) {
        this.versionFrom = versionFrom;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public void setVersionTo(int versionTo) {
        this.versionTo = versionTo;
    }

    public void setCfName(String cfName){
        this.cfName=cfName;
    }

    public int getVersionFrom() {
        return versionFrom;
    }

    public String getRowKey() {
        return rowKey;
    }

    public int getVersionTo() {
        return this.versionTo;
    }

    public String getCfName(){
        return this.cfName;
    }
}
