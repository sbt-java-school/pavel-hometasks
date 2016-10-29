package com.norg.home20;


import com.norg.home20.abstractions.Converter;
import com.norg.home20.abstractions.ConverterTo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ConverterImpl implements Converter {
    private Map<Class, ConverterTo> converters = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> T convert(Object valueFrom, Class<T> resultClass) {
        ConverterTo<T> converterTo = converters.get(resultClass);
        return converterTo.convertTo(valueFrom, resultClass);
    }

    @Override
    public <T> void addConverterTo(Class<T> clazz, ConverterTo converterTo) {
        converters.put(clazz, converterTo);
    }

}
