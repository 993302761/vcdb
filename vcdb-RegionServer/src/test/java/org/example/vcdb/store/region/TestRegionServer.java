package org.example.vcdb.store.region;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName TestRegionServer
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/26 下午5:46
 * @Version 1.0
 */

public class TestRegionServer {
    @Test
    public void testRegionServerMeta(){
        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 1; i < 3; i++) {
            map.put("db.table"+i,"regionMeta"+i);
        }
        byte[] ip4=new byte[]{127,0,0,1};
        int port=9091;
        RegionServerMeta serverMeta=new RegionServerMeta("regionServerMeta",ip4,port,map);
        serverMeta.dis();
    }
}
