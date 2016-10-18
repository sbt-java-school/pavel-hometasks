package com.norg.home20.detailedconverters;

import com.norg.home20.abstractions.ConverterFrom;

/**
 * Конвертер из эксепшена. Фан :)
 */
public class ConverterFromExceptionToString implements ConverterFrom<String> {
    @Override
    public String convert(Object fromObject) {
        return ((Exception) fromObject).getMessage();
    }
}
