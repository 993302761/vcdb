package org.example.vcdb.entity.Delete;




import org.example.vcdb.entity.Cell.TermCell;
import org.example.vcdb.entity.Post.RequestEntity;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class DeleteCells extends RequestEntity {
    private List<String> cf_names;

    //为了筛选行
    private List<TermCell> terms;

    public void setCf_names(List<String> cf_names) {
        this.cf_names = cf_names;
    }

    public void setTerms(List<TermCell> terms) {
        this.terms = terms;
    }

    public int getCount(){
        return terms.size();
    }
}
