package com.norg.home02.shuffleusage.cards;

/**
 * Created by pavel.krizhanovskiy on 12.08.2016.
 */
public enum Mast {
    CHERVY, BUBNY, TREFY, PIKI;

    @Override
    public String toString() {
        switch (this) {
            case CHERVY:
                return "\u2662";
            case BUBNY:
                return "\u2663";
            case PIKI:
                return "\u2660";
            case TREFY:
                return "\u2661";
        }
        return null;
    }
}
