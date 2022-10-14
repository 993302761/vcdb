package org.example.vcdb.entity.Post;



import org.example.vcdb.entity.Cell.ColumnFamilyCell;
import org.example.vcdb.entity.Cell.Value;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class PutCells extends RequestEntity {
    private String rowKey;

    private List<Value> values;

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public byte[] valuesToByteArray(){
        int valuesLength=0;
        for (Value value:values){
            valuesLength += 4+value.toByteArray().length;
        }
        byte[] bytes=new byte[4+valuesLength];
        int count=this.values.size();
        int pos=0;
        Bytes.putInt(bytes,pos,count);
        for (Value value:values){
            Bytes.putInt(bytes,pos,value.toByteArray().length);
            Bytes.putBytes(bytes,pos,value.toByteArray(),0,value.toByteArray().length);
        }
        return bytes;
    }
    public int getCount(){
        return values.size();
    }
}


