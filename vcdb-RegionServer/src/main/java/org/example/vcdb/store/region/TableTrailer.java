package org.example.vcdb.store.region;

import org.example.vcdb.util.Bytes;


public class TableTrailer {
    private byte[] data;

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public TableTrailer(long timestamp,String regionMetaName){
        this.data=new byte[8+4+regionMetaName.getBytes().length];
        int pos=0;
        pos= Bytes.putLong(this.data,pos,timestamp);
        pos=Bytes.putInt(this.data,pos,regionMetaName.getBytes().length);
        pos = Bytes.putBytes(this.data, pos, regionMetaName.getBytes(), 0, regionMetaName.getBytes().length);
    }

    public TableTrailer(byte[] data) {
        this.data = data;
    }

    public long getTimestamp(){
        return Bytes.toLong(this.data,0,8);
    }

    public void setTimeStamp(long timestamp){
        Bytes.putLong(this.data,0,timestamp);
    }

    public String getRegionMetaName(){
        int regionMetaNameLength=Bytes.toInt(this.data,8,4);
        return Bytes.toString(this.data,12,regionMetaNameLength);
    }
}
