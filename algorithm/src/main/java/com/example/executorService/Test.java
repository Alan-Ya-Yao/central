package com.example.executorService;

import java.util.concurrent.*;

/**
 * /**
 *
 * @ClassName: Test
 * @description:
 * @author: pengyi
 * @create: 2021-05-13 11:47
 **/
public class Test {

    private static ExecutorService executorService = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        System.out.println("main thread start");
        CompletableFuture.runAsync(() ->{
            System.out.println("thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        CompletableFuture.runAsync(() ->{
            System.out.println("thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        CompletableFuture.runAsync(() ->{
            System.out.println("thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        CompletableFuture.runAsync(() ->{
            System.out.println("thread" + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);
        System.out.println("main thread end");

    }
}
