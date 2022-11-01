package org.example.vcdb.entity.Post;




import org.example.vcdb.entity.Cell.TermCell;
import org.example.vcdb.entity.Cell.Value;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class UpdateCells extends RequestEntity {

    //为了用列来限定行，找到符合条件的几行
    private List<TermCell> terms;

    private List<Value> values;

    public byte[] getValuesByteArray(){
        int valuesLength=0;
        for (Value value:values){
            valuesLength+=value.toByteArray().length;
        }
        byte[] bytes=new byte[4+valuesLength];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,values.size());
        for (Value value:values){
            Bytes.putBytes(bytes,pos,value.toByteArray(),0,value.toByteArray().length);
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
            Bytes.putBytes(bytes,pos,termCell.toByteArray(),0,termCell.toByteArray().length);
        }
        return bytes;
    }

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
