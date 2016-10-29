package com.norg.home20;

import com.norg.home20.abstractions.ConverterFrom;
import com.norg.home20.abstractions.ConverterTo;

import java.util.HashMap;
import java.util.Map;

/**
 * Готовая рализация ConverterTo. "Просто добавь тип!"
 */
public class ConverterToImpl<T> implements ConverterTo<T> {
    private Map<Class, ConverterFrom<T>> converters = new HashMap<>();

    @Override
    public T convertTo(Object value, Class<T> resultClass) {
        ConverterFrom<T> converterFrom = converters.get(value.getClass());
        if (converterFrom == null) {
            throw new RuntimeException("Cannot find converter from type " + value.getClass().getName());
        }
        return converterFrom.convert(value);
    }

    @Override
    public void addConverter(Class sourceClass, ConverterFrom<T> converterFrom) {
        converters.put(sourceClass, converterFrom);
    }
}
