package org.example.vcdb.entity.Post;


import org.example.vcdb.entity.Cell.VersionTerm;
import org.example.vcdb.util.Bytes;

import java.util.List;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class MergeVersion extends RequestEntity {
    private String rowKey;
    private List<VersionTerm> terms;

    private byte[] toByteArray(){
        int termsLength=0;
        for (VersionTerm versionTerm:terms){
            termsLength+=4+versionTerm.toByteArray().length;
        }
        byte[] bytes=new byte[4+termsLength];
        int pos=0;
        pos= Bytes.putInt(bytes,pos,terms.size());
        for (VersionTerm versionTerm:terms){
            Bytes.putInt(bytes,pos,versionTerm.toByteArray().length);
            Bytes.putBytes(bytes,pos,versionTerm.toByteArray(),0,versionTerm.toByteArray().length);
        }
        return bytes;
    }

    public void setTerms(List<VersionTerm> terms) {
        this.terms = terms;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

}
