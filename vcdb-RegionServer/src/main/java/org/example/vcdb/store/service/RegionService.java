package org.example.vcdb.store.service;

import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Region;
import org.example.vcdb.store.proto.RegionServerGrpc;

public class RegionService extends RegionServerGrpc.RegionServerImplBase{
    @Override
    public void createDB(Region.dbNameRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //获取传入的dbName
        String dbName = request.getDBName();
        System.out.println(dbName);

        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(true);
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteDB(Region.dbNameRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.deleteDB(request, responseObserver);
    }

    @Override
    public void showDataBases(Empty request, StreamObserver<Region.bytesReply> responseObserver) {
        super.showDataBases(request, responseObserver);
    }

    @Override
    public void putCells(Region.putCellsRequest request, StreamObserver<Region.intReply> responseObserver) {
        //获取传入的dbName
        String dbName = request.getDBName();
        System.out.println(dbName);

        //生成返回对象
        Region.intReply.Builder builder = Region.intReply.newBuilder();
        builder.setReply(546);
        Region.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCells(Region.deleteCellsRequest request, StreamObserver<Region.intReply> responseObserver) {
        super.deleteCells(request, responseObserver);
    }

    @Override
    public void updateCells(Region.updateCellsRequest request, StreamObserver<Region.intReply> responseObserver) {
        super.updateCells(request, responseObserver);
    }

    @Override
    public void multiSearch(Region.multiSearchRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        //获取传入的dbName
        String dbName = request.getDBName();
        System.out.println(dbName);

        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFromUtf8("123"));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void singleSearch(Region.singleSearchRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        super.singleSearch(request, responseObserver);
    }

    @Override
    public void createTable(Region.tableRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.createTable(request, responseObserver);
    }

    @Override
    public void alterTable(Region.tableRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.alterTable(request, responseObserver);
    }

    @Override
    public void deleteTable(Region.tableNameRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.deleteTable(request, responseObserver);
    }

    @Override
    public void showTables(Region.dbNameRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        super.showTables(request, responseObserver);
    }

    @Override
    public void forCreateTable(Region.tableRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.forCreateTable(request, responseObserver);
    }

    @Override
    public void openTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.openTransaction(request, responseObserver);
    }

    @Override
    public void closeTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.closeTransaction(request, responseObserver);
    }

    @Override
    public void showTransaction(Empty request, StreamObserver<Region.bytesReply> responseObserver) {
        super.showTransaction(request, responseObserver);
    }

    @Override
    public void deleteTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.deleteTransaction(request, responseObserver);
    }

    @Override
    public void useTransaction(Region.useTransactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.useTransaction(request, responseObserver);
    }

    @Override
    public void deleteVersion(Region.versionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.deleteVersion(request, responseObserver);
    }

    @Override
    public void mergeVersion(Region.mergeVersionRequest request, StreamObserver<Region.intReply> responseObserver) {
        super.mergeVersion(request, responseObserver);
    }

    @Override
    public void useVersion(Region.versionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        super.useVersion(request, responseObserver);
    }

    @Override
    public void showVersion(Region.showVersionRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        super.showVersion(request, responseObserver);
    }
}
