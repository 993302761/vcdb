package org.example.vcdb.store.region;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.proto.Meta;
import org.example.vcdb.store.proto.getRegionMetaGrpc;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.Region.VCRegion;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import java.util.List;
import java.util.Map;

public class RegionServer extends getRegionMetaGrpc.getRegionMetaImplBase{
    List<MemStore> memStores;
    String regionServerMetaName;
    static RegionServerMeta regionServerMeta;
    //cache for region
    List<VCRegion> loadOnRegion;

    public void readConfig(){

    }

    public static List<KVRange> getPageTrailer(String metaName){
        String[] str=metaName.split(":");
        RegionMeta regionMeta = getRegionMeta(str[0]);
        FileStoreMeta fileStoreMeta = regionMeta.getFileStoreMeta(str[1]);
        return fileStoreMeta.getPageTrailer();
    }

    public static RegionMeta getRegionMeta(String tableName){
        //取出的应该缓存
        Map<String, String> regionMap = regionServerMeta.getRegionMap();
        return new RegionMeta(VCFileReader.readAll(regionMap.get(tableName))) ;
    }

    //接受rpc调用
    //获取元数据
    // responseObserver 为返回值
    @Override
    public void getRegionMeta(Empty request, StreamObserver<Meta.regionMeta> responseObserver) {
        Meta.regionMeta regionMeta= null;
        //获取元数据

        //返回元数据
        responseObserver.onNext(regionMeta);
        //告知本次处理完毕
        responseObserver.onCompleted();
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
