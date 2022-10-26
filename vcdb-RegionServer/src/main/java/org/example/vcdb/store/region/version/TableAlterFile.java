package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class TableAlterFile {

    byte[] data;

    public TableAlterFile(List<TableAlter> tableAlters){
        this.data=new byte[1024*4];
        int pos=0;
        int count=tableAlters.size();
        pos= Bytes.putInt(this.data,pos,count);
        for (TableAlter tableAlter:tableAlters){
            pos = Bytes.putInt(this.data,pos,tableAlter.getData().length);
            pos = Bytes.putBytes(this.data, pos, tableAlter.getData(), 0,tableAlter.getData().length);
        }
    }

    public TableAlterFile(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public List<TableAlter> getTableAlters(){
        List<TableAlter> tableAlters=new ArrayList<>();
        int pos=0;
        int count=Bytes.toInt(this.data,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int tableAlterLength=Bytes.toInt(this.data,pos,4);
            pos+=4;
            tableAlters.add(new TableAlter(Bytes.subByte(this.data,pos,tableAlterLength)));
            pos+=tableAlterLength;
        }
        return tableAlters;
    }
}
