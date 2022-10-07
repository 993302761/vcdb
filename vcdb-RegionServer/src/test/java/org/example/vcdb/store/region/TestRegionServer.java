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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        String fileStoreMetaName="fileStoreMeta/fileStoreMeta2";
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

        /*创建regionMeta*/
        Map<String, String> fileStoreMap = new ConcurrentHashMap<>();
        for (int i = 1; i < 4; i++) {
            fileStoreMap.put("cf" + i, "fileStoreMeta/fileStoreMeta" + i);
        }
        RegionMeta regionMeta = new RegionMeta(regionMetaFileName, fileStoreMap);
        VCFIleWriter.writeAll(regionMeta.getData(), regionMetaFileName);

        /*创建fileStoreMeta*/
        FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                fileStoreName, "r1".getBytes(), "r2".getBytes(), tabName,dbName);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), fileStoreMetaName);

        /*创建fileStore*/
        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(true, false, 1, 100, ColumnFamilyMeta.byteToCFType((byte) 44));
        FileStore fileStore=new FileStore(cfMeta);
        VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
    }

    @Test
    public void testAddKVs(){
        //通过tableName找到regionMeta,通过cfName找到fileStore
        String dbName="db2";
        String tabName="table2";
        String cfName="cf2";

        RegionServer.readConfig("regionServerMeta");
        RegionServer.regionServerMeta.dis();
        RegionMeta regionMeta = RegionServer.getRegionMeta(dbName+"."+tabName);
        FileStoreMeta fileStoreMeta = RegionServer.getFileStoreMeta(regionMeta, cfName);
        System.out.println(fileStoreMeta.getEncodedName());

        //创建一个kvs
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


        try {
            List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
            int pageIndex=1;
            VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(),kvsToByteArray(kvs),pageIndex,fileStoreMeta.getEncodedName());
            FileStore fileStore2=new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));
            disDataSet(fileStore2.getDataSet(pageIndex));
            fileStore2.dis();
        }catch (Exception e){
            int pageIndex=1;
//            VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(0,Bytes.toBytes((int)1),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(4,kvsToByteArray(kvs),pageIndex,fileStoreMeta.getEncodedName());
            FileStore fileStore2=new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));
            disDataSet(fileStore2.getDataSet(pageIndex));
            fileStore2.dis();
        }

    }

    @Test
    public void testKvs(){
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        List<KV.ValueNode> values = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }

        for (int i = 2; i < 7; i++) {
            kvs.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length, ("family"+i).getBytes(), 0, ("family"+i).getBytes().length, values));
        }

        kvs.add(new KV(("row2").getBytes(), 0, ("row2").getBytes().length, ("family2").getBytes(), 0, ("family2").getBytes().length, values));
        kvs.add(new KV(("row1").getBytes(), 0, ("row1").getBytes().length, ("family1").getBytes(), 0, ("family1").getBytes().length, values));

//        for (KV kv:kvs){
//            System.out.println(kv.getRowKey());
//        }

        KeyValueSkipListSet kvs1 = new KeyValueSkipListSet(new KV.KVComparator());
        for (int i = 7; i < 12; i++) {
            kvs1.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length, ("family"+i).getBytes(), 0, ("family"+i).getBytes().length, values));
        }
        kvs.addKVs(kvs1);

        for (KV kv:kvs){
            System.out.println(kv.getRLength());
            System.out.println(kv.getRowKey());
        }

        System.out.println(kvs);
    }
}