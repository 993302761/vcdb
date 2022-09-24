package org.example.vcdb.store.file;


import org.example.vcdb.store.region.Region.RegionMeta;
import org.example.vcdb.store.region.RegionServerMeta;
import org.example.vcdb.store.region.fileStore.FileStore;
import org.example.vcdb.store.region.fileStore.FileStoreMeta;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VCFileReader {
    /*vcFileMeta*/
    private List<Path> files = new ArrayList<Path>();
    public static RegionServerMeta openRegionServerMeta(String fileName){
        return null;
    }
    public static RegionMeta openRegionMeta(String fileName){
        return null;
    }
    public static FileStoreMeta openFileStoreMeta(String fileName){
        return null;
    }
    public static FileStore openFileStore(String fileName){
        return null;
    }
    public static byte[] openFileStorePage(int pageIndex,String fileName){
        return null;
    }

}
