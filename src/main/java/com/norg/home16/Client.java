package com.norg.home16;

/**
 * Клиент парикмахера
 */
public class Client implements Runnable {
    private final Hairdresser hairdresser;
    public final String name;
    public volatile boolean finished;

    protected Client(Hairdresser hairdresser, String name) {
        this.hairdresser = hairdresser;
        this.name = name;
    }

    @Override
    public void run() {

        //парикмахер спит. Разбудить и подстричься
        synchronized (hairdresser) {
            hairdresser.setCurrentClient(this);
            hairdresser.notify();
            beHairDressed();
        }
        //стрижка закончена, ушел
    }

    private void beHairDressed() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ignored) {
//                ignored.printStackTrace();
            }
        }
    }

}
