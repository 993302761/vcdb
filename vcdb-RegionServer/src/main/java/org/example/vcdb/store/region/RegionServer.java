package org.example.vcdb.store.region;

import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.region.Region.VCRegion;
import java.util.List;

public class RegionServer {
    String regionServerMetaName;
    RegionServerMeta regionServerMeta;
    //cache for region
    List<VCRegion> loadOnRegion;

    public void readConfig(){

    }

    //接受rpc调用
    //获取元数据
    public byte[] getRegionMeta(){
        return null;
    }
    //添加数据集合
    public int addKVSet(KeyValueSkipListSet kvSet){
        return 1;
    }
    //合并KV里的ValueNode
    public int MergeKV(String dbName,String tableName,String cfName,String rowKey,int versionFrom,int versionTo){
        return 1;
    }
}
