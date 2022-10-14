package org.example.vcdb.store.service;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.versionServiceGrpc;

import java.nio.charset.StandardCharsets;

public class versionService extends versionServiceGrpc.versionServiceImplBase{
    @Override
    public void deleteVersion(Version.deleteRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void mergeVersion(Version.mergeRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void useVersion(Version.useRequest request, StreamObserver<Version.intReply> responseObserver) {
        //生成返回对象
        Version.intReply.Builder builder = Version.intReply.newBuilder();
        builder.setReply(666);
        Version.intReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void showVersion(Version.showRequest request, StreamObserver<Version.bytesReply> responseObserver) {
        //生成返回对象
        Version.bytesReply.Builder builder = Version.bytesReply.newBuilder();
        String s="666";
        builder.setReply(ByteString.copyFrom(s.getBytes(StandardCharsets.UTF_8)));
        Version.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }
}
