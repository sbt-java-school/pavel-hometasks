package com.norg.home16;

/**
 * Клиент парикмахера
 */
public class Client implements Runnable {
    // TODO: 12.10.2016 добавить логгер
    private final Hairdresser hairdresser;
    public final String name;

    protected Client(Hairdresser hairdresser, String name) {
        this.hairdresser = hairdresser;
        this.name = name;
    }

    @Override
    public void run() {
        //Если парикмахер спит, разбудить и подстричься
        System.out.println("Пришел " + name);
        if (hairdresser.isSleeping()) {
            System.out.println(name + " sees hairdresser is sleeping");
            synchronized (hairdresser) {
                hairdresser.setCurrentClient(this);
                hairdresser.notify();
            }
            beHairDressed();
        } else {
            //сесть в очередь и ждать
            System.out.println(name + " sees hairdresser is not sleeping, go wait");
            hairdresser.addToQueue(this);
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException ignored) {
//                    ignored.printStackTrace();
                }
            }
            beHairDressed();
        }
        //стрижка закончена, ушел
    }

    private void beHairDressed() {
        System.out.println(name + " is being hairdressed");
        synchronized (this) {
            try {
                //ждать, пока парикмахер закончит
                wait();
            } catch (InterruptedException ignored) {
//                ignored.printStackTrace();
            }
        }
    }

}
