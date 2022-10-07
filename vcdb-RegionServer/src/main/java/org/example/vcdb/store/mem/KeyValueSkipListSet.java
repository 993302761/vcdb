/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.vcdb.store.mem;

import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Predicate;


public class KeyValueSkipListSet implements NavigableSet<KV> {
    private final ConcurrentNavigableMap<KV, KV> concurrentNavigableMap;

    public KeyValueSkipListSet(final KV.KVComparator c) {
        this.concurrentNavigableMap = new ConcurrentSkipListMap(c);
    }

    KeyValueSkipListSet(final ConcurrentNavigableMap<KV, KV> m) {
        this.concurrentNavigableMap = m;
    }

    public SortedSet<KV> headSet(final KV toElement) {
        return headSet(toElement, false);
    }
    public void addKVs(KeyValueSkipListSet kvs){
        for (KV kv:kvs){
            add(kv);
        }
    }
    @Override
    public KV lower(KV kv) {
        return null;
    }

    @Override
    public KV floor(KV kv) {
        return null;
    }

    @Override
    public KV ceiling(KV kv) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public KV higher(KV kv) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public KV pollFirst() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public KV pollLast() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<KV> iterator() {
        return this.concurrentNavigableMap.values().iterator();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<KV> descendingIterator() {
        return this.concurrentNavigableMap.descendingMap().values().iterator();
    }

    @Override
    public NavigableSet<KV> descendingSet() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public NavigableSet<KV> subSet(KV fromElement, boolean fromInclusive, KV toElement, boolean toInclusive) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public NavigableSet<KV> headSet(final KV toElement,
                                    boolean inclusive) {
        return new KeyValueSkipListSet(this.concurrentNavigableMap.headMap(toElement, inclusive));
    }

    public SortedSet<KV> tailSet(KV fromElement) {
        return tailSet(fromElement, true);
    }

    public NavigableSet<KV> tailSet(KV fromElement, boolean inclusive) {
        return new KeyValueSkipListSet(this.concurrentNavigableMap.tailMap(fromElement, inclusive));
    }

    @Override
    public Comparator<? super KV> comparator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public SortedSet<KV> subSet(KV fromElement, KV toElement) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public KV first() {
        return this.concurrentNavigableMap.get(this.concurrentNavigableMap.firstKey());
    }

    public KV last() {
        return this.concurrentNavigableMap.get(this.concurrentNavigableMap.lastKey());
    }

    public boolean add(KV e) {
        return this.concurrentNavigableMap.put(e, e) == null;
    }

    public void clear() {
        this.concurrentNavigableMap.clear();
    }

    public boolean contains(Object o) {
        //noinspection SuspiciousMethodCalls
        return this.concurrentNavigableMap.containsKey(o);
    }

    public boolean isEmpty() {
        return this.concurrentNavigableMap.isEmpty();
    }

    public boolean remove(Object o) {
        return this.concurrentNavigableMap.remove(o) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean addAll(Collection<? extends KV> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean removeIf(Predicate<? super KV> filter) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public KV get(KV kv) {
        return this.concurrentNavigableMap.get(kv);
    }

    public KV get(String key) {
        for (KV kv:this){
            if (key.equals(kv.getRowKey())) {
                return kv;
            }
        }
        return null;
    }

    public int size() {
        return this.concurrentNavigableMap.size();
    }

    public int getByteSize() {
        int byteSize = 0;
        //获取key和value的set
        //把hashmap转成Iterator再迭代到entry
        for (Object entry : this) {
            byteSize += 4 + ((KV) entry).getLength();
        }
        return byteSize;
    }

}
