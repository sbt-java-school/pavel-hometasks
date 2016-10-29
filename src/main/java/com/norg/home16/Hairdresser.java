package com.norg.home16;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Парикмахер
 */
public class Hairdresser implements Runnable {
    private final BlockingQueue<Client> clients;
    private volatile Client currentClient = null;
    private volatile boolean sleeping;

    public Hairdresser() {
        this.clients = new ArrayBlockingQueue<>(5);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                //пойти посмотреть, есть ли клиенты. Требуется ненулевое случайное время
                System.out.println("идем смотреть");
                sleep(getMovingTime());
                //если никого нет...
                if (clients.isEmpty()) {
                    System.out.println("никого нет, спим");
                    //...то пойти в кресло (требуется время) и спать, пока не придет и не разбудит клиент
                    sleep(getMovingTime());
                    //когда его разбудит клиент, он установит ему currentClient. Защитимся от ложных просыпаний
                    while (currentClient == null) {
                        synchronized (this) {
                            System.out.println("Hairdresser waits");
                            sleeping = true;
                            wait();
                            sleeping = false;
                            System.out.println("Hairdresser is awaken");
                        }
                    }
                    //пришел клиент и разбудил, стричь его случайное время
                    synchronized (this) {
                        cutHair();
                    }
                } else {
                    //взять следующего из очереди
                    synchronized (this) {
                        currentClient = clients.poll();
                        //он ждал в очереди, надо разбудить
                        synchronized (currentClient) {
                            currentClient.notify();
                        }
                        //и подстричь
                        cutHair();
                    }
                }
            } catch (InterruptedException ignored) {
                ignored.printStackTrace();
            }
        }
    }

    private void cutHair() throws InterruptedException {
        Objects.requireNonNull(currentClient);
        System.out.println("Hairdresser cuts " + currentClient.name);
        sleep(getWorkingTime());
        //подстригли клиента, выгнать его
        synchronized (currentClient) {
            currentClient.notify();
        }
        currentClient = null;
    }

    private int getMovingTime() {
        return new Random().nextInt(300) + 100;
    }

    private int getWorkingTime() {
        return new Random().nextInt(1300) + 700;
    }

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    public void addToQueue(Client client) {
        clients.add(client);
    }

    public boolean isSleeping() {
        return sleeping;
    }
}
