package com.norg.home06.task01;

import com.norg.representer.Representable;

import java.io.*;
import java.lang.reflect.Method;

import static com.norg.home06.ClassUtils.getMethodArgs;

/**
 * Вывести	на	консоль	все	методы	класса,	включая	все	родительские	методы
 *(включая	приватные)
 */
public class Main implements Representable {
    public static void main(String[] args) throws Exception {
        printAllMethods("java.io.BufferedReader");
    }

    public static void printAllMethods(String className) throws Exception {
        Class clazz = Class.forName(className);
        StringBuilder tabs = new StringBuilder();
        while(clazz != null) {
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods) {
                System.out.println(tabs.toString() + method.getName() + getMethodArgs(method));
            }
            clazz = clazz.getSuperclass();
            tabs.append("* ");
        }
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 06\n");
        writer.write("### 6.1 Вывести на консоль все методы класса, включая все родительские методы, (включая приватные). Например, java.io.BufferedReader\n");
        writer.flush();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        main(null);
        System.setOut(stdOut);
        writer.write("\n\n");
        writer.flush();
    }
}
