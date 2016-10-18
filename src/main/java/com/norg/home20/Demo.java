package com.norg.home20;

import com.norg.home20.abstractions.*;
import com.norg.home20.detailedconverters.*;

/**
 * Демо конвертеров
 */
public class Demo {
    public static void main(String[] args) {
        Converter converter = new ConverterImpl();

        ConverterTo<Integer> toInt = new ConverterToImpl<>();
        toInt.addConverter(String.class, new ConverterFromStringToInt());
        toInt.addConverter(Boolean.class, new ConverterFromBooleanToInt());
        converter.addConverterTo(Integer.class, toInt);

        ConverterTo<String> toString = new ConverterToImpl<>();
        toString.addConverter(Exception.class, new ConverterFromExceptionToString());
        toString.addConverter(Boolean.class, new ConverterFromBooleanToString());
        converter.addConverterTo(String.class, toString);

        System.out.println(converter.convert("2sg42vdd k )9", Integer.class));
        System.out.println(converter.convert(true, Integer.class));
        System.out.println(converter.convert(true, String.class));
        System.out.println(converter.convert(new Exception("Test exception"), String.class));
    }
}
