package com.norg.home14;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.LinkedList;

/**
 * Свой тред пул
 */
public class ThreadPool {
    private boolean terminated = false;
    private final LinkedList<Runnable> jobs = new LinkedList<>();
    private final PoolWorker[] workers;

    public ThreadPool(int poolSize) {
        workers = new PoolWorker[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new PoolWorker("Worker #" + i);
            workers[i].start();
        }
    }

    public void addJob(Runnable runnable) {
        if(terminated) {
            throw new InvalidStateException("Cannot add job to terminated pool!");
        }
        synchronized (jobs) {
            jobs.add(runnable);
            jobs.notify();
        }

    }

    public void terminateAll() {
        for (PoolWorker worker :
                workers) {
            worker.interrupt();
        }
        terminated = true;
    }

    public boolean isTerminated() {
        return terminated;
    }

    private class PoolWorker extends Thread {
        public PoolWorker(String name) {
            super(name);
        }

        @Override
        public void run() {
            //главный цикл ожидания работы
            main:
            while (true) {
                synchronized (jobs) {
                    //если работы нет, ждать ее появления
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException ignored) {
                            //если получен сигнал прерывания - выходим из главного цикла ожидания работы
                            break main;
                        }
                    }
                }
                //работа появилась, берем первый в очереди
                Runnable job = jobs.pollFirst();
                //и на всякий случай проверим, что там что-то есть
                if (job != null) {
                    System.out.println(getName() + " started...");
                    try {
                        job.run();
                    } catch (Exception e) {
                        System.out.println("Exception in " + getName() + ": " + e);
                    }
                    System.out.println(getName() + " finished.");
                }
            }
        }
    }
}
