package com.norg.home20.abstractions;

/**
 * Конвертер в заданный тип. Внутри должен содержать коллекцию из ConverterFrom, сам ничего не делает.
 */
public interface ConverterTo<T>  {
    T convertTo(Object value, Class<T> resultClass);
    void addConverter(Class sourceClass, ConverterFrom<T> converterFrom);
}
