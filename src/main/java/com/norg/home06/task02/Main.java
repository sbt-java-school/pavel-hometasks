package com.norg.home06.task02;

import java.lang.reflect.Method;
import java.util.List;

import static com.norg.home06.ClassUtils.getGetters;
import static com.norg.home06.ClassUtils.getMethodArgs;

/**
 * Вывести	все	геттеры	класса
 */
public class Main {

    public static void main(String[] args) throws Exception {
        printGetters("com.norg.home02.shuffleusage.cards.Card");
    }

    public static void printGetters(String className) throws Exception {
        List<Method> getters = getGetters(className);

        for (Method method : getters) {
            System.out.println(method.getName()+getMethodArgs(method));
        }
    }
}
