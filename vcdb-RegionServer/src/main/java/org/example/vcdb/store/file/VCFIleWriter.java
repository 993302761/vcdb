package org.example.vcdb.store.file;


import org.example.vcdb.util.Bytes;

import java.io.File;
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
    public static void deleteAll(String fileName){
        File file = new File("/x2/vcdb/"+fileName);
        if(file.delete()){
            System.out.println(file.getName() + " 文件已被删除！");
        }else{
            System.out.println("文件删除失败！");
        }
    }

    public static void writeAll(byte[] content, String fileName){

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
    public static void writeAll(byte[] content,int offset, String fileName){
        RandomAccessFile accessFile = null;
        try {
            //getFromMap
            accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer contentBuf = ByteBuffer.allocateDirect(content.length);
            contentBuf.put(content);
            contentBuf.limit(content.length);
            contentBuf.flip();
            while (contentBuf.hasRemaining()) fileChannel.write(contentBuf,offset);
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

    public static void setFileStorePage(byte[] content,int pageIndex,String fileName){
        if(content.length!=4*1024){
            System.out.println("这不是一个页");
        }else {
            RandomAccessFile accessFile = null;
            try {
                //getFromMap
                accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
                FileChannel fileChannel = accessFile.getChannel();
                ByteBuffer contentBuf = ByteBuffer.allocateDirect(content.length);
                contentBuf.put(content);
                contentBuf.limit(content.length);
                contentBuf.flip();
                while (contentBuf.hasRemaining()) fileChannel.write(contentBuf,pageIndex*4*1024);
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
    }

    //只有当页内空间够的时候，才可以调用这些方法
    public static void appendDataSetToFileStorePage(int pageLength,byte[] kvs,int pageIndex,int count,String fileName){
        RandomAccessFile accessFile = null;
        try {

            updateKvsCountFOrFileStorePage(count,pageIndex,fileName);
            //getFromMap
            accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer contentBuf = ByteBuffer.allocateDirect(kvs.length);
            contentBuf.put(kvs);
            contentBuf.limit(kvs.length);
            contentBuf.flip();
            while (contentBuf.hasRemaining()) fileChannel.write(contentBuf,pageIndex*4*1024+pageLength);
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

    public static void  initFileStorePage(int pageLength,byte[] kvs,int pageIndex,int count,String fileName){
        RandomAccessFile accessFile = null;
        try {

            updateKvsCountFOrFileStorePage(count,pageIndex,fileName);
            //getFromMap
            accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer contentBuf = ByteBuffer.allocateDirect(kvs.length);
            byte[] bytes=new byte[kvs.length+4];
            Bytes.putInt(bytes,0,kvs.length);
            Bytes.putBytes(bytes,0,kvs,0,kvs.length);
            contentBuf.put(bytes);
            contentBuf.limit(kvs.length);
            contentBuf.flip();
            while (contentBuf.hasRemaining()) fileChannel.write(contentBuf,pageIndex*4*1024+pageLength);
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

    //只有当页内空间够的时候，才可以调用这些方法
    public static void updateKvsCountFOrFileStorePage(int count,int pageIndex,String fileName){
        RandomAccessFile accessFile = null;
        try {
            //getFromMap
            accessFile = new RandomAccessFile("/x2/vcdb/"+fileName, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer contentBuf = ByteBuffer.allocateDirect(4);
            int newCount=VCFileReader.ReadKvsCountForPage(pageIndex,fileName)+ count;
            contentBuf.put(Bytes.toBytes(newCount));
            contentBuf.limit(4);
            contentBuf.flip();
            while (contentBuf.hasRemaining()) fileChannel.write(contentBuf,pageIndex*4*1024);
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

}


