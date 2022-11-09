package org.example.vcdb.store.region;

import com.google.common.collect.Tables;
import org.example.vcdb.store.RegionServer;
import org.example.vcdb.store.file.VCFIleWriter;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.version.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
            System.out.println("正在检测dbMap、tableMap、tableAlterMap是否为空");
            if (!RegionServer.transactionMap.isEmpty()){
                TransactionFile transactionFile=new TransactionFile(VCFileReader.readAll("common/transaction"));
                List<Transaction> transactions = null;
                if (transactionFile.getData().length==0){
                    transactions=new ArrayList<>();
                }else {
                    transactions=transactionFile.getTransactions();
                }
                int oldSize = transactions.size();
                for (Map.Entry<String,Transaction> entry : RegionServer.transactionMap.entrySet()) {
                    if (entry.getValue().getStartTime()!=0&&entry.getValue().getEndTime()!=0){
                        transactions.add(entry.getValue());
                    }else {
                        System.out.println(entry.getKey()+"这个事务没有完成");
                    }
                }
                if (transactions.size()==oldSize){
                    System.out.println("transactions没有增加无需落盘");
                }else {
                    VCFIleWriter.writeAll(new TransactionFile(transactions).getData(),"common/transaction");
                    RegionServer.transactionMap.clear();
                    System.out.println("transaction落盘成功");
                }
            }

            if (!RegionServer.dbMap.isEmpty()){
                DataBaseFile dataBaseFile=new DataBaseFile(VCFileReader.readAll("common/dbFileStore"));
                List<DataBase> dataBases=null;
                Map<String,DataBase> temp=new ConcurrentHashMap<>();
                if (dataBaseFile.getData().length==0){
                    dataBases=new ArrayList<>();
                }else {
                    dataBases = dataBaseFile.getDataBases();
                    for (DataBase dataBase:dataBases){
                        temp.put(dataBase.getDbName(),dataBase);
                    }
                }
                //判断dataBase最后Dbname的最后一个的类型一样的话没必要

                for (Map.Entry<String,DataBase> entry : RegionServer.dbMap.entrySet()) {
                    //包含且类型一样
                    if (temp.containsKey(entry.getKey())&&temp.get(entry.getKey()).getType()==entry.getValue().getType()){
                        System.out.println(entry.getKey()+" type= "+entry.getValue().getType()+"已经存在!!");
                        return;
                    }
                    dataBases.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new DataBaseFile(dataBases).getData(),"common/dbFileStore");
                RegionServer.dbMap.clear();
                System.out.println("db落盘成功");
            }

            if (!RegionServer.tableMap.isEmpty()){
                System.out.println("tableMap开始落盘");
                TableFile tableFile=new TableFile(VCFileReader.readAll("common/tableFileStore"));
                List<Table> tables = null;
                Map<String,Table> temp=new ConcurrentHashMap<>();
                if (tableFile.getData().length==0){
                    tables=new ArrayList<>();
                }else {
                    tables=tableFile.getTables();

                    for (Table table:tables){
                        temp.put(table.getTabName(),table);
                    }
                }

                for (Map.Entry<String,Table> entry : RegionServer.tableMap.entrySet()) {
                    //包含且类型一样
                    if (temp.containsKey(entry.getKey())&&temp.get(entry.getKey()).getType()==entry.getValue().getType()){
                        System.out.println(entry.getKey()+" type= "+entry.getValue().getType()+"已经存在!!");
                        return;
                    }
                    tables.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new TableFile(tables).getData(),"common/tableFileStore");
                RegionServer.tableMap.clear();
                System.out.println("table落盘成功");
            }

            if (!RegionServer.tableAlterMap.isEmpty()){
                TableAlterFile tableAlterFile=new TableAlterFile(VCFileReader.readAll("common/tableAlterFileStore"));
                List<TableAlter> tableAlters = null;
                if (tableAlterFile.getData().length==0){
                    tableAlters=new ArrayList<>();
                }else {
                    tableAlters=tableAlterFile.getTableAlters();
                }
                for (Map.Entry<String,TableAlter> entry : RegionServer.tableAlterMap.entrySet()) {
                    TableAlter tableAlter = entry.getValue();
                    String[] str= tableAlter.getTab().split("\\.");
                    String dbName=str[0];
                    String tabName=str[1];
                    String oldCf= tableAlter.getOldCf();
                    String cfName= tableAlter.getCf();
                    String min= tableAlter.getMin();
                    String max=tableAlter.getMax();
                    boolean unique= tableAlter.getUni();
                    boolean isNil= tableAlter.getNil();
                    byte type= tableAlter.getType();
                    byte method=tableAlter.getMethod();
                    System.out.println("method :"+method);
                    switch (tableAlter.getMethod()){
                        case 1:
                            updateFileStoreCFMeta(dbName,tabName,cfName,min,max,unique,isNil,type);
                            break;
                        case 2:
                            updateFileStoreCFMeta(dbName,tabName,oldCf,min,max,unique,isNil,type);
                            deleteFileStoreCFMeta(dbName,tabName,oldCf);
                            break;
                        case 3:
                            deleteFileStoreCFMeta(dbName,tabName,oldCf);
                            break;
                        default:
                            System.out.println("the method is err ！！！");
                    }
                    System.out.println("修改fileStore和fileStoreMeta文件成功");
                    tableAlters.add(entry.getValue());
                }
                VCFIleWriter.writeAll(new TableAlterFile(tableAlters).getData(),
                        "common/tableAlterFileStore");
                RegionServer.tableAlterMap.clear();
                System.out.println("tableAlter落盘成功");
            }
        }, 1, 5, TimeUnit.SECONDS);// 1s 后开始执行，每 5s 执行一次
    }

    private static void updateFileStoreCFMeta(String dbName, String tableName, String cfName,
                                              String min, String max, boolean unique, boolean isNil,
                                              byte type){
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName + "." + tableName);
        if (regionMeta==null){
            System.out.println("该表"+dbName + "." + tableName+"不存在");
        }else {
            String fileStoreMetaName = regionMeta.getFileStoreMetaName(cfName);
            if (fileStoreMetaName==null){
                System.out.println(cfName+"不存在");
            }
            FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
            String fileStoreName = fileStoreMeta.getEncodedName();
            FileStore fileStore=new FileStore(VCFileReader.readAll(fileStoreName));
            fileStore.setColumnFamilyMeta(new ColumnFamilyMeta(min,max,unique,isNil,
                    ColumnFamilyMeta.byteToCFType(type)));
            VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
        }
    }

    private static void updateFileStoreMap(String dbName, String tableName,String oldCf, String cfName){
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName + "." + tableName);
        if (regionMeta==null){
            System.out.println("该表"+dbName + "." + tableName+"不存在");
        }else {
            Map<String, String> fileStoreMap = regionMeta.getFileStoreMap();
            String s = fileStoreMap.get(oldCf);
            if (s==null){
                System.out.println(oldCf + "不存在");
            }else {
                fileStoreMap.remove(oldCf);
                fileStoreMap.put(cfName,s);
                regionMeta.setFileStoreMap(fileStoreMap);
                VCFIleWriter.writeAll(regionMeta.getData(), regionMeta.getName());
            }
        }
    }

    private static void deleteFileStoreCFMeta(String dbName, String tableName, String cfName){
        //删除fileStore和fileStoreMeta文件
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName + "." + tableName);
        if (regionMeta==null){
            System.out.println("该表"+dbName + "." + tableName+"不存在");
        } else {
            String fileStoreMetaName = regionMeta.getFileStoreMetaName(cfName);
            if (fileStoreMetaName == null) {
                System.out.println(cfName + "不存在");
            }
            FileStoreMeta fileStoreMeta = new FileStoreMeta(VCFileReader.readAll(fileStoreMetaName));
            File file1=new File("/x2/fileStoreMeta/"+fileStoreMetaName);
            String fileStoreName = fileStoreMeta.getEncodedName();
            File file2=new File("/x2/fileStore"+fileStoreName);
            if(file1.delete()&&file2.delete()){
                System.out.println(file1.getName()+"和"+file2.getName() + " 文件已被删除！");
            }else{
                System.out.println("文件删除失败！");
            }
        }
    }
    private static void addMemStoreToDisk(AtomicInteger count) {
        Map<String, MemStore> inboundMemStore= RegionServer.inboundMemStore;
        if (inboundMemStore!=null){
            for (Map.Entry<String,MemStore> entry : inboundMemStore.entrySet()) {
                String[] keys = entry.getKey().split(":");
                KeyValueSkipListSet kvSet = entry.getValue().getKVSet();
                System.out.println("table:"+keys[0]+" cf:"+keys[1]);
                RegionServerAPI.addKVsToDisk(keys[0],keys[1],kvSet);
                RegionServerAPI.removeKVsFromMemStore(entry.getKey());
                System.out.println("inboundMemStore落盘成功");
            }
            RegionServer.inboundMemStore.clear();
        }else {
            System.out.println("inboundMemStore为空");
        }
        count.getAndSet(5);
    }
}
