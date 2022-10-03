package org.example.vcdb.entity.Cell;


/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class ColumnFamilyCell{
    private String cf_name;
    private String type;
    private long min=Long.MIN_VALUE;
    private long max=Long.MAX_VALUE;
    private Boolean unique;
    private Boolean isNull;
//    private String method;

    public String getCf_name() {
        return cf_name;
    }

    public String getType() {
        return type;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public Boolean isUnique() {
        return unique;
    }

    public Boolean isNull() {
        return isNull;
    }


//    public String getMethod() {
//        return method;
//    }

    public void setCf_name(String cf_name) {
        this.cf_name = cf_name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

//    public void setMethod(String method) {
//        this.method = method;
//    }
}
