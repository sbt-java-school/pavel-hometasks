package com.norg.home18.gadalka;

/**
 * Игра нескольких клиентов с 1 сервером
 */
public class MultipleClients {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new GadalkaClient()).start();
            Thread.sleep(200);
        }
//        Thread.sleep(2000);
//        for (int i = 0; i < 5; i++) {
//            new Thread(new GadalkaClient()).start();
//        }
    }
}
