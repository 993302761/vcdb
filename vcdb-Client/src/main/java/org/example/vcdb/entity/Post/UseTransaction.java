package org.example.vcdb.entity.Post;

public class UseTransaction extends RequestEntity{
    private String explainValue;

    private  String newExplainValue;

    public String getExplainValue() {
        return explainValue;
    }

    public void setExplainValue(String explainValue) {
        this.explainValue = explainValue;
    }

    public String getNewExplainValue() {
        return newExplainValue;
    }

    public void setNewExplainValue(String newExplainValue) {
        this.newExplainValue = newExplainValue;
    }
}
