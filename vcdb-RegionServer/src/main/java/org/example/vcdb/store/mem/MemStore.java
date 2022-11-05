package org.example.vcdb.store.mem;

import java.util.concurrent.atomic.AtomicLong;

//对应的是一个表的一个列族的数据
public class MemStore {
    // Used to track when to flush
    long timeOfOldestEdit = Long.MAX_VALUE;
    //lock for memStore version
    public AtomicLong size;
    public byte type;
    //from juc
    public KeyValueSkipListSet kvSet;

//    // Snapshot of memStore.  Made for flusher.
//    volatile KeyValueSkipListSet snapshot;
    public MemStore(){
        size=new AtomicLong(0);
        kvSet =new KeyValueSkipListSet(new KV.KVComparator());
    }

    public byte getType() {
        return type;
    }

    public void add(final KV kv) {
        this.size.getAndIncrement();
        this.kvSet.add(kv);
    }

    public void remove(final KV kv){
        this.size.getAndDecrement();
        this.kvSet.remove(kv);
    }

    public KeyValueSkipListSet getKVSet(){
        return kvSet;
    }

    public void reSetTheMemStore(){
        timeOfOldestEdit = Long.MAX_VALUE;
    }

    public long getTimeOfOldestEdit() {
        return timeOfOldestEdit;
    }



    private boolean removeFromKVSet(KV e) {
        boolean b = this.kvSet.remove(e);
        setOldestEditTimeToNow();
        return b;
    }

    public void setOldestEditTimeToNow() {
        if (timeOfOldestEdit == Long.MAX_VALUE) {
            timeOfOldestEdit = System.currentTimeMillis();
        }
    }



//    /*
//     * Calculate how the MemStore size has changed.  Includes overhead of the
//     * backing Map.
//     * @param kv
//     * @param notPresent True if the kv was NOT present in the set.
//     * @return Size
//     */
//    private long heapSizeChange(final KV kv, final boolean notPresent) {
//        return notPresent ? align(kv) : 0;
//    }

//    //将kv对齐,8的整数
//    private long align(KV kv) {
//        return 8;
//    }
}
