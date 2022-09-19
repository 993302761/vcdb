package org.example.vcdb.PDServer;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.vcdb.PDServer.proto.Meta;
import org.example.vcdb.PDServer.proto.getRegionMetaGrpc;

public class testClient {

    public static void main(String[] args) {
        //建立一个传输文本的通道
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9999).usePlaintext().build();

        //拿到远程调用存根，并用同步模式进行消息传递
        getRegionMetaGrpc.getRegionMetaBlockingStub blockingStub=getRegionMetaGrpc.newBlockingStub(channel);

        Meta.regionMeta regionMeta = blockingStub.getRegionMeta(null);
        ByteString metaByte = regionMeta.getMetaByte();
        System.out.println(metaByte);
        channel.shutdown();
    }
}
