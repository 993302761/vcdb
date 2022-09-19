package org.example.vcdb.store;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.vcdb.store.service.RegionService;

import java.io.IOException;

public class testGrpcServer {

    private static final int port=9999;

    public static void main(String[] args) {
        try {
            Server server= ServerBuilder.forPort(port).addService(new RegionService()).build().start();
            System.out.println("GRPC启动成功，端口号为"+port);
            //等待服务关闭
            server.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
