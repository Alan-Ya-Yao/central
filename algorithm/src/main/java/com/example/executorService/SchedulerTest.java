package com.example.executorService;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * /**
 *
 * @ClassName: Test
 * @description:
 * @author: pengyi
 * @create: 2021-05-13 11:47
 **/

public class SchedulerTest {

//    private static ExecutorService executorService = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.DiscardPolicy());
//
//    public static void main(String[] args) {
//        System.out.println("main thread start");
//        CompletableFuture.runAsync(() ->{
//            System.out.println("thread" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(10 * 1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, executorService);
//        CompletableFuture.runAsync(() ->{
//            System.out.println("thread" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(10 * 1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, executorService);
//        CompletableFuture.runAsync(() ->{
//            System.out.println("thread" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(10 * 1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, executorService);
//        CompletableFuture.runAsync(() ->{
//            System.out.println("thread" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(10 * 1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, executorService);
//        System.out.println("main thread end");
//
//    }

//    private static ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//    @Test
//    public void testExcutor(){
//        scheduledExecutor.scheduleWithFixedDelay(()->{
//            System.out.println(111);
//        }, 0, 2, TimeUnit.SECONDS);
//    }

    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    static ScheduledThreadPoolExecutor WORKER_THREAD_POOL = new ScheduledThreadPoolExecutor(1);


    @Test
    public void testExcutor(){
        System.out.println("testExcutor starting");
        String name = "testInfo xx";
        executorService.submit(()->{
            startGrayProcess();
        });
        System.out.println("testExcuter ending");
    }

    @Test
    public void  startGrayProcess() {
        System.out.println("startGrayProcess , " );
        WORKER_THREAD_POOL.schedule(new Runnable(){
            @Override
            public void run(){
                int i = 0;
                while(i != 10){
                    try {
                        Thread.sleep(2 * 1000);
                        System.out.println("startGrayProcess at i " + i + " th");
                        i++;
                        if(i == 7){
                            throw new RuntimeException("can not start to run");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, 2, TimeUnit.SECONDS);

    }
}
