package com.example.multi_thread_programming.multi_2021_01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternately_2021_01 {
    private int n;
    private AtomicInteger flag = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public PrintFooBarAlternately_2021_01(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag.get() != 0) {
                    condition1.await();
                }
                printFoo.run();
                flag.set(1);
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag.get() != 1) {
                    condition2.await();
                }
                printBar.run();
                flag.set(0);
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintFooBarAlternately_2021_01 solution = new PrintFooBarAlternately_2021_01(10);
        solution.foo(new Thread(()->{
            System.out.println("foo");
        }));
        solution.bar(new Thread(()->{
            System.out.println("bar");
        }));
    }
}
