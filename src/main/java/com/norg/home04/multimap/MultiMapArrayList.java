package com.norg.home04.multimap;

import java.util.*;

/**
 * Created by Norg on 17.08.2016.
 */
public class MultiMapArrayList<K, V> implements MultiMap<K, V>{
    private Map<K, Collection<V>> innerMap;

    @Override
    public Collection<V> get(K key) {
        return innerMap.get(key);
    }

    @Override
    public void put(K key, V value) {
        Collection<V> innerList = innerMap.get(key);
        if (innerList == null) {
            innerList = new ArrayList<>();
            innerMap.put(key, innerList);
        }
        innerList.add(value);
    }

    public MultiMapArrayList() {
        innerMap = new HashMap<>();
    }
}
