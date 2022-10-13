package org.example.vcdb.store.region;

import com.google.protobuf.Empty;
import com.google.protobuf.Value;
import io.grpc.stub.StreamObserver;
import org.example.vcdb.store.file.VCFIleWriter;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;
import org.example.vcdb.store.proto.Meta;
import org.example.vcdb.store.proto.getRegionMetaGrpc;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.Region.VCRegion;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.example.vcdb.util.Bytes;

<<<<<<< HEAD
=======
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
>>>>>>> 16844d08f6cab7dba3d58f1ffbe46c3e0510b892
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.vcdb.store.mem.KV.byteToType;
import static org.example.vcdb.store.region.fileStore.ColumnFamilyMeta.byteToCFType;
import static org.example.vcdb.store.region.fileStore.FileStore.*;

public class RegionServer extends getRegionMetaGrpc.getRegionMetaImplBase {
    //cache for fileStores
    //负责接收sql请求的KV
    static Map<String,MemStore> inboundMemStore;

    //负责接收从文件加载过来的的KV
    static Map<String,MemStore> outboundMemStore;

    static RegionServerMeta regionServerMeta;

    //cache for region
    List<VCRegion> loadOnRegion;

    public static void readConfig(String fileName) {
        regionServerMeta = new RegionServerMeta(VCFileReader.readAll(fileName));
    }

    public RegionServer(String fileName) {
        regionServerMeta = new RegionServerMeta(VCFileReader.readAll(fileName));
        inboundMemStore=new ConcurrentHashMap<>();
    }

    public RegionServer() {

    }

    /*table:cfName-----fileStoreMeta------fileStore*/
    /*createDB:createDB*/
    /*Transaction:Transaction*/
    /*Table:Table*/
    //用dbName当做rowKey
    public static boolean createDBService(String dbName){
        try {
            commonSet(dbName,"DB","DB",(byte) 0);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static boolean createTable(String dbName,String tabName,byte[] requestEntity){
        try {
            commonSet(dbName+"."+tabName,"Table","Table",(byte) 4);
            int pos=0;
            int count=Bytes.toInt(requestEntity,pos,4);
            pos+=4;

            for (int i = 0; i < count; i++) {
                int cfNameLength=Bytes.toInt(requestEntity,pos,4);
                pos+=4;
                String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
                pos+=cfNameLength;
                byte type=requestEntity[pos];
                pos+=1;
                long min=Bytes.toLong(requestEntity,pos,8);
                pos+=8;
                long max=Bytes.toLong(requestEntity,pos,8);
                pos+=8;
                boolean unique=requestEntity[pos]==1;
                pos+=1;
                boolean isNil=requestEntity[pos]==1;
                pos+=1;

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String fileName=sdf.format(new Date());
                String regionMetaFileName="region/"+fileName;
                String fileStoreName="fileStore/"+fileName;
                String fileStoreMetaName="fileStoreMeta/"+fileName;

                /*createTable*/
                /*注册该表到RegionServerMeta*/
                /*先读出RegionServerMeta*/
                RegionServerMeta serverMeta = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
                Map<String, String> regionMap = serverMeta.getRegionMap();

                /*应该查重*/
                regionMap.put(dbName +"."+tabName,regionMetaFileName);

                /*替换新map*/
                serverMeta.setRegionMap(regionMap);

                /*写入文件*/
                VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");

                /*创建regionMetaMap*/
                Map<String, String> fileStoreMap = new ConcurrentHashMap<>();
                fileStoreMap.put(cfName, fileStoreMetaName);
                RegionMeta regionMeta = new RegionMeta(regionMetaFileName, fileStoreMap);
                VCFIleWriter.writeAll(regionMeta.getData(), regionMetaFileName);

                /*创建fileStoreMeta*/
                FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                        fileStoreName, "".getBytes(), "".getBytes());
                VCFIleWriter.writeAll(fileStoreMeta.getData(), fileStoreMetaName);

                /*创建fileStore*/
                ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(unique,isNil,min,max,byteToCFType(type));
                FileStore fileStore=new FileStore(cfMeta);
                VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteDB(String dbName){
        try {
            commonSet(dbName,"DB","DB",(byte) 8);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTable(String tabName){
        try {
            commonSet(tabName,"Table","Table",(byte) 10);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean openTransaction(String explainValue){
        try {
            commonSet(explainValue,"Transaction","Transaction",(byte) 12);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean closeTransaction(String explainValue){
        try {
            commonSet(explainValue,"Transaction","Transaction",(byte) 14);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public int putCells(String dbName,String tabName,String rowKey,byte[] requestEntity){
        int pos=0;
        int count=Bytes.toInt(requestEntity,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int cfNameLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String cfName=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=cfNameLength;

            int cnameLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String cname=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=cnameLength;

            int valueLength=Bytes.toInt(requestEntity,pos,4);
            pos+=4;
            String value=Bytes.toString(requestEntity,pos,cfNameLength);
            pos+=valueLength;

            /*添加KV到memStore*/
            MemStore memStore = inboundMemStore.get(dbName+"."+tabName+ ":" +cfName);
            KV kv = memStore.kvSet.get(rowKey);
            if (kv==null){
                kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,null);
            }
            List<KV.ValueNode> values = kv.getValues();
            KV.ValueNode valueNode=new KV.ValueNode(new Date().getTime(),byteToType((byte) 10),
                    cname.getBytes(),cnameLength,0,
                    value.getBytes(),valueLength,0);
            values.add(valueNode);
            kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,values);
            memStore.kvSet.add(kv);
        }
        return count;
    }






    private static void commonSet(String rowKey,String fullTableName,String cfName,byte actionType){
            MemStore memStore = inboundMemStore.get(fullTableName+ ":" +cfName);
            KV kv = memStore.kvSet.get(rowKey);
            if (kv==null){
                kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,null);
            }
            List<KV.ValueNode> values = kv.getValues();
            KV.ValueNode valueNode=new KV.ValueNode(new Date().getTime(),byteToType((byte) 10),
                    "".getBytes(),"".getBytes().length,0,
                    "".getBytes(),"".getBytes().length,0);
            values.add(valueNode);
            kv=new KV(rowKey.getBytes(),0,rowKey.getBytes().length,values);
            memStore.kvSet.add(kv);
    }
































    public static void addKVToMemStore(String fullCfName,KV kv){
        if (inboundMemStore.get(fullCfName)==null){
            inboundMemStore.put(fullCfName,new MemStore());
        }
        MemStore toMemStore = inboundMemStore.get(fullCfName);
        toMemStore.add(kv);
        inboundMemStore.put(fullCfName,toMemStore);
    }

    public static void addKVsToDisk(String fullTabName,String cfName,KeyValueSkipListSet kvs ){
        RegionServer.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServer.getRegionMeta(fullTabName);
        FileStoreMeta fileStoreMeta = RegionServer.getFileStoreMeta(regionMeta, cfName);
        Map<Integer, List<KV>> integerListMap = RegionServer.splitKVsByPage(fileStoreMeta.getPageTrailer(), kvs);
        for (Map.Entry<Integer,List<KV>> entry : integerListMap.entrySet()) {
            if (!entry.getValue().isEmpty()){
                RegionServer.insertPageWithSplit(fullTabName,cfName,entry.getKey(),entry.getValue());
            }
        }
    }

    public static void removeKVsFromMemStore(String fullCfName){
        if (!inboundMemStore.containsKey(fullCfName)){
            inboundMemStore.remove(fullCfName);
        }
    }

    public static FileStoreMeta getFileStoreMeta(RegionMeta regionMeta, String cfName) {
        return regionMeta.getFileStoreMeta(cfName);
    }

    public static List<KVRange> getPageTrailer(String tabName, String cfName) {
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta, cfName);
        return fileStoreMeta.getPageTrailer();
    }




    public static void insertPageWithSplit(String tabName, String cfName, int pageIndex, List<KV> kvs) {
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta, cfName);
        String fileStoreName = fileStoreMeta.getEncodedName();
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
        int pageLength = pageTrailer.get(pageIndex).getPageLength();
        if (pageLength + getKVsLength(kvs) > 4 * 1024) {
            byte[] bytes = VCFileReader.openFileStorePage(pageIndex+1,fileStoreName);
            KeyValueSkipListSet kvs1 = byteArrayToKvs(bytes);
            kvs1.addKVs(kvs);
            int tempLength = 0;
            boolean flag=true;
            List<KV> newKVs = new ArrayList<>();
            for (KV kv : kvs1) {
                newKVs.add(kv);
                tempLength += kv.getLength();
                if (tempLength > 3 * 1024) {
                    if (flag) {
                        pageTrailer.remove(pageIndex);
                        insertOldPage(newKVs, pageTrailer, pageIndex,
                                fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        System.out.println("insertOldPage=========================");
                        newKVs.clear();
                        tempLength = 0;
                        flag= false;
                        continue;
                    }
                    if (kv.getLength() > 3 * 1024) {
                        insertNewPage(kv, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        newKVs.remove(kv);
                    } else {
                        System.out.println("===========================");
                        insertNewPage(newKVs, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                        System.out.println("insertNewPage+++++++++++++++++++");
                        newKVs.clear();
                        tempLength = 0;
                    }
                }
            }
            if (!newKVs.isEmpty()){
                System.out.println("===========================");
                insertNewPage(newKVs, pageTrailer, fileStoreName, fileStoreMeta, regionMeta.getfileStoreMetaName(cfName));
                System.out.println("insertNewPage+++++++++++++++++++");
                newKVs.clear();
            }
        } else {
            //不分裂
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(), kvsToByteArray(kvs), pageIndex+1, fileStoreMeta.getEncodedName());
            //更新元数据
            List<KVRange> list = updatePageTrailer(kvs, pageTrailer, pageIndex);
            fileStoreMeta.setPageTrailer(list);
            VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, regionMeta.getfileStoreMetaName(cfName));
        }
    }

    private static void insertNewPage(KV kv, List<KVRange> pageTrailer,
                                      String fileStoreName, FileStoreMeta fileStoreMeta,
                                      String fileStoreMetaName) {
        int pageTrailerIndex = pageTrailer.size();
        pageTrailer.set(pageTrailerIndex, new KVRange(4 + kv.getLength(), kv.getRowKey(), kv.getRowKey()));
        fileStoreMeta.setPageTrailer(pageTrailer);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        List<KV> kvs = new ArrayList<>();
        kvs.add(kv);
        byte[] bytes = kvsToByteArray(kvs);
        VCFIleWriter.setFileStorePage(bytes, pageTrailerIndex+1, fileStoreName);
    }

    private static void insertNewPage(List<KV> newKVs, List<KVRange> pageTrailer,
                                      String fileStoreName, FileStoreMeta fileStoreMeta,
                                      String fileStoreMetaName) {
        int pageTrailerIndex = pageTrailer.size();
        List<KVRange> list = updatePageTrailer2(newKVs, pageTrailer, pageTrailerIndex);
        fileStoreMeta.setPageTrailer(list);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        byte[] bytes = kvsToByteArray(newKVs);
        VCFIleWriter.setFileStorePage(bytes, pageTrailerIndex+1, fileStoreName);
    }

    private static void insertOldPage(List<KV> newKVs, List<KVRange> pageTrailer,
                                      int pageIndex, String fileStoreName, FileStoreMeta fileStoreMeta, String fileStoreMetaName) {
        List<KVRange> list = updatePageTrailer2(newKVs, pageTrailer, pageIndex);
        fileStoreMeta.setPageTrailer(list);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, fileStoreMetaName);
        byte[] bytes = kvsToByteArray(newKVs);
        VCFIleWriter.setFileStorePage(bytes, pageIndex+1, fileStoreName);
    }

    public static Map<Integer, List<KV>> splitKVsByPage(List<KVRange> pageTrailer, KeyValueSkipListSet kvSet) {
        Map<Integer, List<KV>> integerListMap = new ConcurrentHashMap<>();
        for (int j = 0; j < pageTrailer.size(); j++) {
            List<KV> kvs = new ArrayList<>();
            for (KV kv : kvSet) {
                try {
                    pageTrailer.get(j + 1);
                    if ((kv.getRowKey().compareTo(Bytes.toString(pageTrailer.get(j).getEndKey())) <= 0
                            && kv.getRowKey().compareTo(Bytes.toString(pageTrailer.get(j).getStartKey())) >= 0)) {
                        kvs.add(kv);
                        kvSet.remove(kv);
                    }
                } catch (Exception e) {
                    kvs.add(kv);
                    kvSet.remove(kv);
                }
                integerListMap.put(j, kvs);
            }
        }
        return integerListMap;
    }

    public static void addTabName(String dbName, String tabName, String regionMetaFileName) {
        RegionServerMeta serverMeta = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
        Map<String, String> regionMap = serverMeta.getRegionMap();
        /*应该查重*/
        regionMap.put(dbName + "." + tabName, regionMetaFileName);
        /*替换新map*/
        serverMeta.setRegionMap(regionMap);
        /*写入文件*/
        VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");
    }

    public static void updateRegionMeta(String fileName, String cfName, String fileStoreMetaName) {
        RegionMeta regionMeta = new RegionMeta(VCFileReader.readAll(fileName));
        regionMeta.getFileStoreMap();
        Map<String, String> fileStoreMap = regionMeta.getFileStoreMap();
        fileStoreMap.put(cfName, fileStoreMetaName);
        regionMeta.setFileStoreMap(fileStoreMap);
        VCFIleWriter.writeAll(regionMeta.getData(), fileName);
    }

    public static List<KVRange> updatePageTrailer(List<KV> newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        for (KV kv : newKVs) {
            if (minKey.compareTo(kv.getRowKey()) > 0) {
                minKey = kv.getRowKey();
            }
            if (maxKey.compareTo(kv.getRowKey()) < 0) {
                maxKey = kv.getRowKey();
            }
        }
        pageTrailer.set(pageIndex , new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer(KeyValueSkipListSet newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        minKey=newKVs.first().getRowKey();
        maxKey=newKVs.last().getRowKey();
        pageTrailer.set(pageIndex,new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer2(List<KV> newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        for (KV kv : newKVs) {
            if (minKey.compareTo(kv.getRowKey()) > 0) {
                minKey = kv.getRowKey();
            }
            if (maxKey.compareTo(kv.getRowKey()) < 0) {
                maxKey = kv.getRowKey();
            }
        }
        pageTrailer.add(pageIndex , new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static List<KVRange> updatePageTrailer2(KeyValueSkipListSet newKVs, List<KVRange> pageTrailer, int pageIndex) {
        String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String maxKey = "\0";
        int pageLength = getKVsLength(newKVs);
        minKey=newKVs.first().getRowKey();
        maxKey=newKVs.last().getRowKey();
        pageTrailer.add(pageIndex,new KVRange(pageLength, minKey, maxKey));
        return pageTrailer;
    }

    public static void updateColumnFamilyMeta(String fileStoreName, ColumnFamilyMeta columnFamilyMeta) {
        VCFIleWriter.writeAll(columnFamilyMeta.getData(), 0, fileStoreName);
    }

    public static RegionMeta getRegionMeta(String tableName) {
        //取出的应该缓存
        Map<String, String> regionMap = regionServerMeta.getRegionMap();
        return new RegionMeta(VCFileReader.readAll(regionMap.get(tableName)));
    }

    //接受rpc调用
    //获取元数据
    // responseObserver 为返回值
    @Override
    public void getRegionMeta(Empty request, StreamObserver<Meta.regionMeta> responseObserver) {
        Meta.regionMeta regionMeta = null;
        //获取元数据

        //返回元数据
        responseObserver.onNext(regionMeta);
        //告知本次处理完毕
        responseObserver.onCompleted();
    }

    //合并KV里的ValueNode
    public int MergeKV(String dbName, String tableName, String cfName, String rowKey, int versionFrom, int versionTo) {
        return 1;
    }


}
