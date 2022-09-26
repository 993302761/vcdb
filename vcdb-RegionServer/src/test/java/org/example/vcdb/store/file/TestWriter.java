package org.example.vcdb.store.file;
import org.junit.Test;

/**
 * @ClassName TestWriter
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/25 下午6:13
 * @Version 1.0
 */

public class TestWriter {
    @Test
    public void testWriter(){
        VCFIleWriter.setRegionServerMeta("2hello world!!!!!!!!".getBytes(),"regionServerMeta");
    }
}
