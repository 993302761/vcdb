package org.example.vcdb.executor;

import org.example.vcdb.entity.Delete.DeleteCells;
import org.example.vcdb.entity.Delete.DeleteTable;
import org.example.vcdb.entity.Post.*;
import org.example.vcdb.entity.Put.CreateTable;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.wal.VCLog;
import org.example.vcdb.store.wal.WalEdit;

import java.util.Date;
import java.util.List;

import static org.example.vcdb.store.mem.KV.byteToType;

public class VCDBAdmin {
    MemStore memStore;
    public VCDBAdmin(){
        memStore=new MemStore();
    }
    public void createDB(String dBName) {
        KV.ValueNode valueNode=new KV.ValueNode((new Date()).getTime(),byteToType((byte) 0),"".getBytes(),0,"".getBytes().length,"".getBytes(),0,"".getBytes().length);
        WalEdit walEdit = VCLog.entry.get(dBName.getBytes());
        if (walEdit==null){
            VCLog.entry.put(dBName.getBytes(),new WalEdit());
        }
        //日志集合（内存）
        WalEdit  newWalEdit = VCLog.entry.get(dBName.getBytes());
        newWalEdit.actions.add(valueNode);
        if (memStore.kvSet.get("")==null){
            memStore.add(new KV("".getBytes(),0,"".getBytes().length,"".getBytes(),0,"".getBytes().length,null));
        }
        //产生新KV加入memStore
        KV kv=memStore.kvSet.get("");
        List<KV.ValueNode> values = kv.getValues();
        values.add(valueNode);
        memStore.kvSet.remove(kv);
        KV newKv=new KV("".getBytes(),0,"".getBytes().length,
                "".getBytes(),0,"".getBytes().length,values);
        memStore.add(newKv);
        //size + 1
        memStore.size.addAndGet(kv.getLength());

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
