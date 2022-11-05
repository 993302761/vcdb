package org.example.vcdb.store.file;

import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.RegionServerMeta;
import org.example.vcdb.store.region.TableTrailer;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.store.region.fileStore.KVRange;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.vcdb.store.region.fileStore.FileStore.*;

/**
 * @ClassName TestWriter
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/25 下午6:13
 * @Version 1.0
 */

public class TestWriterAndReader {
    @Test
    public void testWriter() {
    }
    @Test
    public void testRegionServer(){
        /*-----------------regionServer-------------------*/
        Map<String,TableTrailer> map=new ConcurrentHashMap<>();
        for (int i = 1; i < 3; i++) {
            map.put("db.table"+i,new TableTrailer(new Date().getTime(),"region/regionMeta"+i));
        }
        byte[] ip4=new byte[]{127,0,0,1};
        int port=9091;
        RegionServerMeta serverMeta=new RegionServerMeta("regionServerMeta",ip4,port,map);
//        serverMeta.dis();
        VCFIleWriter.writeAll(serverMeta.getData(), "regionServerMeta");
        RegionServerMeta serverMeta1 = new RegionServerMeta(VCFileReader.readAll("regionServerMeta"));
        serverMeta1.dis();
        System.out.println("------------------------------------------");
    }
    @Test
    public void testRegion(){
        /*--------------------region--------------------------*/
        String metaName = "regionMeta1";
        Map<String, String> regionMap = new ConcurrentHashMap<>();
        for (int i = 1; i < 4; i++) {
            regionMap.put("cf" + i, "fileStoreMeta/fileStoreMeta" + i);
        }
        RegionMeta regionMeta = new RegionMeta(metaName, regionMap);
        VCFIleWriter.writeAll(regionMeta.getData(), "region/regionMeta1");
        RegionMeta regionMeta1=new RegionMeta(VCFileReader.readAll("region/regionMeta1"));
        regionMeta1.dis();
        System.out.println("------------------------------------------");
    }
    @Test
    public void testFileStoreMeta(){
        /*------------------------fileStoreMeta---------------------------------*/
        List<KVRange> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(new KVRange(new Date().getTime(),1111,"startKey"+i,"endKey"+i));
        }
        FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                "fileStore/fileStore1", "r1".getBytes(), "r2".getBytes(), list);
        VCFIleWriter.writeAll(fileStoreMeta.getData(), "fileStoreMeta/fileStoreMeta1");
        FileStoreMeta fileStoreMeta1=new FileStoreMeta(VCFileReader.readAll("fileStoreMeta/fileStoreMeta1"));
        fileStoreMeta1.dis();
        System.out.println("------------------------------------------");
    }
    @Test
    public void testFileStore(){
        /*------------------------------fileStore--------------------------*/
        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta("1", "100", true, false, ColumnFamilyMeta.byteToCFType((byte) 44));
        byte[] row = "row1".getBytes(StandardCharsets.UTF_8);
        byte[] family = "fam1".getBytes(StandardCharsets.UTF_8);
        List<KV.ValueNode> values = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }
        KV kv = new KV(row, 0, row.length, values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        FileStore fileStore=new FileStore(cfMeta,kvs);
        VCFIleWriter.writeAll(fileStore.getData(), "fileStore/fileStore1");
        FileStore fileStore1=new FileStore(VCFileReader.readAll("fileStore/fileStore1"));
        fileStore1.dis();
        System.out.println("------------------------------------------");
    }
    @Test
    public void testSetPage(){
        /*-------------------------page-----------------------*/
        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta("1", "100",true, false,  ColumnFamilyMeta.byteToCFType((byte) 44));
        byte[] row = "row1".getBytes(StandardCharsets.UTF_8);
        byte[] family = "fam1".getBytes(StandardCharsets.UTF_8);
        List<KV.ValueNode> values = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            long time = (new Date()).getTime();
            KV.Type type = KV.byteToType((byte) 4);
            byte[] qualifier = ("qualifier" + i).getBytes(StandardCharsets.UTF_8);
            byte[] value = ("value" + i).getBytes(StandardCharsets.UTF_8);
            values.add(new KV.ValueNode(time, type, qualifier, 0, qualifier.length, value, 0, value.length));
        }
        KV kv = new KV(row, 0, row.length,  values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        FileStore fileStore=new FileStore(cfMeta,kvs);
        VCFIleWriter.writeAll(fileStore.getData(), "fileStore/fileStore1");
        FileStore fileStore1=new FileStore(VCFileReader.readAll("fileStore/fileStore1"));
        fileStore1.dis();
        System.out.println("------------------------------------------");
        VCFIleWriter.setFileStorePage(kvsToPageByteArray(kvs),1,"fileStore/fileStore1");
        FileStore fileStore2=new FileStore(VCFileReader.readAll("fileStore/fileStore1"));
        fileStore2.dis();
    }
    @Test
    public void addKvs(){
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
        KV kv = new KV(row, 0, row.length, values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        VCFIleWriter.updateKvsCountFOrFileStorePage(kvs.size(),1,"fileStore/fileStore1");
        VCFIleWriter.appendDataSetToFileStorePage(98,kvsToByteArray(kvs),1,kvs.size(),"fileStore/fileStore1");
        FileStore fileStore2=new FileStore(VCFileReader.readAll("fileStore/fileStore1"));
        disDataSet(fileStore2.getDataSet(1));
        fileStore2.dis();
    }
}
