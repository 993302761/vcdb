package org.example.vcdb.store.file;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/x2/vcdb/regionServerMeta", "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(1024);
            //读操作
            int bytesRead = fileChannel.read(buf);
            //读写切换
            buf.flip();
            System.out.println(bytesRead);
            System.out.println("-------------------");
//            while (bytesRead != -1) {
////                while (buf.position() < 3) {
////                    System.out.print((char) buf.get());
////                }
////                System.out.println();
////                buf.compact();
////                bytesRead = fileChannel.read(buf);
////                System.out.println(bytesRead);
//
//            }
            while (buf.position()!=bytesRead){
                byte b = buf.get();
                System.out.println(b);
                System.out.println((char) b);
            }
            System.out.println("-------------------");
            ByteBuffer buf1 = ByteBuffer.allocateDirect(100);
            buf1.put("ssssssssssssssssssssssssssss".getBytes());
            buf1.limit("ssssssssssssssssssssssssssss".getBytes().length);
            buf1.flip();
            fileChannel.position(0);
            fileChannel.write(buf1);
            fileChannel.force(true);
            buf1.clear();
            buf1.compact();
            buf1.rewind();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
