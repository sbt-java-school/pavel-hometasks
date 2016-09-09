package com.norg.home07;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Тесты кэширующего прокси
 */
public class CachedProxyTest {
    public static Calculator cachedCalculator;

    @BeforeClass
    public static void getCalcBeforeClass() throws IllegalAccessException, InstantiationException {
        cachedCalculator = Main.getCachedCalc();
    }

    @Before
    public void callToCacheBefore() {
        cachedCalculator.longCalculation(6);
    }

    @Test
    public void notCachedCallTest() throws Exception {
        cachedCalculator = Main.getCachedCalc();

        long start = System.currentTimeMillis();
        cachedCalculator.longCalculation(5);
        System.out.println("cachedCalculator.longCalculation(5)  ");
        System.out.println(System.currentTimeMillis()-start + " ms  "); //60-80 ms
        start = System.currentTimeMillis();
        cachedCalculator.longCalculation(9);
        System.out.println("cachedCalculator.longCalculation(9)  ");
        System.out.println(System.currentTimeMillis()-start + " ms  "); //35-40 ms
    }

    @Test(timeout = 2)
    public void cachedCallTest() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("cachedCalculator.longCalculation(6) // cached value  ");
        cachedCalculator.longCalculation(6);
        System.out.println(System.currentTimeMillis()-start + " ms  "); //0-1 ms
    }
}
