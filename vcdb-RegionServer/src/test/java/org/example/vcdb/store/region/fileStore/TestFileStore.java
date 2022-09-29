package org.example.vcdb.store.region.fileStore;

import org.example.vcdb.store.mem.KV;
import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestFileStore
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/26 下午9:25
 * @Version 1.0
 */

public class TestFileStore {
    @Test
    public void testFileStore(){
        List<KVRange> list=new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(new KVRange(1111,"startKey"+i,"endKey"+i));
        }
        FileStoreMeta fileStoreMeta = new FileStoreMeta((new Date()).getTime(), false,
                "fileStoreMeta1", "r1".getBytes(), "r2".getBytes(), "table1","db1",list);
        fileStoreMeta.dis();
        System.out.println("===================================");

        ColumnFamilyMeta cfMeta = new ColumnFamilyMeta(true, false, 1, 100, ColumnFamilyMeta.byteToCFType((byte) 44));
        cfMeta.dis();
        System.out.println("=======================================");

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
        KV kv = new KV(row, 0, row.length, family, 0, family.length, values);
        KeyValueSkipListSet kvs = new KeyValueSkipListSet(new KV.KVComparator());
        kvs.add(kv);
        FileStore fileStore=new FileStore(cfMeta,kvs);
        fileStore.dis();
    }
}
