package org.example.vcdb.store.region;

import org.example.vcdb.store.RegionServer;
import org.example.vcdb.store.entity.Cell.*;
import org.example.vcdb.store.entity.Delete.DeleteCells;
import org.example.vcdb.store.entity.Post.*;
import org.example.vcdb.store.entity.Put.CreateTable;
import org.example.vcdb.util.Bytes;
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
    public void startDaemonRegionServer(){
        DaemonRegionServer.async();
    }

    @Test
    public void testOpenTransaction(){
        initRegionServer();
        RegionServerAPI.openTransaction("testTransaction");
    }

    @Test
    public void testCloseTransaction(){
        initRegionServer();
        RegionServerAPI.closeTransaction("testTransaction");
    }

    @Test
    public void testCreateDB(){
        initRegionServer();
        RegionServerAPI.createDB("testDb");
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
        initRegionServer();
        RegionServerAPI.deleteDB("testDb");
    }

    @Test
    public void testDeleteTable(){
        initRegionServer();
        RegionServerAPI.deleteTable("testDb:testTable16");
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
        initRegionServer();
        AlterTable alterTable=new AlterTable();
        List<AlterCell> alterCells=new ArrayList<>();
        AlterCell alterCell=new AlterCell();
        alterCell.setOld_cfName("testCf");
        alterCell.setCfName("newTestCf");
        alterCell.setMax("89");
        alterCell.setMin("22");
        alterCell.setType((byte) 46);
        alterCell.setUnique(true);
        alterCell.setNull(true);
        alterCells.add(alterCell);
        alterTable.setAlter_cells(alterCells);
        RegionServerAPI.alterTable("testDb","testTable",alterTable.alterCellsToByteArray());
    }

    @Test
    public void testMergeVersion(){
        initRegionServer();
        MergeVersion mergeVersion=new MergeVersion();
        List<VersionTerm> versionTerms=new ArrayList<>();
        VersionTerm versionTerm=new VersionTerm();
        versionTerm.setCfName("testCf");
        versionTerm.setRowKey("testRow");
        versionTerm.setVersionFrom(0);
        versionTerm.setVersionTo(1);
        versionTerms.add(versionTerm);
        mergeVersion.setTerms(versionTerms);
        RegionServerAPI.mergeVersion("testDb","testTable",mergeVersion.toByteArray());
    }

    @Test
    public void testUseVersion(){
        initRegionServer();
        UseVersion useVersion=new UseVersion();
        useVersion.setCfName("testCf");
        useVersion.setRowKey("testRow");
        useVersion.setVersion(0);
        boolean b = RegionServerAPI.useVersion("testDb", "testTable",
                useVersion.getRowKey(), useVersion.getCfName(), useVersion.getVersion());
        System.out.println(b);
    }

    @Test
    public void testShowVersion(){
        initRegionServer();
        RegionServerAPI.showVersion("testDb", "testTable","testRow","testCf");
    }

    @Test
    public void testDeleteVersion(){
        initRegionServer();
        RegionServerAPI.deleteVersion("testDb", "testTable","testRow","testCf",0);
    }

    @Test
    public void testSingleSearch(){
        initRegionServer();
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
        UpdateCells updateCells=new UpdateCells();
        List<Value> values=new ArrayList<>();
        Value value=new Value();
        value.setCf_name("testCf");
        value.setC_name("testC5");
        value.setValue("55");
        values.add(value);
        List<TermCell> termCells=new ArrayList<>();
        TermCell termCell = new TermCell();
        termCell.setCf_name("testCf");
        termCell.setMax("100");
        termCell.setMin("1");
        termCell.setEquivalence("5");
        termCells.add(termCell);
        updateCells.setValues(values);
        updateCells.setTerms(termCells);
        RegionServerAPI.updateCells("testDb16", "testTable16",updateCells.getTermsByteArray(),updateCells.getValuesByteArray());
    }

    @Test
    public void testDeleteCells(){
        initRegionServer();
        DeleteCells deleteCells=new DeleteCells();
        List<String> cfNames=new ArrayList<>();
        cfNames.add("testCf");
        List<TermCell> termCells=new ArrayList<>();
        TermCell termCell = new TermCell();
        termCell.setCf_name("testCf");
        termCell.setMax("100");
        termCell.setMin("1");
        termCell.setEquivalence("5");
        termCells.add(termCell);
        deleteCells.setCf_names(cfNames);
        deleteCells.setTerms(termCells);
        RegionServerAPI.deleteCells("testDb16", "testTable16",
                deleteCells.getCfNameByteArray(),deleteCells.getTermsByteArray());
    }

}
