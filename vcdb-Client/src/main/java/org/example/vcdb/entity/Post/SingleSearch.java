package org.example.vcdb.entity.Post;


import org.example.vcdb.entity.Cell.Aggregate;
import org.example.vcdb.entity.Cell.Order;
import org.example.vcdb.entity.Cell.TermCell;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class SingleSearch extends RequestEntity {
    int limit;
    private List<String> cf_names;

    private List<TermCell> terms;

    private List<Order> orders;

    private List<Aggregate> aggregate;

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setCf_names(List<String> cf_names) {
        this.cf_names = cf_names;
    }

    public void setTerms(List<TermCell> terms) {
        this.terms = terms;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setAggregate(List<Aggregate> aggregate) {
        this.aggregate = aggregate;
    }
}
