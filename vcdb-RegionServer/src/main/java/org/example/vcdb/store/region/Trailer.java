package org.example.vcdb.store.region;

/**
 * @ClassName Trailer
 * @Description TODO
 * @Author lqc
 * @Date 2022/9/6 下午5:32
 * @Version 1.0
 */

/*
 * Trailer (offset of other member)(根据offset,可以拿到整个region的大小)包含RegionMeta (类）
 * pageCount
 * CF_Meta      这个列族的元数据，包括列族的限制（ColumnFamilyCell）
 * pageTrailer(KVRange(startKey,endKey))得固定
 * DataSet   (不分，一直往后累加，不用打乱排序）
 * */
public class Trailer {

    private int regionInfoIndex;
    private int pageTrailerIndex;
    private int dataSetIndex;

    public Trailer( int regionInfoIndex, int pageTrailerIndex, int dataSetIndex) {

        this.regionInfoIndex = regionInfoIndex;
        this.pageTrailerIndex = pageTrailerIndex;
        this.dataSetIndex = dataSetIndex;
    }


    public int getRegionInfoIndex() {
        return regionInfoIndex;
    }

    public int getPageTrailerIndex() {
        return pageTrailerIndex;
    }

    public int getDataSetIndex() {
        return dataSetIndex;
    }


    public void setRegionInfoIndex(int regionInfoIndex) {
        this.regionInfoIndex = regionInfoIndex;
    }

    public void setPageTrailerIndex(int pageTrailerIndex) {
        this.pageTrailerIndex = pageTrailerIndex;
    }

    public void setDataSetIndex(int dataSetIndex) {
        this.dataSetIndex = dataSetIndex;
    }
}
