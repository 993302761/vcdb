package org.example.vcdb.store.region.version;

/**
 * @ClassName TableAlter
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/20 下午6:23
 * @Version 1.0
 */

public class TableAlter {
    byte[] data;
    public TableAlter(long timestamp, byte method, byte type,boolean unique,
                      String min, String max, String tableName,
                      String cfName, String oldCfName){

    }
}
