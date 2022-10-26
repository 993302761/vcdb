package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class TableFile {
    byte[] data;
    public TableFile(List<Table> tables){
        this.data=new byte[1024*4];
        int pos=0;
        int count=tables.size();
        for (Table table:tables){
            pos = Bytes.putInt(this.data,pos,table.getData().length);
            pos = Bytes.putBytes(this.data,pos,table.getData(),0,table.getData().length);
        }
    }

    public TableFile(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public List<Table> getTables(){
        List<Table> tables=new ArrayList<>();
        int pos=0;
        int count=Bytes.toInt(this.data,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int tableLength=Bytes.toInt(this.data,pos,4);
            pos+=4;
            tables.add(new Table(Bytes.subByte(this.data,pos,tableLength)));
            pos+=tableLength;
        }
        return tables;
    }
}
