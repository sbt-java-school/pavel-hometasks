package com.norg.home02.shuffleusage;

import com.norg.home02.shuffleusage.cards.Deck;
import com.norg.representer.Representable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/**
 * Created by pavel.krizhanovskiy on 12.08.2016.
 */
public class ShuffleDemo implements Representable{
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Создана коллекция:");
        System.out.println(deck);
        deck.sort();
        System.out.println("Сортировка по старшинству (по умолчанию, для использования в игре, сравнение 2 карт происходит по старшинству без учета масти)");
        System.out.println(deck);
        deck.shuffle();
        System.out.println("Перемешивание с помощью Shuffle():");
        System.out.println(deck);
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("### 2.2 Демо реализации Comparable(), Collections.sort() и Collections.shuffle()\n");
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        main(null);
        System.setOut(stdOut);
        writer.flush();
    }
}
