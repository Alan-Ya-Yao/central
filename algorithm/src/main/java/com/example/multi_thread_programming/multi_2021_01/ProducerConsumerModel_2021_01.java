package com.example.multi_thread_programming.multi_2021_01;

import lombok.Synchronized;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerModel_2021_01<T> {

    /**
     * 消费者 生产者模型
     * 采用传统的synchronized 方法
     *
     * */
    private Integer currentNumber;

    private Integer capacity;

    private Queue<T> queue;

    private String lock;

    ProducerConsumerModel_2021_01(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<T>();
    }

    public void produce(T value) {
        synchronized(lock){
            if(currentNumber >= capacity){
                try {
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            queue.add(value);
            currentNumber++;
            queue.notifyAll();
        }
    }

    public void consume(){
        synchronized (lock){
            if(currentNumber <= 0){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            queue.remove();
            currentNumber --;
            queue.notifyAll();
        }
    }
}
