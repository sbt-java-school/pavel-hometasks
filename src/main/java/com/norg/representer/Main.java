package com.norg.representer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Автоматическое обновление ридми-файла
 */
public class Main {
    private static List<Representable> homeworks;

    public static void main(String[] args) throws Exception {
        homeworks = new ArrayList<>();
        updateReadme();
    }

    public static void updateReadme() throws Exception {
        homeworks = new ArrayList<>();
        homeworks.add(new com.norg.home01.Main());
        homeworks.add(new com.norg.home02.listspeed.SpeedTest());
        homeworks.add(new com.norg.home02.shuffleusage.ShuffleDemo());
        homeworks.add(new com.norg.home04.Application());
        homeworks.add(new com.norg.home05.Main());
        homeworks.add(new com.norg.home06.task01.Main());
        homeworks.add(new com.norg.home06.task02.Main());
        homeworks.add(new com.norg.home07.Main());
        FileOutputStream readMeOutputStream = new FileOutputStream("README.md");
        for (Representable homeWork : homeworks) {
            System.out.println("Processing task " + homeWork.getClass().getName());
            homeWork.represent(readMeOutputStream);
        }
    }

    public static void addToReadme() throws Exception {
        FileOutputStream readMeOutputStream = new FileOutputStream("README.md");
        for (Representable homeWork : homeworks) {
            System.out.println("Processing task " + homeWork.getClass().getName());
            homeWork.represent(readMeOutputStream);
        }
    }
}
