package org.example.vcdb.store.service;

import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Table;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.tableServiceGrpc;

public class tableService extends tableServiceGrpc.tableServiceImplBase{
    @Override
    public void createTable(Table.createRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void alterTable(Table.alterRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void deleteTable(Table.deleteRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }
}
