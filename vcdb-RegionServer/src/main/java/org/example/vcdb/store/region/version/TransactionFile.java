package org.example.vcdb.store.region.version;

import org.example.vcdb.util.Bytes;

import java.util.ArrayList;
import java.util.List;

public class TransactionFile {
    byte[] data;
    public TransactionFile(List<Transaction> transactions){
        this.data=new byte[1024*4];
        int pos=0;
        int count=transactions.size();
        pos= Bytes.putInt(this.data,pos,count);
        for (Transaction transaction:transactions){
            pos = Bytes.putInt(this.data,pos,transaction.getData().length);
            pos = Bytes.putBytes(this.data, pos, transaction.getData(), 0,transaction.getData().length);
        }
    }

    public TransactionFile(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public List<Transaction> getTransactions(){
        List<Transaction> transactions=new ArrayList<>();
        int pos=0;
        int count=Bytes.toInt(this.data,pos,4);
        pos+=4;
        for (int i = 0; i < count; i++) {
            int transactionLength=Bytes.toInt(this.data,pos,4);
            pos+=4;
            transactions.add(new Transaction(Bytes.subByte(this.data,pos,transactionLength)));
            pos+=transactionLength;
        }
        return transactions;
    }


    public void setTransactions(List<Transaction> transactions) {
        int pos=0;
        int count=Bytes.toInt(this.data,pos,4);
        pos= Bytes.putInt(this.data,pos,count);
        for (Transaction transaction:transactions){
            pos = Bytes.putInt(this.data,pos,transaction.getData().length);
            pos = Bytes.putBytes(this.data, pos, transaction.getData(), 0,transaction.getData().length);
        }
    }
}
