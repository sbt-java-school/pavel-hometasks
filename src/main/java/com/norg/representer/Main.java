package com.norg.representer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Автоматическое обновление ридми-файла
 */
public class Main implements Representable {
    public static final String README_MD = "README.md";
    private static List<Representable> homeworks;

    public static void main(String[] args) throws Exception {
        homeworks = new ArrayList<>();
        updateReadme(true);
    }

    public static void updateReadme(boolean append) throws Exception {
//        homeworks.add(new Main());
//        homeworks.add(new com.norg.home01.Main());
//        homeworks.add(new com.norg.home02.listspeed.SpeedTest());
//        homeworks.add(new com.norg.home02.shuffleusage.ShuffleDemo());
//        homeworks.add(new com.norg.home04.Application());
//        homeworks.add(new com.norg.home05.Main());
//        homeworks.add(new com.norg.home06.task01.Main());
//        homeworks.add(new com.norg.home06.task02.Main());
//        homeworks.add(new com.norg.home07.Main());
        homeworks.add(new com.norg.home10.serializationproxy.Main());
        FileOutputStream readMeOutputStream = new FileOutputStream(README_MD, append);
        for (Representable homeWork : homeworks) {
            System.out.println("Processing task " + homeWork.getClass().getName());
            homeWork.represent(readMeOutputStream);
        }
        try {
            readMeOutputStream.close();
        }catch (IOException e) {

        }
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Генератор файла README.md\n");
        writer.write("### Добавляет описания и вывод на экран из каждой домашки в этот файл.\n");
        writer.flush();
    }
}
