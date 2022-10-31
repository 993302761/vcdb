package org.example.vcdb.executor;

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
        return "xxxx";
    }


    //return bool(是否成功)
    public String createTable(String dBName,String tabName,CreateTable createTable) {
        return "create table "+tabName+" success\n";
    }

    //return bool(是否成功)
    public String deleteDB(String dBName, DeleteDB deleteDB) {
        return "delete database "+dBName+" success\n";
    }

    //return bool(是否成功)
    public String deleteTable(String dBName,String tabName,DeleteTable deleteTable) {
        return "delete table "+tabName +" success\n";
    }

    //return bool(是否成功)
    public String openTransaction(OpenTransaction openTransaction) {
        if (ExplainValue==null){
            ExplainValue=openTransaction.getExplainValue();
            return "openTransaction "+openTransaction.getExplainValue()+"\n";
        }else {
            return "上一个事务"+ExplainValue+"未关闭";
        }

    }

    //return bool(是否成功)
    public String closeTransaction(CloseTransaction closeTransaction) {
        String temp=ExplainValue;
        ExplainValue=null;
        return "closeTransaction "+temp+ " success\n";
    }

    //return int(返回改动KV的数量)
    public String putCells(String dBName,String tabName,PutCells putCells) {
        return "update "+putCells.getCount()+" cells success\n";
    }

    //return bool(是否成功)
    public String alterTable(String dBName,String tabName,AlterTable alterTable) {
        return "alterTable "+tabName +"success\n";
    }

    //return int(查询的返回KV的数量)
    public String mergeVersion(String dBName,String tabName,MergeVersion mergeVersion) {
        return "mergeVersion "+mergeVersion.getCount()+" cells\n";
    }

    //return int(返回改动KV的数量)
    public String useVersion(String dBName,String tabName,UseVersion useVersion) {
        return "use "+useVersion.getRowKey()+" version "+useVersion.getVersion()+" success\n";
    }

    //return byte[](查询的返回KV)
    public String showVersion(String dBName,String tabName,ShowVersion showVersion) {
        return "=====>0---row1---info:myName----n1\n" +
                "=====>1---row1---info:myName----n2\n" +
                "=====>2---row1---info:myName----n3\n";
    }

    //return byte[](查询的返回KV)
    public String singleSearch(String dBName,String tabName,SingleSearch singleSearch) {
        return "---row1---info:myName----n3\n";
    }

    //return int(返回改动KV的数量)
    public String deleteCells(String dBName,String tabName,DeleteCells deleteCells) {
        return "update "+deleteCells.getCount()+" cells success\n";
    }

    //return int(返回改动KV的数量)
    public String updateCells(String dBName,String tabName,UpdateCells updateCells) {
        return "update "+updateCells.getCount()+" cells success\n";
    }

    //return byte[](查询的返回KV)
    public String multiSearch(String dBName,String tabName,MultiSearch multiSearch) {
        return "\n";
    }

    //return int(返回改动KV的数量)
    public String deleteVersion(String dBName,String tabName,DeleteVersion requestEntity) {
        return "update  success\n";
    }

    public String showTransaction(ShowTransaction requestEntity) {
        return "=====>0---row1---info:myName----n1\n" +
                "=====>1---row1---info:myName----n2\n" +
                "=====>2---row1---info:myName----n3\n";
    }

    public String deleteTransaction(DeleteTransaction requestEntity) {
        return "=====>0---row1---info:myName----n1\n" +
                "=====>1---row1---info:myName----n2\n" +
                "=====>2---row1---info:myName----n3\n";
    }

    public String useTransaction(UseTransaction useTransaction) {
        return "use "+useTransaction.getExplainValue()+" success\n";
    }

    public String showDataBases(ShowDataBases showDataBases){
        return "=====>0---row1---info:myName----n1\n" +
                "=====>1---row1---info:myName----n2\n" +
                "=====>2---row1---info:myName----n3\n";
    }

    public String showTables(String dbName,ShowTables showTables){
        return "=====>0---row1---info:myName----n1\n" +
                "=====>1---row1---info:myName----n2\n" +
                "=====>2---row1---info:myName----n3\n";
    }
}
