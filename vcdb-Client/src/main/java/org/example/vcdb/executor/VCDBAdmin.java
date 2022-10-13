package org.example.vcdb.executor;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.vcdb.config.ClientConfig;
import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateDB;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.proto.DB;
import org.example.vcdb.proto.Version;
import org.example.vcdb.proto.dbServiceGrpc;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.wal.VCLog;
import org.example.vcdb.store.wal.WalBuffer;
import org.example.vcdb.store.wal.WalEdit;

import java.util.Date;

import static org.example.vcdb.store.mem.KV.byteToType;

public class VCDBAdmin {
    ClientConfig clientConfig;
    WalBuffer walBuffer;


    private final static String host="localhost";
    //服务端口号
    private final static int serverPort=9999;


//-----------------------------------------------------------------------------------


    //return int(返回改动KV的数量)
    public void createDB(String dBName, CreateDB createDB) {
        //建立一个传输文本的通道
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        try {

            //使用同步的方式进行消息传递
            dbServiceGrpc.dbServiceBlockingStub blockingStub = dbServiceGrpc.newBlockingStub(build);
            DB.createRequest request = DB.createRequest.newBuilder()
                    .setDBName("123")
                    .build();
            Version.intReply db = blockingStub.createDB(request);
            int reply = db.getReply();
            System.out.println(reply);
        }finally {
            build.shutdown();
        }

    }

    //return int(返回改动KV的数量)
    public void deleteDB(String dBName,DeleteCells deleteCells) {

    }


//-----------------------------------------------------------------------------------



    //return int(返回改动KV的数量)
    public void createTable(String dBName,String tabName,CreateTable createTable) {

    }

    //return int(是否成功)
    public void alterTable(String dBName,String tabName,AlterTable alterTable) {

    }

    //return int(返回改动KV的数量)
    public void deleteTable(String dBName,String tabName,DeleteTable deleteTable) {

    }



//-----------------------------------------------------------------------------------



    //return int(返回改动KV的数量)
    public void deleteVersion(String dBName,String tabName,DeleteVersion requestEntity) {
    }

    //return int(查询的返回KV的数量)
    public void mergeVersion(String dBName,String tabName,MergeVersion mergeVersion) {

    }

    //return int(返回改动KV的数量)
    public void useVersion(String dBName,String tabName,UseVersion useVersion) {

    }

    //return byte[](查询的返回KV)
    public void showVersion(String dBName,String tabName,ShowVersion showVersion) {

    }





//-----------------------------------------------------------------------------------




    //return int(是否成功)
    public void openTransaction(OpenTransaction openTransaction) {

    }

    //return int(是否成功)
    public void closeTransaction(CloseTransaction closeTransaction) {

    }


//-----------------------------------------------------------------------------------




    //return int(返回改动KV的数量)
    public void putCells(String dBName,String tabName,PutCells putCells) {

    }



    //return int(返回改动KV的数量)
    public void deleteCells(String dBName,String tabName,DeleteCells deleteCells) {

    }

    //return int(返回改动KV的数量)
    public void updateCells(String dBName,String tabName,UpdateCells updateCells) {

    }


//-----------------------------------------------------------------------------------



    //return byte[](查询的返回KV)
    public void multiSearch(String dBName,String tabName,MultiSearch multiSearch) {

    }


    //return byte[](查询的返回KV)
    public void singleSearch(String dBName,String tabName,SingleSearch singleSearch) {

    }

}
