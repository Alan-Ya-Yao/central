package com.example.multi_thread_programming.multi_2021_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue_2021_01<T> {

    /***
     *
     *     https://blog.csdn.net/qcl108/article/details/101944750
     *
     *     https://leetcode-cn.com/problems/design-bounded-blocking-queue/solution/zhu-shi-ban-zu-sai-dui-lie-lockcondition-by-j-oles/
     *
     */
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition freeCond = lock.newCondition();
    private final Condition elemCond = lock.newCondition();
    private final Queue<Integer> que = new LinkedList<>();
    private final int capacity;

    public BlockingQueue_2021_01(int capacity) {
        this.capacity = capacity;
    }


}
