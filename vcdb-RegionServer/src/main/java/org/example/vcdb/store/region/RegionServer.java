package org.example.vcdb.store.region;

import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.Region.VCRegion;

import java.net.Inet4Address;
import java.util.List;

public class RegionServer {
    Inet4Address RegionServerIP;
    int RSPort;
    List<VCRegion> vcRegion;
    public void readConfig(){

    }

    //接受rpc调用
    public RegionMeta getRegionMeta(){
        return null;
    }
}
