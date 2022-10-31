package org.example.vcdb.store.service;

import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Region;
import org.example.vcdb.store.proto.RegionServerGrpc;
import org.example.vcdb.store.region.RegionServerAPI;

public class RegionService extends RegionServerGrpc.RegionServerImplBase{

    @Override
    public void createDB(Region.dbNameRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.createDB(request.getDBName()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteDB(Region.dbNameRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.deleteDB(request.getDBName()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void showDataBases(Empty request, StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFrom(RegionServerAPI.showDataBases()));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void putCells(Region.putCellsRequest request, StreamObserver<Region.intReply> responseObserver) {
        //生成返回对象
        Region.intReply.Builder builder = Region.intReply.newBuilder();
        builder.setReply(RegionServerAPI.putCells(request.getDBName(),request.getTabName(),
                request.getRowKey(), request.getRequestEntity().toByteArray()));
        Region.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCells(Region.deleteCellsRequest request, StreamObserver<Region.intReply> responseObserver) {

        //生成返回对象
        Region.intReply.Builder builder = Region.intReply.newBuilder();
        builder.setReply(RegionServerAPI.deleteCells(request.getDBName(),request.getTabName(),
                request.getCfNames().toByteArray(), request.getTerms().toByteArray()));
        Region.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void updateCells(Region.updateCellsRequest request, StreamObserver<Region.intReply> responseObserver) {

        //生成返回对象
        Region.intReply.Builder builder = Region.intReply.newBuilder();
        builder.setReply(RegionServerAPI.updateCells(request.getDBName(),request.getTabName(),
                request.getTerms().toByteArray(), request.getValues().toByteArray()));
        Region.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void multiSearch(Region.multiSearchRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFromUtf8("multiSearch 现在不支持"));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void singleSearch(Region.singleSearchRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFrom(RegionServerAPI.singleSearch(request.getDBName(),request.getTabName(),
                request.getLimit(),request.getOrderCfName(),request.getSort(),
                request.getCfNames().toByteArray(),request.getTerms().toByteArray())));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void createTable(Region.tableRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.createTable(request.getDBName(),request.getTabName(),
                request.getRequestEntity().toByteArray()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void alterTable(Region.tableRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.alterTable(request.getDBName(),request.getTabName(),
                request.getRequestEntity().toByteArray()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteTable(Region.tableNameRequest request,
                            StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.deleteTable(request.getTabName()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void showTables(Region.dbNameRequest request,
                           StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFrom(RegionServerAPI.showTables(request.getDBName())));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void forCreateTable(Region.tableRequest request,
                               StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.createTable(request.getDBName(),request.getTabName(),
                request.getRequestEntity().toByteArray()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void openTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.openTransaction(request.getExplainValue()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void closeTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.closeTransaction(request.getExplainValue()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void showTransaction(Empty request, StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFrom(RegionServerAPI.showTransaction()));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteTransaction(Region.transactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.deleteTable(request.getExplainValue()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void useTransaction(Region.useTransactionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.useTransaction(request.getExplainValue(),request.getNewExplainValue()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void deleteVersion(Region.versionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.deleteVersion(request.getDBName(),request.getTabName(),request.getRowKey(),
                request.getCfName(),request.getVersion()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void mergeVersion(Region.mergeVersionRequest request, StreamObserver<Region.intReply> responseObserver) {
        //生成返回对象
        Region.intReply.Builder builder = Region.intReply.newBuilder();
        builder.setReply(RegionServerAPI.mergeVersion(request.getDBName(),request.getTabName(),
                request.getRequestEntity().toByteArray()));
        Region.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void useVersion(Region.versionRequest request, StreamObserver<Region.boolReply> responseObserver) {
        //生成返回对象
        Region.boolReply.Builder builder = Region.boolReply.newBuilder();
        builder.setReply(RegionServerAPI.useVersion(request.getDBName(),request.getTabName(),
                request.getRowKey(),request.getCfName(),request.getVersion()));
        Region.boolReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }

    @Override
    public void showVersion(Region.showVersionRequest request, StreamObserver<Region.bytesReply> responseObserver) {
        //生成返回对象
        Region.bytesReply.Builder builder = Region.bytesReply.newBuilder();
        builder.setReply(ByteString.copyFrom(RegionServerAPI.showVersion(request.getDBName(),request.getTabName(),
                request.getRowKey(),request.getCfName())));
        Region.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);

        //通知网络，本次服务完毕
        responseObserver.onCompleted();
    }
}
