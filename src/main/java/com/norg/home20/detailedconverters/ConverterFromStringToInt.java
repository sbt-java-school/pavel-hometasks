package com.norg.home20.detailedconverters;

import com.norg.home20.abstractions.ConverterFrom;

/**
 * Конкретный конвертер, делающий всю работу.
 */
public class ConverterFromStringToInt implements ConverterFrom<Integer> {
    @Override
    public Integer convert(Object fromObject) {
        String tmp = ((String) fromObject).replaceAll("[^0-9]", "");
        return Integer.parseInt(tmp);
    }
}
