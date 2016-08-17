package com.norg.home04.multimap;

import java.util.List;

/**
 * Created by Norg on 17.08.2016.
 */
public interface MultiMap<K, V> {
    List<V> get(K key);
    void put(K key, V value);
}
