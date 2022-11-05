package org.example.vcdb.store.entity.Post;


import org.example.vcdb.store.entity.Cell.TermCell;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class SingleSearch extends RequestEntity {
    int limit;

    private List<String> cf_names;

    //为了用列来限定(找)行，找到符合条件的几行
    private List<TermCell> terms;

    String orderCfName;
    //0 desc
    //1 asc
    boolean sort;

//    private List<Aggregate> aggregate;

    public byte[] getCfNameByteArray(){
        int cfNamesLength=0;
        for (String cfName:cf_names){
            cfNamesLength+=4+cfName.getBytes().length;
        }
        byte[] bytes=new byte[4+cfNamesLength];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,terms.size());
        for (String cfName:cf_names){
            pos= Bytes.putInt(bytes,pos,cfName.getBytes().length);
            pos= Bytes.putBytes(bytes,pos,cfName.getBytes(),0,cfName.getBytes().length);
        }
        return bytes;
    }

    public byte[] getTermsByteArray(){
        int termsLength=0;
        for (TermCell termCell:terms){
            termsLength+=termCell.toByteArray().length;
        }
        byte[] bytes=new byte[4+termsLength];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,terms.size());
        for (TermCell termCell:terms){
            pos= Bytes.putBytes(bytes,pos,termCell.toByteArray(),0,termCell.toByteArray().length);
        }
        return bytes;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setCf_names(List<String> cf_names) {
        this.cf_names = cf_names;
    }

    public void setTerms(List<TermCell> terms) {
        this.terms = terms;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    public void setOrderCfName(String orderCfName) {
        this.orderCfName = orderCfName;
    }

    public int getLimit() {
        return limit;
    }

    public String getOrderCfName() {
        return orderCfName;
    }

    public boolean isSort() {
        return sort;
    }

    //    public void setAggregate(List<Aggregate> aggregate) {
//        this.aggregate = aggregate;
//    }
}
