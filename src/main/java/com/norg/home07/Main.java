package com.norg.home07;

import com.norg.home07.cache.CachedInvocationHandler;
import com.norg.representer.Representable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Proxy;

/**
 * Homework demo
 */
public class Main implements Representable {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Calculator cachedCalc = getCachedCalc();

        long start = System.currentTimeMillis();
        System.out.println(cachedCalc.longCalculation(5));
        System.out.println("cachedCalc.longCalculation(5)  ");
        System.out.println(System.currentTimeMillis()-start + " ms  "); //60-80 ms
        start = System.currentTimeMillis();
        System.out.println(cachedCalc.longCalculation(9));
        System.out.println("cachedCalc.longCalculation(9)  ");
        System.out.println(System.currentTimeMillis()-start + " ms  "); //35-40 ms
        start = System.currentTimeMillis();
        System.out.println("cachedCalc.longCalculation(5) //cached value  ");
        System.out.println(cachedCalc.longCalculation(5));
        System.out.println(System.currentTimeMillis()-start + " ms  "); //0-1 ms
    }

    private static Calculator getCachedCalc() throws InstantiationException, IllegalAccessException {
        return (Calculator) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class<?>[] {Calculator.class}, new CachedInvocationHandler(new CalculatorImpl()));
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 07\n");
        writer.write("### Кэширующий прокси + аннотация @Cache\n");
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        main(null);
        System.setOut(stdOut);
        writer.flush();
        writer.write("\n\n");
    }
}
