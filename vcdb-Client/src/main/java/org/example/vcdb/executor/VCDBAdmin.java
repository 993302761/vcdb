package org.example.vcdb.executor;

import org.example.vcdb.config.ClientConfig;
import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteDB;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateDB;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.wal.VCLog;
import org.example.vcdb.store.wal.WalBuffer;
import org.example.vcdb.store.wal.WalEdit;

import java.util.Date;

import static org.example.vcdb.store.mem.KV.byteToType;

public class VCDBAdmin {
    ClientConfig clientConfig;
    WalBuffer walBuffer;

    //return bool(是否成功)
    public String createDB(String dBName, CreateDB createDB) {
        return "create database "+dBName+" success\n";
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
        return "openTransaction "+openTransaction.getExplainValue()+"\n";
    }

    //return bool(是否成功)
    public String closeTransaction(CloseTransaction closeTransaction) {
        return "closeTransaction success\n";
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
}
