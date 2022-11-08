package org.example.vcdb.executor;

import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.vcdb.config.ClientConfig;
import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteDB;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Delete.DeleteTransaction;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateDB;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.proto.Region;
import org.example.vcdb.proto.RegionServerGrpc;
import org.example.vcdb.store.wal.WalBuffer;


public class VCDBAdmin {
    ClientConfig clientConfig;
    WalBuffer walBuffer;

    static String ExplainValue=null;

    private final static String host="localhost";

    //服务端口号
    private final static int serverPort=9999;


    //return int(返回改动KV的数量)
    public String createDB(String dBName, CreateDB createDB) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.dbNameRequest request = Region.dbNameRequest.newBuilder()
                .setDBName(dBName)
                .build();
        Region.boolReply db = blockingStub.createDB(request);
        boolean reply = db.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "create dataBase "+dBName+" success\n";
        }else {
            return "err\n";
        }
    }


    //return bool(是否成功)
    public String createTable(String dBName,String tabName,CreateTable createTable) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.tableRequest request = Region.tableRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRequestEntity(ByteString.copyFrom(createTable.toByteArray()))
                .build();
        Region.boolReply table = blockingStub.createTable(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "create table "+tabName+" success\n";
        }else {
            return "err\n";
        }
    }

    //return bool(是否成功)
    public String deleteDB(String dBName, DeleteDB deleteDB) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.dbNameRequest request = Region.dbNameRequest.newBuilder()
                .setDBName(dBName)
                .build();
        Region.boolReply table = blockingStub.deleteDB(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "delete database "+dBName+" success\n";
        }else {
            return "err\n";
        }
    }

    //return bool(是否成功)
    public String deleteTable(String dBName,String tabName,DeleteTable deleteTable) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.tableNameRequest request = Region.tableNameRequest.newBuilder()
                .setTabName(dBName+"."+tabName)
                .build();
        Region.boolReply table = blockingStub.deleteTable(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "delete table "+dBName+"."+tabName+" success\n";
        }else {
            return "err\n";
        }
    }

    //return bool(是否成功)
    public String openTransaction(OpenTransaction openTransaction) {
        if (ExplainValue==null){
            ExplainValue=openTransaction.getExplainValue();
            ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
            //使用同步的方式进行消息传递
            RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
            Region.transactionRequest request = Region.transactionRequest.newBuilder()
                    .setExplainValue(openTransaction.getExplainValue())
                    .build();
            Region.boolReply table = blockingStub.openTransaction(request);
            boolean reply = table.getReply();
            System.out.println(reply);
            build.shutdown();
            if (reply){
                return "openTransaction "+openTransaction.getExplainValue()+"success\n";
            }else {
                return "err\n";
            }
        }else {
            return "上一个事务"+ExplainValue+"未关闭";
        }

    }

    //return bool(是否成功)
    public String closeTransaction(CloseTransaction closeTransaction) {
        String temp=ExplainValue;
        ExplainValue=null;
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.transactionRequest request = Region.transactionRequest.newBuilder()
                .setExplainValue(temp)
                .build();
        Region.boolReply table = blockingStub.closeTransaction(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "closeTransaction "+temp+"success\n";
        }else {
            return "err\n";
        }
    }

    //return int(返回改动KV的数量)
    public String putCells(String dBName,String tabName,PutCells putCells) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.putCellsRequest request = Region.putCellsRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRowKey(putCells.getRowKey())
                .setRequestEntity(ByteString.copyFrom(putCells.valuesToByteArray()))
                .build();
        Region.intReply table = blockingStub.putCells(request);
        int reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return "update "+reply+" cells success\n";
    }

    //return bool(是否成功)
    public String alterTable(String dBName,String tabName,AlterTable alterTable) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.tableRequest request = Region.tableRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRequestEntity(ByteString.copyFrom(alterTable.alterCellsToByteArray()))
                .build();
        Region.boolReply table = blockingStub.alterTable(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "alterTable "+dBName+"."+tabName+" success\n";
        }else {
            return "err\n";
        }
    }

    //return int(查询的返回KV的数量)
    public String mergeVersion(String dBName,String tabName,MergeVersion mergeVersion) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.mergeVersionRequest request = Region.mergeVersionRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRequestEntity(ByteString.copyFrom(mergeVersion.toByteArray()))
                .build();
        Region.intReply table = blockingStub.mergeVersion(request);
        int reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return "mergeVersion "+reply+" cells\n";
    }

    //return int(返回改动KV的数量)
    public String useVersion(String dBName,String tabName,UseVersion useVersion) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.versionRequest request = Region.versionRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRowKey(useVersion.getRowKey())
                .setCfName(useVersion.getCfName())
                .build();
        Region.boolReply table = blockingStub.useVersion(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "use "+useVersion.getRowKey()+" version "+useVersion.getVersion()+" success\n";
        }else {
            return "err\n";
        }
    }

    //return byte[](查询的返回KV)
    public String showVersion(String dBName,String tabName,ShowVersion showVersion) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.showVersionRequest request = Region.showVersionRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRowKey(showVersion.getRowKey())
                .setCfName(showVersion.getCfName())
                .build();
        Region.bytesReply table = blockingStub.showVersion(request);
        ByteString reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return new String(reply.toByteArray());
    }

    //return byte[](查询的返回KV)
    public String singleSearch(String dBName,String tabName,SingleSearch singleSearch) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.singleSearchRequest request = Region.singleSearchRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setLimit(singleSearch.getLimit())
                .setOrderCfName(singleSearch.getOrderCfName())
                .setSort(singleSearch.isSort())
                .setCfNames(ByteString.copyFrom(singleSearch.getCfNameByteArray()))
                .setTerms(ByteString.copyFrom(singleSearch.getTermsByteArray()))
                .build();
        Region.bytesReply table = blockingStub.singleSearch(request);
        ByteString reply = table.getReply();
        System.out.println(reply);
        build.shutdown();

        return new String(reply.toByteArray());
    }

    //return int(返回改动KV的数量)
    public String deleteCells(String dBName,String tabName,DeleteCells deleteCells) {

        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.deleteCellsRequest request = Region.deleteCellsRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setCfNames(ByteString.copyFrom(deleteCells.getCfNameByteArray()))
                .setTerms(ByteString.copyFrom(deleteCells.getTermsByteArray()))
                .build();
        Region.intReply table = blockingStub.deleteCells(request);
        int reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return "delete "+reply+" cells success\n";
    }

    //return int(返回改动KV的数量)
    public String updateCells(String dBName,String tabName,UpdateCells updateCells) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.updateCellsRequest request = Region.updateCellsRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setTerms(ByteString.copyFrom(updateCells.getTermsByteArray()))
                .setValues(ByteString.copyFrom(updateCells.getValuesByteArray()))
                .build();
        Region.intReply table = blockingStub.updateCells(request);
        int reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return "update "+reply+" cells success\n";
    }

    //return byte[](查询的返回KV)
    public String multiSearch(String dBName,String tabName,MultiSearch multiSearch) {
        return "multiSearch not be support\n";
    }

    //return int(返回改动KV的数量)
    public String deleteVersion(String dBName,String tabName,DeleteVersion requestEntity) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.versionRequest request = Region.versionRequest.newBuilder()
                .setDBName(dBName)
                .setTabName(tabName)
                .setRowKey(requestEntity.getRowKey())
                .setCfName(requestEntity.getCfName())
                .setVersion(requestEntity.getVersion())
                .build();
        Region.boolReply table = blockingStub.deleteVersion(request);
        boolean reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        if (reply){
            return "create version "+dBName+"."+tabName+":"+
                    request.getCfName()+" version "+requestEntity.getVersion()+" success\n";
        }else {
            return "err\n";
        }
    }

    public String showTransaction(ShowTransaction requestEntity) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.bytesReply table = blockingStub.showTransaction(Empty.newBuilder().build());
        ByteString reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return new String(reply.toByteArray());
    }

    public String deleteTransaction(DeleteTransaction requestEntity) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.transactionRequest request = Region.transactionRequest.newBuilder()
                .setExplainValue(requestEntity.getExplainValue())
                .build();
        Region.boolReply table = blockingStub.deleteTransaction(request);
        boolean reply = table.getReply();
        build.shutdown();
        if (reply){
            return "delete Transaction "+requestEntity.getExplainValue()+ " success\n";
        }else {
            return "err\n";
        }
    }

    public String useTransaction(UseTransaction useTransaction) {
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.useTransactionRequest request = Region.useTransactionRequest.newBuilder()
                .setExplainValue(useTransaction.getExplainValue())
                .setNewExplainValue(useTransaction.getNewExplainValue())
                .build();
        Region.boolReply table = blockingStub.useTransaction(request);
        boolean reply = table.getReply();
        build.shutdown();
        if (reply){
            return "use "+useTransaction.getExplainValue()+" success\n";
        }else {
            return "err\n";
        }
    }

    public String showDataBases(ShowDataBases showDataBases){
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.bytesReply table = blockingStub.showDataBases(Empty.newBuilder().build());
        ByteString reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return new String(reply.toByteArray());
    }

    public String showTables(String dbName,ShowTables showTables){
        ManagedChannel build = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        //使用同步的方式进行消息传递
        RegionServerGrpc.RegionServerBlockingStub blockingStub = RegionServerGrpc.newBlockingStub(build);
        Region.dbNameRequest request = Region.dbNameRequest.newBuilder()
                .setDBName(dbName)
                .build();
        Region.bytesReply table = blockingStub.showTables(request);
        ByteString reply = table.getReply();
        System.out.println(reply);
        build.shutdown();
        return new String(reply.toByteArray());
    }
}
