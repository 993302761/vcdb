package org.example.vcdb.store.service;


import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Meta;
import org.example.vcdb.store.proto.getRegionMetaGrpc;

public class RegionService extends getRegionMetaGrpc.getRegionMetaImplBase{

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
}
