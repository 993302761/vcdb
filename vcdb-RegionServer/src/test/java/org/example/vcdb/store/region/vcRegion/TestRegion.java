package org.example.vcdb.store.region.vcRegion;

import org.example.vcdb.store.region.Region.RegionMeta;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName TestRegion
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/26 下午8:55
 * @Version 1.0
 */

public class TestRegion {
    @Test
    public void testRegionMeta(){
        String metaName="regionMeta1";
        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 1; i < 4; i++) {
            map.put("cf"+i,"fileStoreMeta/fileStoreMeta"+i);
        }
        RegionMeta regionMeta=new RegionMeta(metaName,map);
        regionMeta.dis();
    }
}
