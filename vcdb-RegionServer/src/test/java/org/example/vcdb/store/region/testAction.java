package org.example.vcdb.store.region;

import org.example.vcdb.store.RegionServer;
import org.example.vcdb.store.entity.Cell.ColumnFamilyCell;
import org.example.vcdb.store.entity.Cell.TermCell;
import org.example.vcdb.store.entity.Cell.Value;
import org.example.vcdb.store.entity.Post.PutCells;
import org.example.vcdb.store.entity.Post.SingleSearch;
import org.example.vcdb.store.entity.Put.CreateTable;
import org.example.vcdb.store.region.fileStore.ColumnFamilyMeta;
import org.example.vcdb.util.Bytes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void startDaemonRegionServer(){
        DaemonRegionServer.async();
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
        boolean table =
                RegionServerAPI.createTable("testDb16", "testTable16", createTable.toByteArray());
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
        PutCells putCells=new PutCells();
        putCells.setRowKey("testRow");
        List<Value> values=new ArrayList<>();
        Value value=new Value();
        value.setCf_name("testCf");
        value.setC_name("testC5");
        value.setValue("55");
        values.add(value);
        putCells.setValues(values);
        RegionServerAPI.putCells("testDb16","testTable16",putCells.getRowKey(),putCells.valuesToByteArray());
        DaemonRegionServer.async();
        while (true){

        }
//        System.out.println("end");
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
        int limit = 10;
        List<String> cfNames=new ArrayList<>();
        cfNames.add("testCf");
        List<TermCell> termCells=new ArrayList<>();
        TermCell termCell = new TermCell();
        termCell.setCf_name("testCf");
        termCell.setMax("100");
        termCell.setMin("1");
        termCell.setEquivalence("5");
        termCells.add(termCell);
        SingleSearch singleSearch=new SingleSearch();
        singleSearch.setCf_names(cfNames);
        singleSearch.setTerms(termCells);
        singleSearch.setLimit(limit);
        singleSearch.setOrderCfName("testCf");
        singleSearch.setSort(true);
        byte[] bytes = RegionServerAPI.singleSearch("testDb16", "testTable16",
                singleSearch.getLimit(), singleSearch.getOrderCfName(),
                singleSearch.isSort(), singleSearch.getCfNameByteArray(),
                singleSearch.getTermsByteArray());
        System.out.println("==================================");
        System.out.println(Bytes.toString(bytes));
    }

    @Test
    public void testUpdateCells(){

    }

    @Test
    public void testDeleteCells(){

    }

}
