package com.norg.home20.detailedconverters;

import com.norg.home20.abstractions.ConverterFrom;

/**
 * Конкретный конвертер, делающий всю работу.
 */
public class ConverterFromBooleanToInt implements ConverterFrom<Integer> {
    @Override
    public Integer convert(Object fromObject) {
        return ((Boolean) fromObject) ? 1 : 0;
    }
}
