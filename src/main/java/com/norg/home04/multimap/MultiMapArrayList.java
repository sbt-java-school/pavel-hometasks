package com.norg.home04.multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Norg on 17.08.2016.
 */
public class MultiMapArrayList<K, V> implements MultiMap<K, V>{
    private Map<K, List<V>> innerMap;

    @Override
    public List<V> get(K key) {
        return innerMap.get(key);
    }

    @Override
    public void put(K key, V value) {
        List<V> innerList = innerMap.get(key);
        if (innerList == null) {
            innerList = new ArrayList<V>();
        }
        innerList.add(value);
    }

    public MultiMapArrayList() {
        innerMap = new HashMap<K, List<V>>();
    }
}
