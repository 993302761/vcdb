package org.example.vcdb.store.region.Region;


import org.example.vcdb.util.Bytes;

import java.util.Map;

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
        }
    }
}