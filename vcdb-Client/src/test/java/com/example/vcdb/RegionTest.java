package com.example.vcdb;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.vcdb.proto.Region;
import org.example.vcdb.proto.RegionServerGrpc;
import org.junit.Test;

public class RegionTest {

    @Test
    public void createDB(){
        //建立一个传输文本的通道
        ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
        try {
            //使用同步的方式进行消息传递
            RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
            Region.dbNameRequest request = Region.dbNameRequest.newBuilder()
                    .setDBName("123")
                    .build();
            Region.boolReply db = blockingStub.createDB(request);
            boolean reply = db.getReply();
            System.out.println(reply);
        }finally {
            build.shutdown();
        }
    }

    @Test
    public  void putCells(){
        //建立一个传输文本的通道
        ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
        try {
            //使用同步的方式进行消息传递
            RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
            Region.putCellsRequest request = Region.putCellsRequest.newBuilder()
                    .setDBName("123")
                    .setTabName("456")
                    .setRowKey("56")
                    .build();
            Region.intReply intReply = blockingStub.putCells(request);
            int reply = intReply.getReply();
            System.out.println(reply);
        }finally {
            build.shutdown();
        }
    }

    @Test
    public  void multiSearch(){
        //建立一个传输文本的通道
        ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
        try {
            //使用同步的方式进行消息传递
            RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
            Region.multiSearchRequest request = Region.multiSearchRequest.newBuilder()
                    .setDBName("123")
                    .build();
            Region.bytesReply db = blockingStub.multiSearch(request);
            ByteString reply = db.getReply();
            System.out.println(reply);
        }finally {
            build.shutdown();
        }
    }
}
