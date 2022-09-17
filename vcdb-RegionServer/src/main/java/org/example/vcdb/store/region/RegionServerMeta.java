package org.example.vcdb.store.region;

import java.util.HashMap;

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
public class RegionServerMeta {

    /*fileCount,pageCount,metaName,fileMap,rangMap*/
    byte[] MetaByte;
    /*key(db+table+rowKey+keyRange)---encodeNames(fileCount{(nameLength,name).....})*/
    /*encodeName---------------keyRange(startKey,endKey)*/
    String metaName;//文件名字
    HashMap<byte[],byte[]> fileMap=new HashMap<>();
    HashMap<byte[],byte[]> rangeMap=new HashMap<>();
}
