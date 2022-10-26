package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class DataBaseFile {
    byte[] data;
    public DataBaseFile(List<DataBase> dataBases){
        this.data=new byte[1024*4];
        int pos=0;
        int count=dataBases.size();
        pos= Bytes.putInt(this.data,pos,count);
        for (DataBase dataBase:dataBases){
            pos = Bytes.putInt(this.data,pos,dataBase.getData().length);
            pos = Bytes.putBytes(this.data, pos, dataBase.getData(), 0,dataBase.getData().length);
        }
    }

    public DataBaseFile(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public List<DataBase> getDataBases(){
        List<DataBase> dataBases=new ArrayList<>();
        int pos=0;
        int count=Bytes.toInt(this.data,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int dataBaseLength=Bytes.toInt(this.data,pos,4);
            pos+=4;
            dataBases.add(new DataBase(Bytes.subByte(this.data,pos,dataBaseLength)));
            pos+=dataBaseLength;
        }
        return dataBases;
    }
}
