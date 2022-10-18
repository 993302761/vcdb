package org.example.vcdb.entity.Cell;

import org.example.vcdb.util.Bytes;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class JTableCell {
    /**
     * tabname : 表名
     * method : inner/left/right/full
     */

    private String tableName;
    private String method;

    public String getTableName() {
        return tableName;
    }

    public String getMethod() {
        return method;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public byte[] toByteArray(){
        byte[] bytes=new byte[4+tableName.getBytes().length+4+method.getBytes().length];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,tableName.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,tableName.getBytes(),0,tableName.getBytes().length);
        pos= Bytes.putInt(bytes,pos,method.getBytes().length);
        pos=Bytes.putBytes(bytes,pos,method.getBytes(),0,method.getBytes().length);
        return bytes;
    }
}
