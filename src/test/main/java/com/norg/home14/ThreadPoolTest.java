package com.norg.home14;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Norg on 17.09.2016.
 */
public class ThreadPoolTest {

    @Test
    public void manyTasksTest() {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 0; i < 8; i++) {
            String name = "I'am task " + i;
            pool.addJob(() -> {
                try {
                    System.out.println(name);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Test
    public void workerExceptionTest() {
        ThreadPool pool = new ThreadPool(3);
        for (int i = 0; i < 4; i++) {
            String name = "I'am task " + i;
            pool.addJob(() -> {
                try {
                    System.out.println(name);
                    TimeUnit.SECONDS.sleep(2);
                    throw new RuntimeException("Danger!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
