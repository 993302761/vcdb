package org.example.vcdb.store;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.region.Region.VCRegion;
import org.example.vcdb.store.region.RegionServerAPI;
import org.example.vcdb.store.region.RegionServerMeta;
import org.example.vcdb.store.region.version.DataBase;
import org.example.vcdb.store.region.version.Table;
import org.example.vcdb.store.region.version.TableAlter;
import org.example.vcdb.store.region.version.Transaction;
import org.example.vcdb.store.service.RegionService;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegionServer {
    //cache for fileStores

    //操作缓存部分
    //事务记录
    /*IP4host:explainValue----startTime----endTime*/
    public static Map<String, Transaction> transactionMap=new ConcurrentHashMap<>() ;

    //库表结构操作记录
    /*dbName-------timeStamp*/
    public static Map<String, DataBase> dbMap=new ConcurrentHashMap<>();

    /*tableName------timeStamp*/
    public static Map<String, Table> tableMap=new ConcurrentHashMap<>();

    /*tableName:cfName-------timeStamp*/
    public static Map<String, TableAlter> tableAlterMap=new ConcurrentHashMap<>();


    //数据缓存部分
    //负责接收sql请求的KV
    public static Map<String, MemStore> inboundMemStore=new ConcurrentHashMap<>();

    //负责接收从文件加载过来的的KV
    public static Map<String,MemStore> outboundMemStore=new ConcurrentHashMap<>();


    public static RegionServerMeta regionServerMeta=new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));

    //cache for region
    List<VCRegion> loadOnRegion;

    private static final int port=9999;



    public static void dbServiceStart() throws InterruptedException, IOException {
        // new dbService()  代表dbService服务 可以切换别的服务
        Server server=ServerBuilder.forPort(port).addService(new RegionService()).build().start();
        System.out.println("开启服务");
        //等待服务关闭
        server.awaitTermination();
    }

    public static void test(){
        System.out.println("ttttt");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        testMem.tet();
        dbServiceStart();
    }

    public static void readConfig(String regionServerMeta) {
        RegionServer.regionServerMeta = new RegionServerMeta(VCFileReader.readAll(regionServerMeta));
    }
}