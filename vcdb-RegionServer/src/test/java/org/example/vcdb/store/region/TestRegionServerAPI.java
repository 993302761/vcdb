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

import static org.example.vcdb.store.region.fileStore.FileStore.*;

/**
 * @ClassName TestRegionServer
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/26 下午5:46
 * @Version 1.0
 */

public class TestRegionServerAPI {
    @Test
    public void testRegionServer(){
        RegionServerAPI.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta("db.table1");
        FileStoreMeta cf1 = RegionServerAPI.getFileStoreMeta(regionMeta, "cf1");
        cf1.dis();
//        List<KVRange> pageTrailer = RegionServer.getPageTrailer("db.table1:cf1");
//        System.out.println(pageTrailer);
    }


    @Test
    public void testRegionServerMeta(){
        Map<String,TableTrailer> map=new ConcurrentHashMap<>();
        for (int i = 1; i < 3; i++) {
            map.put("db.table"+i,new TableTrailer(new Date().getTime(),"region/regionMeta"+i));
        }
        byte[] ip4=new byte[]{127,0,0,1};
        int port=9091;
        RegionServerMeta serverMeta=new RegionServerMeta("regionServerMeta",ip4,port,map);
        VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");
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
        Map<String, TableTrailer> regionMap = serverMeta.getRegionMap();
        /*应该查重*/
        regionMap.put(dbName +"."+tabName,new TableTrailer(new Date().getTime(),regionMetaFileName));
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
                fileStoreName, "r1".getBytes(), "r2".getBytes());
        VCFIleWriter.writeAll(fileStoreMeta.getData(), fileStoreMetaName);

        /*创建fileStore*/
        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta("1", "100",true, false,  ColumnFamilyMeta.byteToCFType((byte) 44));
        FileStore fileStore=new FileStore(cfMeta);
        VCFIleWriter.writeAll(fileStore.getData(), fileStoreName);
    }

    @Test
    public void testAddKVs(){
        //通过tableName找到regionMeta,通过cfName找到fileStore
        String dbName="db2";
        String tabName="table2";
        String cfName="cf2";
        int pageIndex=1;

        RegionServerAPI.readConfig("regionServerMeta");
        RegionServerAPI.regionServerMeta.dis();
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName+"."+tabName);
        FileStoreMeta fileStoreMeta = RegionServerAPI.getFileStoreMeta(regionMeta, cfName);
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

        KV kv = new KV(row, 0, row.length,  values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        try {
            List<KVRange> pageTrailer = fileStoreMeta.getPageTrailer();
            VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(pageTrailer.get(pageIndex).getPageLength(),kvsToByteArray(kvs),pageIndex,fileStoreMeta.getEncodedName());
            FileStore fileStore2=new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));
            disDataSet(fileStore2.getDataSet(pageIndex));
            fileStore2.dis();
            RegionServerAPI.updatePageTrailer(kvs,fileStoreMeta.getPageTrailer(),pageIndex);
        }catch (Exception e){
            List<KVRange> pageTrailer = new ArrayList<>();
            VCFIleWriter.appendDataSetToFileStorePage(0,Bytes.toBytes((int)1),pageIndex,fileStoreMeta.getEncodedName());
            VCFIleWriter.appendDataSetToFileStorePage(4,kvsToByteArray(kvs),pageIndex,fileStoreMeta.getEncodedName());
            FileStore fileStore2=new FileStore(VCFileReader.readAll(fileStoreMeta.getEncodedName()));
            disDataSet(fileStore2.getDataSet(pageIndex));
            fileStore2.dis();
//            System.out.println(pageIndex);
            String minKey = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
            String maxKey = "\u0000";
            int pageLength = getKVsLength(kvs);
            minKey=kvs.first().getRowKey();
            maxKey=kvs.last().getRowKey();
            pageTrailer.add(0,new KVRange(new Date().getTime(),pageLength, minKey, maxKey));
//            return pageTrailer;
//            List<KVRange> kvRanges = RegionServer.updatePageTrailer(kvs, pageTrailer, pageIndex);
            System.out.println(pageTrailer);
            fileStoreMeta.setPageTrailer(pageTrailer);
            VCFIleWriter.writeAll(fileStoreMeta.getData(), 0, regionMeta.getfileStoreMetaName(cfName));
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
            kvs.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length,  values));
        }

        kvs.add(new KV(("row2").getBytes(), 0, ("row2").getBytes().length, values));
        kvs.add(new KV(("row1").getBytes(), 0, ("row1").getBytes().length, values));

//        for (KV kv:kvs){
//            System.out.println(kv.getRowKey());
//        }

        KeyValueSkipListSet kvs1 = new KeyValueSkipListSet(new KV.KVComparator());
        for (int i = 7; i < 12; i++) {
            kvs1.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length,  values));
        }
        kvs.addKVs(kvs1);

        for (KV kv:kvs){
            System.out.println(kv.getRLength());
            System.out.println(kv.getRowKey());
        }
        System.out.println(kvs.first().getRowKey());
        System.out.println(kvs.last().getRowKey());
        System.out.println(kvs);
    }

    @Test
    public void addKVsWithoutSplit(){
        testCreateDB();
        String dbName="db2";
        String tabName="table2";
        String cfName="cf2";
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        List<KV.ValueNode> values = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }

        for (int i = 0; i < 40; i++) {
            kvs.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length,  values));
        }

        RegionServerAPI.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName+"."+tabName);
        FileStoreMeta fileStoreMeta = RegionServerAPI.getFileStoreMeta(regionMeta, cfName);
        Map<Integer, List<KV>> integerListMap = RegionServerAPI.splitKVsByPage(fileStoreMeta.getPageTrailer(), kvs);
        for (Map.Entry<Integer,List<KV>> entry : integerListMap.entrySet()) {
            RegionServerAPI.insertPageWithSplit(dbName+"."+tabName,cfName,entry.getKey(),entry.getValue());
        }
        ttt();
    }

    @Test
    public void addKVsWithSplit(){
        String dbName="db2";
        String tabName="table2";
        String cfName="cf2";
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        List<KV.ValueNode> values = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }

        for (int i = 40 ; i < 140; i++) {
            kvs.add(new KV(("row"+i).getBytes(), 0, ("row"+i).getBytes().length, values));
        }
        RegionServerAPI.readConfig("regionServerMeta");
        RegionMeta regionMeta = RegionServerAPI.getRegionMeta(dbName+"."+tabName);
        FileStoreMeta fileStoreMeta = RegionServerAPI.getFileStoreMeta(regionMeta, cfName);
        Map<Integer, List<KV>> integerListMap = RegionServerAPI.splitKVsByPage(fileStoreMeta.getPageTrailer(), kvs);
        for (Map.Entry<Integer,List<KV>> entry : integerListMap.entrySet()) {
            if (!entry.getValue().isEmpty()){
                RegionServerAPI.insertPageWithSplit(dbName+"."+tabName,cfName,entry.getKey(),entry.getValue());
            }
        }
        ttt();
    }



    @Test
    public void ttt(){
        FileStore fileStore2=new FileStore(VCFileReader.readAll("fileStore/fileStore2"));
        FileStore.disDataSet(fileStore2.getDataSet(1));
        System.out.println("==========================================");
        FileStore.disDataSet(fileStore2.getDataSet(2));
        System.out.println("==========================================");
        FileStore.disDataSet(fileStore2.getDataSet(3));
        FileStoreMeta fileStoreMeta=new FileStoreMeta(VCFileReader.readAll("fileStoreMeta/fileStoreMeta2"));
        fileStoreMeta.dis();
    }
}