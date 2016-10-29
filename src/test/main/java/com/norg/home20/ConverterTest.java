package com.norg.home20;

import com.norg.home20.abstractions.Converter;
import com.norg.home20.abstractions.ConverterTo;
import com.norg.home20.detailedconverters.ConverterFromBooleanToInt;
import com.norg.home20.detailedconverters.ConverterFromBooleanToString;
import com.norg.home20.detailedconverters.ConverterFromExceptionToString;
import com.norg.home20.detailedconverters.ConverterFromStringToInt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Тесты конвертера
 */
public class ConverterTest {
    private Converter converter;

    @Before
    public void initConverter() {
        converter = new ConverterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void noConverterToException() {
        converter.convert("Any object", Object.class);
    }

    @Test(expected = RuntimeException.class)
    public void noConverterFromException() {
        ConverterToImpl<Object> toObject = new ConverterToImpl<>();
        converter.addConverterTo(Object.class, toObject);
        converter.convert("Any object", String.class);
    }

    @Test
    public void convert() {
        addConverters();

        String testString = "Test 1 exception 23 message 4";
        Object result = converter.convert(new Exception(testString), String.class);
        Assert.assertEquals(result, testString);

        result = converter.convert(testString, Integer.class);
        Assert.assertEquals(1234, result);

        result = converter.convert(true, Integer.class);
        Assert.assertEquals(1, result);
    }

    private void addConverters() {
        ConverterTo<String> toString = new ConverterToImpl<>();
        toString.addConverter(Boolean.class, new ConverterFromBooleanToString());
        toString.addConverter(Exception.class, new ConverterFromExceptionToString());
        converter.addConverterTo(String.class, toString);

        ConverterTo<Integer> toInt = new ConverterToImpl<>();
        toInt.addConverter(Boolean.class, new ConverterFromBooleanToInt());
        toInt.addConverter(String.class, new ConverterFromStringToInt());
        converter.addConverterTo(Integer.class, toInt);
    }
}
