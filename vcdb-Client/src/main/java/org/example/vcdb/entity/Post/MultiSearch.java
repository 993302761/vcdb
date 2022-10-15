package org.example.vcdb.entity.Post;





import org.example.vcdb.entity.Cell.JTableCell;
import org.example.vcdb.entity.Cell.Order;
import org.example.vcdb.entity.Cell.TermCell;

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


}
