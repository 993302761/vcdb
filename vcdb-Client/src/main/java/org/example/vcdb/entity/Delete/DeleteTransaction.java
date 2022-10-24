package org.example.vcdb.entity.Delete;

import org.example.vcdb.entity.Post.RequestEntity;

public class DeleteTransaction extends RequestEntity {
    private String explainValue;

    public String getExplainValue() {
        return explainValue;
    }

    public void setExplainValue(String explainValue) {
        this.explainValue = explainValue;
    }
}
