package org.example.vcdb.entity.Post;




import org.example.vcdb.entity.Cell.TermCell;
import org.example.vcdb.entity.Cell.Value;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class UpdateCells extends RequestEntity {

    //为了用列来限定行，找到符合条件的几行
    private List<TermCell> terms;


    private List<Value> values;

    public void setTerms(List<TermCell> terms) {
        this.terms = terms;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public int getCount(){
        return values.size();
    }

}
