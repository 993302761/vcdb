package org.example.vcdb.store.file;


import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.RegionServerMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VCFileReader {
    /*vcFileMeta*/
    private List<Path> files = new ArrayList<Path>();
    public static byte[] readAll(String fileName){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/x2/vcdb/" + fileName, "rw");
            FileChannel fileChannel = aFile.getChannel();
            long size=aFile.length();
            //判断一下size是否Over int.max
            ByteBuffer buf = ByteBuffer.allocateDirect((int) size);
            int bytesRead = fileChannel.read(buf);
            buf.flip();
            return conVer(buf);
        }catch (IOException e) {
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
        return null;
    }
    //必须调用完后flip()才可以调用此方法
    public static byte[] conVer(ByteBuffer byteBuffer){
        int len = byteBuffer.limit() - byteBuffer.position();
        byte[] bytes = new byte[len];

        if(byteBuffer.isReadOnly()){
            return null;
        }else {
            byteBuffer.get(bytes);
        }
        return bytes;
    }
    public static byte[] openFileStorePage(int pageIndex,String fileName){
        return null;
    }

}
