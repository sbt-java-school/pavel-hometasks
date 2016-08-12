package com.norg.home01;

/**
 * Created by Norg on 11.08.2016.
 */
public class Truck {
    private int w;
    private int curTotal;
    private int curCount;

    public Truck(int w) {
        this.w = w;
    }

    public boolean put(int a) {
        if (curTotal + a < w) {
            curTotal += a;
            curCount++;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Count: " + curCount + "\nTotal: " + curTotal;
    }
}
