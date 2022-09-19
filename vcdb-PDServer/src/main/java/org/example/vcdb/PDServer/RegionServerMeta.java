package org.example.vcdb.PDServer;

import java.net.Inet4Address;
import java.util.Map;


/*db.tableName-------->regionMetaName*/
public class RegionServerMeta {
    String metaName;
    Inet4Address regionServerIP;
    int RSPort;
    Map<String,String> regionMap;


    public RegionServerMeta(byte[] metaByte){

    }
}
