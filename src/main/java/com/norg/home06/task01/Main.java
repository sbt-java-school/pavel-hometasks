package com.norg.home06.task01;

import java.io.BufferedReader;
import java.lang.reflect.Method;

import static com.norg.home06.ClassUtils.getMethodArgs;

/**
 * Вывести	на	консоль	все	методы	класса,	включая	все	родительские	методы
 *(включая	приватные)
 */
public class Main {
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
            tabs.append("  ");
        }
    }
}
