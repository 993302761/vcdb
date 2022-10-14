package org.example.vcdb.store.service;

import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.DB;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.dbServiceGrpc;

public class dbService extends dbServiceGrpc.dbServiceImplBase{
    @Override
    public void createDB(DB.createRequest request, StreamObserver<Version.intReply> responseObserver) {
        //获取传入的dbName
        String dbName = request.getDBName();
        System.out.println(dbName);

        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteDB(DB.deleteRequest request, StreamObserver<Version.intReply> responseObserver) {

        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }
}
