package org.example.vcdb.store.region;

import org.example.vcdb.store.RegionServer;
import org.example.vcdb.store.file.VCFIleWriter;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.region.version.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName DaemonRegion
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/10 下午10:29
 * @Version 1.0
 */

public class DaemonRegionServer {
    public static void async() {
        RegionServer.readConfig("regionServerMeta");
        AtomicInteger count=new AtomicInteger(5);
        //一秒检查一下size,count-1
        //当检查到满的时候调用落盘，或者检查到count==0时候落盘，落盘之后都会把count还原成5
        // 创建任务队列   10 为线程数量
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        // 执行任务,里面写执行代码
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("size dont 555");
            /*db.table:cf*/
            if (RegionServer.inboundMemStore.size()==5){
                System.out.println("size=====5执行落盘");
                addMemStoreToDisk(count);
            } else {
                if (count.get()==0){
                    System.out.println("count======0执行落盘");
                    /*db.table:cf*/
                    addMemStoreToDisk(count);
                } else {
                    count.decrementAndGet();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);// 1s 后开始执行，每 1s 执行一次

        // 执行任务,里面写执行代码
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (!RegionServer.transactionMap.isEmpty()){
                TransactionFile transactionFile=new TransactionFile(VCFileReader.readAll("/x2/vcdb/common/transaction"));
                List<Transaction> transactions = transactionFile.getTransactions();
                for (Map.Entry<String,Transaction> entry : RegionServer.transactionMap.entrySet()) {
                    transactions.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new TransactionFile(transactions).getData(),"/x2/vcdb/common/transaction");
            }

            if (!RegionServer.dbMap.isEmpty()){
                DataBaseFile dataBaseFile=new DataBaseFile(VCFileReader.readAll("/x2/vcdb/common/dbFileStore"));
                List<DataBase> dataBases = dataBaseFile.getDataBases();
                for (Map.Entry<String,DataBase> entry : RegionServer.dbMap.entrySet()) {
                    dataBases.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new DataBaseFile(dataBases).getData(),"/x2/vcdb/common/dbFileStore");
            }

            if (!RegionServer.tableMap.isEmpty()){
                TableFile tableFile=new TableFile(VCFileReader.readAll("/x2/vcdb/common/tableFileStore"));
                List<Table> tables = tableFile.getTables();
                for (Map.Entry<String,Table> entry : RegionServer.tableMap.entrySet()) {
                    tables.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new TableFile(tables).getData(),"/x2/vcdb/common/tableFileStore");
            }

            if (!RegionServer.tableAlterMap.isEmpty()){
                TableAlterFile tableAlterFile=new TableAlterFile(VCFileReader.readAll("/x2/vcdb/common/tableAlterFileStore"));
                List<TableAlter> tableAlters = tableAlterFile.getTableAlters();
                for (Map.Entry<String,TableAlter> entry : RegionServer.tableAlterMap.entrySet()) {
                    tableAlters.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new TableAlterFile(tableAlters).getData(),"/x2/vcdb/common/tableAlterFileStore");
            }

        }, 1, 5, TimeUnit.SECONDS);// 1s 后开始执行，每 1s 执行一次

    }

    private static void addMemStoreToDisk(AtomicInteger count) {
        Map<String, MemStore> inboundMemStore= RegionServer.inboundMemStore;
        for (Map.Entry<String,MemStore> entry : inboundMemStore.entrySet()) {
            String[] keys = entry.getKey().split(":");
            KeyValueSkipListSet kvSet = entry.getValue().getKVSet();
            RegionServerAPI.addKVsToDisk(keys[0],keys[1],kvSet);
            count.getAndSet(5);
            RegionServerAPI.removeKVsFromMemStore(entry.getKey());
        }
    }
}
