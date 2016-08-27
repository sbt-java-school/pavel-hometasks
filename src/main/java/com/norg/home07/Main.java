package com.norg.home07;

import com.norg.home07.cache.CachedInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Homework demo
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Calculator cachedCalc = getCachedCalc();

        long start = System.currentTimeMillis();
        System.out.println(cachedCalc.longCalculation(5));
        System.out.println(System.currentTimeMillis()-start + " ms"); //60-80 ms
        start = System.currentTimeMillis();
        System.out.println(cachedCalc.longCalculation(9));
        System.out.println(System.currentTimeMillis()-start + " ms"); //35-40 ms
        start = System.currentTimeMillis();
        System.out.println(cachedCalc.longCalculation(5));
        System.out.println(System.currentTimeMillis()-start + " ms"); //0-1 ms
    }

    private static Calculator getCachedCalc() throws InstantiationException, IllegalAccessException {
        return (Calculator) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class<?>[] {Calculator.class}, new CachedInvocationHandler(new CalculatorImpl()));
    }
}
