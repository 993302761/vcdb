package org.example.vcdb.store.entity.Post;


import org.example.vcdb.store.entity.Cell.AlterCell;
import org.example.vcdb.util.Bytes;

import java.util.List;


/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class AlterTable extends RequestEntity {
    private List<AlterCell> alter_cells;

    public void setAlter_cells(List<AlterCell> alter_cells) {
        this.alter_cells = alter_cells;
    }

    public byte[] alterCellsToByteArray(){
        int length=0;
        for (AlterCell alterCell :alter_cells){
            length += alterCell.toByteArray().length;
        }
        byte[] bytes=new byte[4+length];
        int count=this.alter_cells.size();
        int pos=0;
        pos=Bytes.putInt(bytes,pos,count);
        for (AlterCell alterCell:alter_cells){
            pos=Bytes.putBytes(bytes,pos,alterCell.toByteArray(),0,alterCell.toByteArray().length);
        }
        return bytes;
    }

}


