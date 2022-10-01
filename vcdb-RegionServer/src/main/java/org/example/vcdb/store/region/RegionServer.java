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
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    public static List<KVRange> getPageTrailer(String dbAndCf){
        String[] str=dbAndCf.split(":");
        RegionMeta regionMeta = getRegionMeta(str[0]);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta,str[1]);
        return fileStoreMeta.getPageTrailer();
    }
    public static Map<Integer,List<KV>> splitKVsByPage(List<KVRange> pageTrailer, KeyValueSkipListSet kvSet){
        Map<Integer,List<KV>> integerListMap=new ConcurrentHashMap<>();
        for (KV kv:kvSet){
            int i=1;
            for (KVRange kvRange:pageTrailer){
                if (kv.getRowKey().compareTo(Bytes.toString(kvRange.getEndKey()))<=0){
                    if (integerListMap.containsKey(i)){
                        List<KV> kvs=new ArrayList<>();
                        kvs.add(kv);
                        integerListMap.put(i,kvs);
                    }else {
                        List<KV> kvs=integerListMap.get(i);
                        kvs.add(kv);
                    }
                }
            }
        }
        return integerListMap;
    }
    //先假设没有split的情况
    public void addKVs(String dbAndCf,KeyValueSkipListSet kvs){
        String[] str=dbAndCf.split(":");
        RegionMeta regionMeta = getRegionMeta(str[0]);
        FileStoreMeta fileStoreMeta = getFileStoreMeta(regionMeta,str[1]);
        //fileName of fileStore
        String fileName = fileStoreMeta.getEncodedName();
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
        Map<Integer, List<KV>> integerListMap = splitKVsByPage(pageTrailer, kvs);
        for (Map.Entry<Integer, List<KV>> entry : integerListMap.entrySet()) {
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(entry.getKey()).getPageLength(),kvsToByteArray(entry.getValue()),entry.getKey(),fileName);
        }
    }

    public static RegionMeta getRegionMeta(String tableName){
        //取出的应该缓存
        Map<String, String> regionMap = regionServerMeta.getRegionMap();
        return new RegionMeta(VCFileReader.readAll(regionMap.get(tableName))) ;
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
    //添加数据集合
    public int addKVSet(KeyValueSkipListSet kvSet){
        return 1;
    }
    //合并KV里的ValueNode
    public int MergeKV(String dbName,String tableName,String cfName,String rowKey,int versionFrom,int versionTo){
        return 1;
    }
}
