package com.norg.home02.shuffleusage.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pavel.krizhanovskiy on 12.08.2016.
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        //создаем колоду
        for (int m = 0; m < 4; m++) { //масти
            for(int i=1; i<14; i++) { //номиналы
                cards.add(new Card(Mast.values()[m], i));
            }
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
