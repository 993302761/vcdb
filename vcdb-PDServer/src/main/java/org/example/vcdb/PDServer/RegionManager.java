package org.example.vcdb.PDServer;

<<<<<<< HEAD
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegionManager {
    //定时读取加载元数据
    public void readMeta(){
        // 创建任务队列   10 为线程数量
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() -> {

            //连接regionServer

            //获取元数据RegionMeta

            //处理

        }, 1, 3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次

=======
public class RegionManager {
    //定时读取加载元数据
    public void readMeta(){
>>>>>>> 91aae6775cc8e3dbe43c43f92cf64035b801fe42

    }
}
