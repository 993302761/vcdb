package org.example.vcdb.entity.Post;





import org.example.vcdb.entity.Cell.JTableCell;
import org.example.vcdb.entity.Cell.Order;
import org.example.vcdb.entity.Cell.TermCell;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class MultiSearch extends RequestEntity {
    private int limit;
    String orderCfName;
    //0 desc
    //1 asc
    boolean sort;
    private List<JTableCell> j_tables;

    private List<String> cf_names;

    private List<TermCell> terms;

    public byte[] getJTablesByteArray() {
        int jTablesLength = 0;
        for (JTableCell jTableCell : j_tables) {
            jTablesLength+=jTableCell.toByteArray().length;
        }
        byte[] bytes = new byte[4 + jTablesLength];
        int pos = 0;
        pos= Bytes.putInt(bytes,pos,j_tables.size());
        for (JTableCell jTableCell : j_tables) {
            Bytes.putBytes(bytes,pos,jTableCell.toByteArray(),0,jTableCell.toByteArray().length);
        }
        return bytes;
    }

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

    private byte[] getTermsByteArray(){
        int termsLength=0;
        for (TermCell termCell:terms){
            termsLength+=termCell.toByteArray().length;
        }
        byte[] bytes=new byte[4+termsLength];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,terms.size());
        for (TermCell termCell:terms){
            Bytes.putBytes(bytes,pos,termCell.toByteArray(),0,termCell.toByteArray().length);
        }
        return bytes;
    }

    public void setJ_tables(List<JTableCell> j_tables) {
        this.j_tables = j_tables;
    }

    public void setCf_names(List<String> cf_names) {
        this.cf_names = cf_names;
    }

    public void setTerms(List<TermCell> terms) {
        this.terms = terms;
    }

    public void setOrderCfName(String orderCfName) {
        this.orderCfName = orderCfName;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
