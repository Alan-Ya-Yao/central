package com.example.practice;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * /**
 *
 * @ClassName: TimerTask
 * @description:
 * @author: pengyi
 * @create: 2021-06-16 22:25
 **/
public class TimerTaskSchedulerTest {

    @Test
    public void testTimerTask() throws InterruptedException {
        for (int i = 0; i < 10; ++i) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println((Thread.currentThread().getName() + " run "));
                }
            }, 3000);
        }

        Thread.sleep(10 * 1000 * 3);
    }

    @Test
    public void testExcutor() throws InterruptedException {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 9; ++i) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run ");
                }
            } , 2 * i, TimeUnit.SECONDS);
        }
        executor.awaitTermination(4, TimeUnit.MINUTES);
    }
}
