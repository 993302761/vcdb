package org.example.vcdb.store.service;

import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Cells;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.cellsServiceGrpc;

public class cellService extends cellsServiceGrpc.cellsServiceImplBase{
    @Override
    public void putCells(Cells.putCellsRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void deleteCells(Cells.deleteCellsRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void updateCells(Cells.updateCellsRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();
        //返回
        responseObserver.onNext(reply);
    }
}
