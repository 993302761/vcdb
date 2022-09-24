package org.example.vcdb.store.region;

import org.example.vcdb.util.Bytes;

import java.net.Inet4Address;
import java.util.Map;

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
    Inet4Address regionServerIP;
    int RSPort;
    Map<String,String> regionMap;
    /*db.tableName-------->regionMetaName*/
    byte[] metaByte;

    public RegionServerMeta(String metaName,Inet4Address regionServerIP,
                            int rsPort,Map<String,String> regionMap){
        metaByte=new byte[1024*4];
        int pos=0;
        pos=Bytes.putInt(this.metaByte,pos,metaName.getBytes().length);
        pos = Bytes.putBytes(this.metaByte, pos, metaName.getBytes(), 0,metaName.getBytes().length);
        for (byte b:regionServerIP.getAddress()){
            pos=Bytes.putByte(this.metaByte,pos,b);
        }
        pos=Bytes.putInt(this.metaByte,pos,rsPort);
        pos=Bytes.putInt(this.metaByte,pos,regionMap.size());
        for (Map.Entry<String,String> entry : regionMap.entrySet()) {
            pos=Bytes.putInt(this.metaByte,pos,entry.getKey().getBytes().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getKey().getBytes(), 0, entry.getKey().getBytes().length);
        }
    }
    /*db.tableName-------->regionMetaName*/
    public Map<String,String> getRegionMap(){
        return null;
    }

}
