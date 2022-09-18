package org.example.vcdb.store.region;

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

    public RegionServerMeta(Inet4Address regionServerIP,int rsPort,Map<String,String> regionMap){

    }
}
