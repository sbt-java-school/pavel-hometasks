package com.norg.home06.task02;

import java.lang.reflect.Method;
import static com.norg.home06.ClassUtils.getMethodArgs;

/**
 * Вывести	все	геттеры	класса
 */
public class Main {

    public static void main(String[] args) throws Exception {
        printGetters("com.norg.home02.shuffleusage.cards.Card");
    }

    public static void printGetters(String className) throws Exception {
        Class clazz = Class.forName(className);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                System.out.println(method.getName()+getMethodArgs(method));
            }
        }
    }
}
