package org.example.vcdb.store.service;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.proto.Search;
import org.example.vcdb.store.proto.Version;
import org.example.vcdb.store.proto.searchServiceGrpc;

import java.nio.charset.StandardCharsets;

public class searchService extends searchServiceGrpc.searchServiceImplBase{
    @Override
    public void multiSearch(Search.multiSearchRequest request, StreamObserver<Version.bytesReply> responseObserver) {
        //生成返回对象
        Version.bytesReply.Builder builder = Version.bytesReply.newBuilder();
        String s="666";
        builder.setReply(ByteString.copyFrom(s.getBytes(StandardCharsets.UTF_8)));
        Version.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }

    @Override
    public void singleSearch(Search.singleSearchRequest request, StreamObserver<Version.bytesReply> responseObserver) {
        //生成返回对象
        Version.bytesReply.Builder builder = Version.bytesReply.newBuilder();
        String s="666";
        builder.setReply(ByteString.copyFrom(s.getBytes(StandardCharsets.UTF_8)));
        Version.bytesReply reply=builder.build();

        //返回
        responseObserver.onNext(reply);
    }
}
