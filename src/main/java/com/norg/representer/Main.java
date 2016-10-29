package com.norg.representer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Автоматическое обновление ридми-файла
 */
public class Main implements Representable {
    public static final String README_MD = "README.md";
    private static List<Representable> homeWorks = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        updateReadme(true);
    }

    public static void updateReadme(boolean append) throws Exception {
        homeWorks.add(new Main());
        homeWorks.add(new com.norg.home01.Main());
        homeWorks.add(new com.norg.home02.listspeed.SpeedTest());
        homeWorks.add(new com.norg.home02.shuffleusage.ShuffleDemo());
        homeWorks.add(new com.norg.home04.Application());
        homeWorks.add(new com.norg.home05.Main());
        homeWorks.add(new com.norg.home06.task01.Main());
        homeWorks.add(new com.norg.home06.task02.Main());
        homeWorks.add(new com.norg.home07.Main());
        homeWorks.add(new com.norg.home10.serializationproxy.Main());
        FileOutputStream readMeOutputStream = new FileOutputStream(README_MD, append);
        for (Representable homeWork : homeWorks) {
            //Добавление ридми в каждую домашку
            String localReadmePath = "src/main/java/" + homeWork.getClass().getPackage().getName().replaceAll("\\.", "/") + "/" + README_MD;
            System.out.println("Processing task " + homeWork.getClass().getName());
            try (FileOutputStream localReadMeOutputStream = new FileOutputStream(localReadmePath);) {
                homeWork.represent(localReadMeOutputStream);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //Добавление глобального ридми
//            homeWork.represent(readMeOutputStream);
        }
        readMeOutputStream.close();
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
