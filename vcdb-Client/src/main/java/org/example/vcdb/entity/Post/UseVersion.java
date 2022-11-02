package org.example.vcdb.entity.Post;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */

public class UseVersion extends RequestEntity {
    private String rowKey;
    private String cfName;

    private int version=Integer.MAX_VALUE;

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRowKey() {
        return rowKey;
    }

    public String getCfName() {
        return cfName;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public int getVersion() {
        return version;
    }
}
