package com.norg.home20.detailedconverters;

import com.norg.home20.abstractions.ConverterFrom;

/**
 * Конкретный конвертер, делающий всю работу.
 */
public class ConverterFromBooleanToString implements ConverterFrom<String> {
    @Override
    public String convert(Object fromObject) {
        return ((Boolean) fromObject) ? "true" :"false";
    }
}
