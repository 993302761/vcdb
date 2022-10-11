package org.example.vcdb.store.region;

import org.example.vcdb.store.mem.KeyValueSkipListSet;
import org.example.vcdb.store.mem.MemStore;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DaemonRegion
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/10 下午10:29
 * @Version 1.0
 */

public class DaemonRegion {
    public static void main(String[] args) {
        int count=5;
        //一秒检查一下size,count-1
        //当检查到满的时候调用落盘，或者检查到count==0时候落盘，落盘之后都会把count还原成5
        // 创建任务队列   10 为线程数量
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        // 执行任务,里面写执行代码
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (RegionServer.inboundMemStore.size()==5){
                /*db.table:cf*/
                Map<String, MemStore> inboundMemStore=RegionServer.inboundMemStore;
                for (Map.Entry<String,MemStore> entry : inboundMemStore.entrySet()) {
                    String[] keys = entry.getKey().split(":");
                    KeyValueSkipListSet kvSet = entry.getValue().kvSet;

//                    RegionServer.insertPageWithSplit(keys[0],keys[1],);

                }

            }
        }, 1, 1, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次
    }
}
