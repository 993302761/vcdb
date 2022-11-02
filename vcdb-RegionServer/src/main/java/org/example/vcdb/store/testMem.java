package org.example.vcdb.store;

import org.example.vcdb.store.region.RegionServerAPI;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class testMem {
    public static void tet() {
        AtomicInteger oldCount = new AtomicInteger(0);
        AtomicInteger count = new AtomicInteger(0);
        //一秒检查一下size,count-1
        //当检查到满的时候调用落盘，或者检查到count==0时候落盘，落盘之后都会把count还原成5
        // 创建任务队列   10 为线程数量
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        // 执行任务,里面写执行代码
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("======================================");
            System.out.println(RegionServer.dbMap);
            System.out.println(RegionServer.tableAlterMap);
            System.out.println(RegionServer.tableMap);
            System.out.println(RegionServer.inboundMemStore);
            System.out.println(RegionServer.transactionMap);
        }, 1, 5, TimeUnit.SECONDS);// 1s 后开始执行，每 1s 执行一次
    }
}
