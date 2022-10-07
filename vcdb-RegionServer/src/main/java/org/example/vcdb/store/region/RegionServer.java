package org.example.vcdb.store.region;

import com.google.protobuf.Empty;
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
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.example.vcdb.util.Bytes;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.vcdb.store.region.fileStore.FileStore.byteArrayToKvs;
import static org.example.vcdb.store.region.fileStore.FileStore.kvsToByteArray;

public class RegionServer extends getRegionMetaGrpc.getRegionMetaImplBase{
    //cache for fileStores
    List<MemStore> memStores;
    static RegionServerMeta regionServerMeta;
    //cache for region
    List<VCRegion> loadOnRegion;

    public static void readConfig(String fileName){
        regionServerMeta=new RegionServerMeta(VCFileReader.readAll(fileName));
    }
    public RegionServer(){
    }
    public RegionServer(String fileName){
        regionServerMeta=new RegionServerMeta(VCFileReader.readAll(fileName));
    }

    public static FileStoreMeta getFileStoreMeta(RegionMeta regionMeta, String cfName){
        return regionMeta.getFileStoreMeta(cfName);
    }

    public static List<KVRange> getPageTrailer(String tabName,String cfName){
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta,cfName);
        return fileStoreMeta.getPageTrailer();
    }
    /*0  BigKVs
    * 1  MiddleKVs
    * 2  TinyKVs
    * 3
    * 4   */
    /*
    * 什么时候啊需要分裂
    * 1.kvs.length+page.length>4096*/
    /*怎么分裂
    * 1. 把page里的Kvs和新的kvs加载到内存，再分裂*/
    public static void splitPage(String tabName,String cfName,int pageIndex,KeyValueSkipListSet kvs){
        RegionMeta regionMeta = getRegionMeta(tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta,cfName);
        String fileStoreName=fileStoreMeta.getEncodedName();
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
        int pageLength = pageTrailer.get(pageIndex-1).getPageLength();
        byte[] kvByteArray = kvsToByteArray(kvs);
        if (pageLength+kvByteArray.length>4*1024){
            byte[] bytes = VCFileReader.readAll(fileStoreName);
            KeyValueSkipListSet kvs1 = byteArrayToKvs(bytes);
            kvs1.addKVs(kvs);
            int tempLength=0;
            int kvPageCount=0;
            KeyValueSkipListSet newKVs=new KeyValueSkipListSet(new KV.KVComparator());
            for (KV kv:kvs1){
                newKVs.add(kv);
                tempLength+=kv.getLength();
                if (kvPageCount==0){
                    insertOldPage(newKVs,pageTrailer,pageIndex);
                    newKVs.clear();
                    tempLength=0;
                    kvPageCount+=1;
                }
                if (tempLength>3*1024){
                    if (kv.getLength()>3*1024){
                        insertNewPage(kv,pageTrailer);
                        newKVs.remove(kv);
                    } else {
                        insertNewPage(newKVs,pageTrailer);
                        newKVs.clear();
                        tempLength=0;
                    }
                }
            }
        }else {
            VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(),kvsToByteArray(kvs),pageIndex,fileStoreMeta.getEncodedName());
        }
    }
    public static Map<Integer,List<KV>> splitKVsByPage(List<KVRange> pageTrailer, KeyValueSkipListSet kvSet){
        Map<Integer,List<KV>> integerListMap=new ConcurrentHashMap<>();
        for (KV kv:kvSet){
            int i=1;
            for (int j = 0; j < pageTrailer.size(); j++) {
                if (kv.getRowKey().compareTo(Bytes.toString(pageTrailer.get(i).getEndKey()))<=0||pageTrailer.get(i+1)==null){
                    if (integerListMap.containsKey(i)){
                        List<KV> kvs=new ArrayList<>();
                        kvs.add(kv);
                        integerListMap.put(i,kvs);
                    } else {
                        List<KV> kvs=integerListMap.get(i);
                        kvs.add(kv);
                    }
                }
            }
        }
        return integerListMap;
    }

    public static void addTabName(String dbName,String tabName,String regionMetaFileName){
        RegionServerMeta serverMeta = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
        Map<String, String> regionMap = serverMeta.getRegionMap();
        /*应该查重*/
        regionMap.put(dbName +"."+tabName,regionMetaFileName);
        /*替换新map*/
        serverMeta.setRegionMap(regionMap);
        /*写入文件*/
        VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");
    }

    public static void updateRegionMeta(String fileName,String cfName,String fileStoreMetaName){
        RegionMeta regionMeta = new RegionMeta(VCFileReader.readAll(fileName));
        regionMeta.getFileStoreMap();
        Map<String, String> fileStoreMap = regionMeta.getFileStoreMap();
        fileStoreMap.put(cfName,fileStoreMetaName);
        regionMeta.setFileStoreMap(fileStoreMap);
        VCFIleWriter.writeAll(regionMeta.getData(), fileName);
    }

    public static List<KVRange> updatePageTrailer(List<KVRange> pageTrailer,Map<Integer,List<KV>> kvs){
        for (Map.Entry<Integer,List<KV>> entry : kvs.entrySet()) {
            KVRange kvRange = pageTrailer.get(entry.getKey() - 1);
            for (KV kv:entry.getValue()){
                if (kv.getRowKey().compareTo(Bytes.toString(kvRange.getStartKey()))<0){
                    kvRange.setMinKey(kv);
                    pageTrailer.set(entry.getKey(),kvRange);
                }else if (kv.getRowKey().compareTo(Bytes.toString(kvRange.getStartKey()))>0){
                    kvRange.setMaxKey(kv);
                    pageTrailer.set(entry.getKey(),kvRange);
                }
            }
        }
        return pageTrailer;
    }

    public static void updateColumnFamilyMeta(String fileStoreName, ColumnFamilyMeta columnFamilyMeta){
        VCFIleWriter.writeAll(columnFamilyMeta.getData(),0,fileStoreName);
    }

    //先假设没有split的情况
    public void addKVs(String dbName,String tabName,String cfName,KeyValueSkipListSet kvs){
        //取出regionMeta
        RegionMeta regionMeta = getRegionMeta(dbName+"."+ tabName);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta,cfName);
        //fileName of fileStore
        String fileName = fileStoreMeta.getEncodedName();
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();

        //根据pageTrailer拆分传入的kvs
        Map<Integer, List<KV>> integerListMap = splitKVsByPage(pageTrailer, kvs);

        //找到需要更新的元数据
        List<KVRange> newPageTrailer = RegionServer.updatePageTrailer(pageTrailer, integerListMap);

        //更新元数据
        fileStoreMeta.setPageTrailer(newPageTrailer);

        //元数据写入文件
        VCFIleWriter.writeAll(fileStoreMeta.getData(),regionMeta.getFileStoreName(cfName));

        //写入kvs
        for (Map.Entry<Integer, List<KV>> entry : integerListMap.entrySet()) {
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(entry.getKey()).getPageLength(),kvsToByteArray(entry.getValue()),entry.getKey(),fileName);
        }
    }

    public static RegionMeta getRegionMeta(String tableName){
        //取出的应该缓存
        Map<String, String> regionMap = regionServerMeta.getRegionMap();
        return new RegionMeta(VCFileReader.readAll(regionMap.get(tableName)));
    }

    //接受rpc调用
    //获取元数据
    // responseObserver 为返回值
    @Override
    public void getRegionMeta(Empty request, StreamObserver<Meta.regionMeta> responseObserver) {
        Meta.regionMeta regionMeta= null;
        //获取元数据

        //返回元数据
        responseObserver.onNext(regionMeta);
        //告知本次处理完毕
        responseObserver.onCompleted();
    }
    //合并KV里的ValueNode
    public int MergeKV(String dbName,String tableName,String cfName,String rowKey,int versionFrom,int versionTo){
        return 1;
    }

}
