package org.example.vcdb.store.region;

import java.net.Inet4Address;

public class RegionServer {
    Inet4Address RegionServerIP;
    int RSPort;
    VCRegion vcRegion;
    public void readConfig(){

    }

    //接受rpc调用
    public RegionServerMeta getRegionMeta(){
        return null;
    }
}
