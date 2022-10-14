package org.example.vcdb.entity.Post;
/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class OpenTransaction extends RequestEntity{
    private String explainValue;

    public void setExplainValue(String explainValue) {
        this.explainValue = explainValue;
    }

    public String getExplainValue() {
        return explainValue;
    }
}
