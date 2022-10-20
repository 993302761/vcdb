package org.example.vcdb.store.region;

import org.junit.Test;

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
