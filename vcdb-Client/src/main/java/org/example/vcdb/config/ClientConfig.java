package org.example.vcdb.config;



import org.example.vcdb.util.IOUtils;


import java.util.Properties;

/**
 * @ClassName clientCofig
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/16 下午5:12
 * @Version 1.0
 */

public class ClientConfig {
    // 监听指定的端口
    static String masterHost;
    static int masterPort;
    static String backupHost;
    static int backupPort;
    public static void init(){
        Properties properties = IOUtils.getProperties("/MyProject/vcdb/vcdb-Client/src/main/resources/client.properties");
        masterHost=properties.getProperty("master.ip");
        masterPort=Integer.parseInt(properties.getProperty("master.port"));
        backupHost=properties.getProperty("backup.ip");
        backupPort=Integer.parseInt(properties.getProperty("backup.port"));
    }
}


