package com.example.multi_thread_programming.multi_2021_03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * /**
 *
 * @ClassName: EvenOddPrinter
 * @description:
 * @author: pengyi
 * @create: 2021-03-25 15:28
 **/
public class EvenOddPrinter {
    /**
    * java两个线程交替打印奇偶数，直到N
    * **/
    /**
     * solution : 两个线程，需要共享状态变量
//     * */
    static class Counter{
        private AtomicInteger current = new AtomicInteger(0);
        private Integer total;
        Counter(Integer total){
            this.total = total;
        }
        public AtomicInteger getCurrent(){
            return current;
        }
        public Integer getTotal(){
            return total;
        }
    }

    static class PrintOdd implements Runnable{
        private  Counter counter;

        PrintOdd(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run() {
            try {
                synchronized (counter){
                    System.out.println("odd");
                    while(counter.getCurrent().get() <= counter.getTotal()){
                        if(counter.getCurrent().get() % 2 != 1){
                            System.out.println(String.format("class %s, print the value %s", this.getClass(), counter.getCurrent()));
                            counter.getCurrent().incrementAndGet();
                            counter.notify();
                        }else{
                            counter.wait();
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    static class PrintEven implements Runnable{
        private  Counter counter;

        PrintEven(Counter counter){
            this.counter = counter;
        }

        @Override
        public void run(){
            try{
                System.out.println("even");
                synchronized (counter){
                    while(counter.getCurrent().get() <= counter.getTotal()){
                        if(counter.getCurrent().get() %2 == 0){
                            System.out.println("even");
                            System.out.println(String.format("class %s, print the value %s", this.getClass(), counter.getCurrent()));
                            counter.getCurrent().incrementAndGet();
                            counter.notify();
                        }else{
                            counter.wait();
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter(100);
        PrintOdd printOdd = new PrintOdd(counter);
        PrintEven printEven = new PrintEven(counter);
        new Thread(printEven).run();
        new Thread(printOdd).run();
    }

}
