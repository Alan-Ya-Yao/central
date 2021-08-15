package com.example.practice.multithread;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * /**
 *
 * @ClassName: MultiThreadTermination
 * @description:
 * @author: pengyi
 * @create: 2021-06-30 11:34
 **/
public class MultiThreadTermination {

    @Test
    public void testFutureThread() throws InterruptedException, ExecutionException {
        ExecutorService WORKER_THREAD_POOL = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = Arrays.asList(
                new DelayedCallable("fast thread", 100),
                new DelayedCallable("slow thread", 3000));

        long startProcessingTime = System.currentTimeMillis();
        List<Future<String>> futures = WORKER_THREAD_POOL.invokeAll(callables);

//        awaitTerminationAfterShutdown(WORKER_THREAD_POOL);

        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;

        assertTrue(totalProcessingTime >= 3000);

        String firstThreadResponse = futures.get(0).get();

        assertTrue("fast thread".equals(firstThreadResponse));

        String secondThreadResponse = futures.get(1).get();
        assertTrue("slow thread".equals(secondThreadResponse));

    }

    public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    class Result{
        boolean success;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

    @Test
    public void testThreadPoolTermination() {
        Result result = new Result();
        result.setSuccess(true);
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行…… ……");
        ExecutorService WORKER_THREAD_POOL = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10)) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                latch.countDown();
                if(t != null){
                    System.out.println("afterExecute里面获取到异常信息 : " + t.getMessage());
                    System.out.println("开始停止线程池子");
                    System.out.println("线程池已经停止");
                    this.shutdownNow();
                    result.setSuccess(false);
                }
            }
        };

        WORKER_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 1;
                    while (i != 10) {
                        Thread.sleep(4000);
                        System.out.println("子线程1 ：" + Thread.currentThread().getName() + "执行, " + i + "次数");
                        i++;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
//                finally {
//                    latch.countDown();
//                }
            }
        });

        WORKER_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    int i = 1;
                    while (i != 10) {
                        if (i == 4) {
//                            throw new RuntimeException("弹出问题");
                            WORKER_THREAD_POOL.shutdownNow();
                        }
                        Thread.sleep(3000);
                        System.out.println("子线程 2：" + Thread.currentThread().getName() + "执行, " + i + "次数");
                        i++;
                    }
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
//                finally {
//
//                }
            }
        });

        System.out.println("主线程等待子线程执行");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待子线程执行完毕");
        System.out.println("执行结果为： " + result.success);
    }

    @Test
    public void parseDrcVersion() {
        System.out.println(new Date(((6990622270095884290l >> 32) - 30 * 60) * 1000));
    }


    @Test
    public void testChildThread() throws InterruptedException {
        System.out.println("father thread");
        new Thread(){
            @Override
            public void run() {
                int i = 10;
                while (i != 0) {
                    i--;
                    System.out.println("child thrad, with i " + i);
                    try {
                        Thread.currentThread().sleep(3 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.run();
        System.out.println("father thread stop");
    }

    @Test
    public void testSize(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(integerList.stream().filter(e->{return e.equals(10);}).collect(Collectors.toList()).size());

    }


}
