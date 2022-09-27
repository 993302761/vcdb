package org.example.vcdb.store.region.Region;


import org.example.vcdb.store.region.fileStore.FileStoreMeta;
import org.example.vcdb.util.Bytes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RegionMeta
 * @Description TODO
 * @Author lqc
 * @Date 2022/8/13 下午1:43
 * @Version 1.0
 */
/*
* PD提取的类，保存的是整个Region Server的元数据*/
//单独存起来
/*metaName-------------cfName.keyRange(startKey,endKey)----------fileStoreMetaNames*/
public class RegionMeta {
//    String regionMetaName;//文件名字
//    /*fileCount,metaName,fileMap,rangeMap*/
//    Map<KeyRange,String> fileStoreMap;
    byte[] metaByte;

    public RegionMeta(String metaName,Map<KeyRange,String> fileStoreMap){
        metaByte=new byte[1024*4];
        int pos=0;
        pos= Bytes.putInt(this.metaByte,pos,metaName.getBytes().length);
        pos = Bytes.putBytes(this.metaByte, pos, metaName.getBytes(), 0,metaName.getBytes().length);
        pos=Bytes.putInt(this.metaByte,pos,fileStoreMap.size());
        for (Map.Entry<KeyRange,String> entry : fileStoreMap.entrySet()) {
            pos=Bytes.putInt(this.metaByte,pos,entry.getKey().getData().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getKey().getData(), 0, entry.getKey().getData().length);
            pos=Bytes.putInt(this.metaByte,pos,entry.getValue().getBytes().length);
            pos = Bytes.putBytes(this.metaByte, pos, entry.getValue().getBytes(), 0, entry.getValue().getBytes().length);
        }
    }

    public int getNameLength(){
        return Bytes.toInt(this.metaByte,0,4);
    }
    public String getName(){
        return Bytes.toString(this.metaByte,4,getNameLength());
    }
    public int getMapCount(){
        return Bytes.toInt(this.metaByte,4+getNameLength(),4);
    }
    public Map<KeyRange,String> getFileStoreMap(){
        Map<KeyRange,String> map=new ConcurrentHashMap<>();
        int pos=8+getNameLength();
        for (int i = 0; i < getMapCount(); i++) {
            int keyLength=Bytes.toInt(this.metaByte,pos,4);
            pos+=4;
            KeyRange keyRange=new KeyRange(Bytes.subByte(this.metaByte,pos,keyLength));
            pos=pos+keyLength;
            int valueLength=Bytes.toInt(this.metaByte,pos,4);
            pos+=4;
            String regionMetaName=Bytes.toString(this.metaByte,pos,valueLength);
            pos+=valueLength;
            map.put(keyRange,regionMetaName);
        }
        return map;
    }

    public void dis(){
        System.out.println(getNameLength());
        System.out.println(getName());
        System.out.println(getMapCount());
        System.out.println(getFileStoreMap());
    }
    /*startKey+EndKey*/
    public FileStoreMeta getFileStoreMeta(String s) {
        return null;
    }

}