package com.norg.home07;

/**
 * Usual calculator implementation
 */
public class CalculatorImpl implements Calculator {

    @Override
    public double longCalculation(int key) {
        for(long k=0; k < 40_000_000; k++) {
            new Float(k);
        }
        return Math.pow(2, key);
    }
}
