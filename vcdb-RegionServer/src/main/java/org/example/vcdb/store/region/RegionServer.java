package org.example.vcdb.store.region;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.proto.Meta;
import org.example.vcdb.store.proto.getRegionMetaGrpc;
import org.example.vcdb.store.region.Region.VCRegion;
import java.util.List;

public class RegionServer extends getRegionMetaGrpc.getRegionMetaImplBase{
    List<MemStore> memStores;
    String regionServerMetaName;
    RegionServerMeta regionServerMeta;
    //cache for region
    List<VCRegion> loadOnRegion;

    public void readConfig(){

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
