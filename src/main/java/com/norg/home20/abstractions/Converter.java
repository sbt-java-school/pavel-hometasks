package com.norg.home20.abstractions;

/**
 * Интерфейс конвертера, который по своей сути является хранилищем ConvertTo объектов
 */
public interface Converter {
    <T> T convert(Object valueFrom, Class<T> resultClass);
    <T> void addConverterTo(Class<T> clazz, ConverterTo converterTo);
}
