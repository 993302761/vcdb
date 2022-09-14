package org.example.vcdb.store.wal;
import org.example.vcdb.store.mem.KV;


import java.util.ArrayList;

//A collection of updates in a transaction
public class WalEdit {
    public ArrayList<KV.ValueNode> actions;
    public WalEdit(){
        actions=new ArrayList<org.example.vcdb.store.mem.KV.ValueNode>();
    }
    /*落盘操作*/
    public void syncLog(){}
}
