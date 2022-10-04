package org.example.vcdb.store.region;

import org.example.vcdb.store.file.VCFIleWriter;
import org.example.vcdb.store.file.VCFileReader;
import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.example.vcdb.util.Bytes;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static org.example.vcdb.store.region.fileStore.FileStore.disDataSet;
import static org.example.vcdb.store.region.fileStore.FileStore.kvsToByteArray;

/**
 * @ClassName TestRegionServer
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/26 下午5:46
 * @Version 1.0
 */

public class TestRegionServer {
    @Test
    public void testRegionServer(){
        RegionServer.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServer.getRegionMeta("db.table1");
        FileStoreMeta cf1 = RegionServer.getFileStoreMeta(regionMeta, "cf1");
        cf1.dis();
//        List<KVRange> pageTrailer = RegionServer.getPageTrailer("db.table1:cf1");
//        System.out.println(pageTrailer);
    }


    @Test
    public void testRegionServerMeta(){
        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 1; i < 3; i++) {
            map.put("db.table"+i,"region/regionMeta"+i);
        }
        byte[] ip4=new byte[]{127,0,0,1};
        int port=9091;
        RegionServerMeta serverMeta=new RegionServerMeta("regionServerMeta",ip4,port,map);
        serverMeta.dis();
    }
    @Test
    public void testCreateDB(){
        String dbName="db2";
        String tabName="table2";
        String regionMetaFileName="region/regionMeta22";
        String fileStoreName="fileStore/fileStore2";
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
        VCFIleWriter.writerAll(serverMeta.getData(), "regionServerMeta");

        /*创建regionMeta*/
        Map<String, String> fileStoreMap = new ConcurrentHashMap<>();
        for (int i = 1; i < 4; i++) {
            regionMap.put("cf" + i, "fileStoreMeta/fileStoreMeta" + i);
        }
        RegionMeta regionMeta = new RegionMeta(regionMetaFileName, fileStoreMap);
        VCFIleWriter.writerAll(regionMeta.getData(), regionMetaFileName);

        /*创建fileStoreMeta*/
        FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                fileStoreName, "r1".getBytes(), "r2".getBytes(), tabName,dbName);
        VCFIleWriter.writerAll(fileStoreMeta.getData(), fileStoreName);

        /*创建fileStore*/
        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(true, false, 1, 100, ColumnFamilyMeta.byteToCFType((byte) 44));
        FileStore fileStore=new FileStore(cfMeta);
        VCFIleWriter.writerAll(fileStore.getData(), fileStoreName);
    }

    @Test
    public void testAddKVs(){
        //通过tableName找到regionMeta,通过cfName找到fileStore
        String dbName="db2";
        String tabName="table2";
        String cfName="cf1";
        RegionServer.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServer.getRegionMeta(dbName+"."+tabName);
        FileStoreMeta fileStoreMeta = RegionServer.getFileStoreMeta(regionMeta, cfName);
        List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
        //创建一个kvs并且插入
        byte[] row = "row2".getBytes(StandardCharsets.UTF_8);
        byte[] family = "fam2".getBytes(StandardCharsets.UTF_8);
        List<KV.ValueNode> values = new ArrayList<>();
        for (int i = 3; i <= 4; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }
        KV kv = new KV(row, 0, row.length, family, 0, family.length, values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        int pageIndex=1;
        VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),pageIndex,fileStoreMeta.getEncodedName());
        VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(),kvsToByteArray(kvs),1,fileStoreMeta.getEncodedName());
        FileStore fileStore2=new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));
        disDataSet(fileStore2.getDataSet(pageIndex));
        fileStore2.dis();
    }
}
