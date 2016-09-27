package com.norg.home16;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/**
 * Парикмахер
 */
public class Hairdresser implements Runnable {
    private final BlockingQueue<Client> clients;
    private volatile Client currentClient = null;

    public Hairdresser() {
        this.clients = new ArrayBlockingQueue<>(5);
    }

    @Override
    public void run() {
        while (Thread.currentThread().isInterrupted()) {
            try {
                //пойти посмотреть, есть ли клиенты. Требуется ненулевое случайное время
                sleep(getMovingTime());
                //если никого нет...
                if (clients.isEmpty()) {
                    //...то пойти в кресло (требуется время) и спать, пока не придет и не разбудит клиент
                    sleep(getMovingTime());
                    //когда его разбудит клиент, он установит ему currentClient. Защитимся от ложных просыпаний
                    while (currentClient == null) {
                        synchronized (this) {
                            wait();
                        }
                    }
                    //пришел клиент и разбудил, стричь его случайное время
                    cutHair();
                } else {
                    //взять следующего из очереди
                    currentClient = clients.poll();
                    //он ждал в очереди, надо разбудить
                    currentClient.notify();
                    //и подстричь
                    cutHair();
                }
            } catch (InterruptedException ignored) {
//                ignored.printStackTrace();
            }
        }
    }

    private void cutHair() throws InterruptedException {
        Objects.requireNonNull(currentClient);
        sleep(getWorkingTime());
        //подстригли клиента, выгнать его
        currentClient.finished = true;
        currentClient.notify();
        currentClient = null;
    }

    private int getMovingTime() {
        return new Random().nextInt(300) + 100;
    }

    private int getWorkingTime() {
        return new Random().nextInt(1300) + 700;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }
}
