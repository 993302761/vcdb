package org.example.vcdb.store.region;

import org.example.vcdb.util.Bytes;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RegionServerMeta
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/17 下午9:29
 * @Version 1.0
 */
/*
* dbName,table,cfName----------regionMetaName*/
public class RegionServerMeta {
    /*db.tableName-------->regionMetaName*/
    byte[] metaByte;

    public RegionServerMeta(byte[] data){
        this.metaByte=data;
    }

    public RegionServerMeta(String metaName,byte[] ip4,
                            int rsPort,Map<String,TableTrailer> regionMap){
        metaByte=new byte[1024*4];
        int pos=0;
        pos=Bytes.putInt(this.metaByte,pos,metaName.getBytes().length);
        pos = Bytes.putBytes(this.metaByte, pos, metaName.getBytes(), 0,metaName.getBytes().length);
        for (byte b:ip4){
            pos=Bytes.putByte(this.metaByte,pos,b);
        }
        pos=Bytes.putInt(this.metaByte,pos,rsPort);
        pos=Bytes.putInt(this.metaByte,pos,regionMap.size());
        for (Map.Entry<String,TableTrailer> entry : regionMap.entrySet()) {
            pos=Bytes.putInt(this.metaByte,pos,entry.getKey().getBytes().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getKey().getBytes(), 0, entry.getKey().getBytes().length);
            pos=Bytes.putInt(this.metaByte,pos,entry.getValue().getData().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getValue().getData(), 0, entry.getValue().getData().length);
        }
    }

    public int getNameLength(){
        return Bytes.toInt(this.metaByte,0,4);
    }

    public String getName(){
        return Bytes.toString(this.metaByte,4,getNameLength());
    }
    public byte[] getIp4(){
        return Bytes.subByte(this.metaByte,4+getNameLength(),4);
    }
    public int getRSPort(){
        return Bytes.toInt(this.metaByte,8+getNameLength(),4);
    }
    public int getMapCount(){
        return Bytes.toInt(this.metaByte,12+getNameLength(),4);
    }

    /*db.tableName-------->regionMetaName*/
    public Map<String,TableTrailer> getRegionMap(){
        Map<String,TableTrailer> map=new ConcurrentHashMap<>();
        int pos=16+getNameLength();
        for (int i = 0; i < getMapCount(); i++) {
            int length1=Bytes.toInt(this.metaByte,pos,4);
            pos+=4;
            String tableName=Bytes.toString(this.metaByte,pos,length1);
            pos+=length1;
            int length2=Bytes.toInt(this.metaByte,pos,4);
            pos+=4;
            TableTrailer tableTrailer=new TableTrailer(Bytes.subByte(this.metaByte,pos,length2))  ;
            pos+=length2;
            map.put(tableName,tableTrailer);
        }
        return map;
    }

    public void dis(){
        System.out.println(getNameLength());
        System.out.println(getName());
        System.out.println(Arrays.toString(getIp4()));
        System.out.println(getRSPort());
        System.out.println(getMapCount());
        System.out.println(getRegionMap());
    }

    public byte[] getData() {
        return this.metaByte;
    }

    public void setRegionMap(Map<String, TableTrailer> regionMap) {
        int pos=12+getNameLength();
        pos=Bytes.putInt(this.metaByte,pos,regionMap.size());
        for (Map.Entry<String,TableTrailer> entry : regionMap.entrySet()) {
            pos=Bytes.putInt(this.metaByte,pos,entry.getKey().getBytes().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getKey().getBytes(), 0, entry.getKey().getBytes().length);
            pos=Bytes.putInt(this.metaByte,pos,entry.getValue().getData().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getValue().getData(), 0, entry.getValue().getData().length);
        }
    }

}
