package org.example.vcdb.store.region.Region;

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
/*metaName-------------cfName.keyRange(startKey,endKey)----------encodeNames(一般就一个fileCount{(nameLength,name).....})*/
public class RegionMeta {
    String regionMetaName;//文件名字
    /*fileCount,pageCount,metaName,fileMap,rangeMap*/
    byte[] MetaByte;
}