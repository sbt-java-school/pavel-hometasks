package com.norg.home16;

/**
 * Created by Norg on 12.10.2016.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Hairdresser hairdresser = new Hairdresser();
        new Thread(hairdresser).start();
        new Thread(new Client(hairdresser, "Client1")).start();
        new Thread(new Client(hairdresser, "Client2")).start();
        Thread.sleep(6000);
        new Thread(new Client(hairdresser, "Client3")).start();
        new Thread(new Client(hairdresser, "Client4")).start();
        new Thread(new Client(hairdresser, "Client5")).start();

    }
}
