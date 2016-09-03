package com.norg.home06.task02;

import com.norg.representer.Representable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import static com.norg.home06.ClassUtils.getGetters;
import static com.norg.home06.ClassUtils.getMethodArgs;

/**
 * Вывести	все	геттеры	класса
 */
public class Main implements Representable {

    public static void main(String[] args) throws Exception {
        printGetters("com.norg.home02.shuffleusage.cards.Card");
    }

    public static void printGetters(String className) throws Exception {
        List<Method> getters = getGetters(className);

        for (Method method : getters) {
            System.out.println(method.getName()+getMethodArgs(method));
        }
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("### 6.2 Вывести все геттеры класса. Например, com.norg.home02.shuffleusage.cards.Card\n");
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        main(null);
        System.setOut(stdOut);
        writer.flush();
        writer.write("\n\n");
    }
}
