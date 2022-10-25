package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

/**
 * @ClassName Transaction
 * @Description TODO
 * @Author lqc
 * @Date 2022/10/20 下午6:09
 * @Version 1.0
 */

public class Transaction {
    byte[] data;

    public byte[] getData() {
        return data;
    }

    public Transaction(long startTime, long endTime, String explainValue){
        data=new byte[8+8+explainValue.getBytes().length];
        int pos=0;
        pos= Bytes.putLong(this.data,pos,startTime);

        pos= Bytes.putLong(this.data,pos,endTime);

        pos= Bytes.putInt(this.data,pos,explainValue.getBytes().length);
        pos=Bytes.putBytes(this.data,pos,explainValue.getBytes(),0,explainValue.getBytes().length);

    }

    public Transaction(byte[] data) {
        this.data = data;
    }

    public void setEndTime(long endTime) {
        Bytes.putLong(this.data,8,endTime);
    }

    public long getStartTime(){
        return Bytes.toLong(this.data,0,8);
    }

    public long getEndTime(){
        return Bytes.toLong(this.data,8,8);
    }

    public String getExplainValue(){
        int explainValueLength=Bytes.toInt(this.data,16,4);
        return Bytes.toString(this.data,20,explainValueLength);
    }

    public String toString(){
        return getStartTime()+"\t"+getEndTime()+"\t"+getExplainValue()+"\n";
    }
}
