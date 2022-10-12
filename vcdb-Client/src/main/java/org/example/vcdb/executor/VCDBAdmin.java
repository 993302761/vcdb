package org.example.vcdb.executor;

import org.example.vcdb.config.ClientConfig;
import org.example.vcdb.entity.Delete.DeleteCells;
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
    public void createDB(String dBName, CreateDB createDB) {

    }


    //return bool(是否成功)
    public void createTable(String dBName,String tabName,CreateTable createTable) {

    }

    //return bool(是否成功)
    public void deleteDB(String dBName,DeleteCells deleteCells) {

    }

    //return bool(是否成功)
    public void deleteTable(String dBName,String tabName,DeleteTable deleteTable) {

    }

    //return bool(是否成功)
    public void openTransaction(OpenTransaction openTransaction) {

    }

    //return bool(是否成功)
    public void closeTransaction(CloseTransaction closeTransaction) {

    }

    //return int(返回改动KV的数量)
    public void putCells(String dBName,String tabName,PutCells putCells) {

    }

    //return bool(是否成功)
    public void alterTable(String dBName,String tabName,AlterTable alterTable) {

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

    //return byte[](查询的返回KV)
    public void singleSearch(String dBName,String tabName,SingleSearch singleSearch) {

    }

    //return int(返回改动KV的数量)
    public void deleteCells(String dBName,String tabName,DeleteCells deleteCells) {

    }

    //return int(返回改动KV的数量)
    public void updateCells(String dBName,String tabName,UpdateCells updateCells) {

    }

    //return byte[](查询的返回KV)
    public void multiSearch(String dBName,String tabName,MultiSearch multiSearch) {

    }

    //return int(返回改动KV的数量)
    public void deleteVersion(String dBName,String tabName,DeleteVersion requestEntity) {
    }
}
