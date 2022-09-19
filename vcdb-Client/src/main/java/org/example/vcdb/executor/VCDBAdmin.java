package org.example.vcdb.executor;

import org.example.vcdb.config.ClientConfig;
import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
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
    public void createDB(String dBName) {
        KV.ValueNode valueNode=new KV.ValueNode((new Date()).getTime(),byteToType((byte) 0),"".getBytes(),0,"".getBytes().length,"".getBytes(),0,"".getBytes().length);
        WalEdit walEdit = VCLog.entry.get(dBName.getBytes());
        if (walEdit==null){
            VCLog.entry.put(dBName.getBytes(),new WalEdit());
        }
        //日志集合（内存）
        //存在本地并且grpc调用从机进行日志备份
        boolean b = recordLog(dBName.getBytes(), valueNode);
    }
    public boolean recordLog(byte[] key, KV.ValueNode valueNode){
        WalEdit  newWalEdit = VCLog.entry.get(key);
        newWalEdit.actions.add(valueNode);
        return true;
    }
    public void createTable(CreateTable createTable) {

    }

    public void deleteDB(DeleteCells deleteCells) {

    }

    public void deleteTable(DeleteTable deleteTable) {

    }

    public void openTransaction(OpenTransaction openTransaction) {

    }

    public void closeTransaction(CloseTransaction closeTransaction) {

    }

    public void putCells(PutCells putCells) {

    }

    public void alterTable(AlterTable alterTable) {

    }

    public void mergeVersion(MergeVersion mergeVersion) {

    }

    public void useVersion(UseVersion useVersion) {

    }

    public void showVersion(ShowVersion showVersion) {

    }

    public void singleSearch(SingleSearch singleSearch) {

    }

    public void deleteCells(DeleteCells deleteCells) {

    }

    public void updateCells(UpdateCells updateCells) {

    }

    public void multiSearch(MultiSearch multiSearch) {

    }

    public void deleteVersion(DeleteVersion requestEntity) {
    }
}
