package org.example.vcdb.store.region;

import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.Region.VCRegion;
import java.util.List;

public class RegionServer {
    String regionServerMetaName;
    RegionServerMeta regionServerMeta;
    List<VCRegion> vcRegion;
    public void readConfig(){

    }

    //接受rpc调用
    public RegionMeta getRegionMeta(){
        return null;
    }
}
