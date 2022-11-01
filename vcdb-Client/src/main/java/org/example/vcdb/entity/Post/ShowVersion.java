package org.example.vcdb.entity.Post;



/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class ShowVersion extends RequestEntity {
    private String rowKey;
    public String cfName;

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getRowKey() {
        return rowKey;
    }

    public String getCfName() {
        return cfName;
    }
}
