package org.example.vcdb.store.region;

/**
 * @ClassName CFTerm
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/16 下午6:30
 * @Version 1.0
 */

public class CFTerm {
    /**
     * cf_name : 列族名称
     * c_name : 列名
     * version-from : 原来版本号
     * version-to : 新版本号
     * max : 最大值
     * size : 大小
     * min : 最小值
     * like : 模糊(%表示多个字符，_表示一个字符)
     * tablename : 表名
     */

    private String cf_name="";
    private String c_name="";
    private String max="";
    private String equivalence="";
    private String min="";
    private String like="";

    public CFTerm(String cf_name, String c_name,
                  String max, String equivalence,
                  String min, String like) {
        this.cf_name = cf_name;
        this.c_name = c_name;
        this.max = max;
        this.equivalence = equivalence;
        this.min = min;
        this.like = like;
    }

    public String getCf_name() {
        return cf_name;
    }

    public String getC_name() {
        return c_name;
    }


    public String getMax() {
        return max;
    }

    public String getEquivalence() {
        return equivalence;
    }

    public String getMin() {
        return min;
    }

    public String getLike() {
        return like;
    }

    public void setCf_name(String cf_name) {
        this.cf_name = cf_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setEquivalence(String equivalence) {
        this.equivalence = equivalence;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
