package com.example.vcdb;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateDB;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.executor.VCDBAdmin;
import org.example.vcdb.proto.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class protoTest {



    @Test
    public void CommunicationTest(){
        VCDBAdmin vcdbAdmin=new VCDBAdmin();
        vcdbAdmin.createDB("123",null);
    }

    @Test
    public void testSingleSearch(){
//        //建立一个传输文本的通道
//        ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
//        try {
//            //使用同步的方式进行消息传递
//            searchServiceGrpc.searchServiceBlockingStub blockingStub = searchServiceGrpc.newBlockingStub(build);
//            Search.SingleSearch.Builder s=Search.SingleSearch.newBuilder();
//            ByteString a=ByteString.copyFrom("999".getBytes());
//            s.setAggregate(a);
//            Search.singleSearchRequest request = Search.singleSearchRequest.newBuilder()
//                    .setDBName("123")
//                    .setTabName("123")
//                    .setSingleSearch(s)
//                    .build();
//            Version.bytesReply db = blockingStub.singleSearch(request);
//            ByteString reply = db.getReply();
//            System.out.println(reply.toString());
//        }finally {
//            build.shutdown();
//        }
    }
}
