package com.norg.home20.abstractions;

/**
 * Конвертер из какого-то типа в какой-то тип. Именно он "знает" правила конвертации.
 */
public interface ConverterFrom<T> {
    T convert(Object fromObject);
}
