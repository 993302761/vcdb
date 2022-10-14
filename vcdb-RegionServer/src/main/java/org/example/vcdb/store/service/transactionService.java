package org.example.vcdb.store.service;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Transaction;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.transactionServiceGrpc;

public class transactionService extends transactionServiceGrpc.transactionServiceImplBase{
    @Override
    public void openTransaction(Transaction.openTransactionRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void closeTransaction(Empty request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }
}
