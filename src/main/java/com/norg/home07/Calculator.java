package com.norg.home07;

import com.norg.home07.cache.Cache;

/**
 * Created by Norg on 27.08.2016.
 */
public interface Calculator {

    @Cache
    double longCalculation(int key);
}
