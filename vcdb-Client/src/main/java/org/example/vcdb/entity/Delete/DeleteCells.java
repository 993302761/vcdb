package org.example.vcdb.entity.Delete;




import org.example.vcdb.entity.Cell.TermCell;
import org.example.vcdb.entity.Post.RequestEntity;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class DeleteCells extends RequestEntity {
    private List<String> cf_names;

    //为了筛选行
    private List<TermCell> terms;

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

    public byte[] getCfNameByteArray() {
        int cfNamesLength = 0;
        for (String cfName : cf_names) {
            cfNamesLength += cfName.getBytes().length;
        }
        byte[] bytes = new byte[4 + cfNamesLength];
        int pos = 0;
        pos = Bytes.putInt(bytes, pos, terms.size());
        for (String cfName : cf_names) {
            Bytes.putBytes(bytes, pos, cfName.getBytes(), 0, cfName.getBytes().length);
        }
        return bytes;
    }

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
