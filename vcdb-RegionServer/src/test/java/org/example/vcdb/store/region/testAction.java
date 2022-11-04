package org.example.vcdb.store.region;

import org.example.vcdb.store.RegionServer;
import org.example.vcdb.store.entity.Cell.ColumnFamilyCell;
import org.example.vcdb.store.entity.Put.CreateTable;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName testAction
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/12 下午2:02
 * @Version 1.0
 */

public class testAction {

    @Test
    public void  initRegionServer(){
        RegionServer.readConfig("regionServerMeta");
    }

    @Test
    public void testOpenTransaction(){
        initRegionServer();
    }

    @Test
    public void testCloseTransaction(){

    }

    @Test
    public void testCreateDB(){

    }

    @Test
    public void testCreateTable(){
        initRegionServer();
        ColumnFamilyCell columnFamilyCell=new ColumnFamilyCell();
        columnFamilyCell.setCf_name("testCf");
        columnFamilyCell.setMin("1");
        columnFamilyCell.setMax("99");
        columnFamilyCell.setType((byte) 46);
        columnFamilyCell.setUnique(false);
        CreateTable createTable=new CreateTable();
        List<ColumnFamilyCell> columnFamilyCells=new ArrayList<>();
        columnFamilyCells.add(columnFamilyCell);
        createTable.setColumn_family(columnFamilyCells);
        boolean table = RegionServerAPI.createTable("testDb", "testTable", createTable.toByteArray());
        if (table){
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }

    @Test
    public void testDeleteDB(){

    }

    @Test
    public void testDeleteTable(){

    }

    @Test
    public void testPutCells(){

    }

    @Test
    public void testAlterTable(){

    }

    @Test
    public void testMergeVersion(){

    }

    @Test
    public void testUseVersion(){

    }


    @Test
    public void testShowVersion(){

    }

    @Test
    public void testDeleteVersion(){

    }

    @Test
    public void testSingleSearch(){

    }

    @Test
    public void testUpdateCells(){

    }

    @Test
    public void testDeleteCells(){

    }

}
