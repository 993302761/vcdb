package org.example.vcdb.entity.Post;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class DeleteVersion extends RequestEntity {
    private String cfName;
    private String rowKey;
    private int version;

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCfName(String cfName) {
        this.cfName = cfName;
    }

    public String getRowKey() {
        return rowKey;
    }

    public int getVersion() {
        return version;
    }

    public String getCfName() {
        return cfName;
    }
}
