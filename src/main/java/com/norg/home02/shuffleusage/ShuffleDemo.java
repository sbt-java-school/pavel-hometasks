package com.norg.home02.shuffleusage;

import com.norg.home02.shuffleusage.cards.Deck;

import java.util.Collections;

/**
 * Created by pavel.krizhanovskiy on 12.08.2016.
 */
public class ShuffleDemo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        deck.sort();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
