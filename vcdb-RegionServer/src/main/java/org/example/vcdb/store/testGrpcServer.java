package org.example.vcdb.store;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.vcdb.store.region.RegionServer;
import org.example.vcdb.store.service.dbService;


import java.io.IOException;

public class testGrpcServer {

    private static final int port=9999;



    public static void dbServiceStart() throws InterruptedException, IOException {
        // new dbService()  代表dbService服务 可以切换别的服务
        Server server=ServerBuilder.forPort(port).addService(new dbService()).build().start();
        System.out.println("开启dbService服务");
        //等待服务关闭
        server.awaitTermination();
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        dbServiceStart();
    }
}