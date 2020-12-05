package com.example.algorithm.design;

import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/8/20
 * @since 1.0.0
 */
public class MedianFinder {

    /** initialize your data structure here. */
    // leetcode 295. Find Median from Data Stream
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     * */

    PriorityQueue<Integer> sQueue; // 默认是最小堆栈
    PriorityQueue<Integer> lQueue; // 需构建一个最大堆
    int size;

    public MedianFinder() {
        size = 0;
        sQueue = new PriorityQueue<>();
        lQueue = new PriorityQueue<>((x, y) -> {return y - x;});
    }

    public void addNum(int num) {
        if(size % 2 == 0){
            lQueue.add(num);
        }else{
            sQueue.add(num);
        }
        size ++;
    }

    public double findMedian() {
        if(size % 2 == 0){
            return (lQueue.peek() + sQueue.peek()) / 2.0;
        }else{
            return lQueue.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        solution.addNum(3);
        System.out.println(solution.findMedian());

    }
}
