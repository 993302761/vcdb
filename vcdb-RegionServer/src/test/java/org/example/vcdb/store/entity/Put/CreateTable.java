package org.example.vcdb.store.entity.Put;

import org.example.vcdb.store.entity.Cell.ColumnFamilyCell;
import org.example.vcdb.store.entity.Post.RequestEntity;
import org.example.vcdb.util.Bytes;

import java.util.List;


/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class CreateTable extends RequestEntity {

    private List<ColumnFamilyCell> column_family;

    public byte[] toByteArray(){
        int valueLength=0;
        for (ColumnFamilyCell columnFamilyCell:column_family){
            valueLength += columnFamilyCell.toByteArray().length;
        }
        byte[] bytes=new byte[4+valueLength];
        int count=this.column_family.size();
        int pos=0;
        pos=Bytes.putInt(bytes,pos,count);
        for (ColumnFamilyCell columnFamilyCell:column_family){
            pos=Bytes.putBytes(bytes,pos,columnFamilyCell.toByteArray(),0,columnFamilyCell.toByteArray().length);
        }
        return bytes;
    }
    public void setColumn_family(List<ColumnFamilyCell> column_family) {
        this.column_family = column_family;
    }
}