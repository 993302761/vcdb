package org.example.vcdb.store.file;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName VCFIleWritter
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/24 下午9:06
 * @Version 1.0
 */

public class VCFIleWriter {
    public static void writerAll(byte[] content, String fileName){
        RandomAccessFile accessFile = null;
        try {
            //getFromMap
            accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer contentBuf = ByteBuffer.allocateDirect(content.length);
            contentBuf.put(content);
            contentBuf.limit(content.length);
            contentBuf.flip();
            fileChannel.position(0);
            while (contentBuf.hasRemaining()) fileChannel.write(contentBuf);
            /*上面的代码是获取文件通道的位置和大小。truncate()方法是截取1024大小的数据，
            指定长度后面的部分将被删除。以及将数据强制刷新到硬盘中，因为系统会将数据先保存在内存中，
            不保证数据会立即写入到硬盘中，所以有这个需求，就可以直接强制数据写入内存中。*/
            fileChannel.truncate(content.length);
            fileChannel.force(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (accessFile != null) {
                    accessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setRegionMeta(byte[] content,String fileName){

    }
    public static void setFileStoreMeta(byte[] content,String fileName){

    }
    public static void setFileStore(byte[] content,String fileName){

    }
    public static void setFileStorePage(byte[] content,int pageIndex,String fileName){

    }
    public static void appendDataSetToFileStorePage(byte[] DataSet,int pageIndex,String fileName){

    }
    public static void setPageLength(int Length,int pageIndex,String fileName){

    }
}
