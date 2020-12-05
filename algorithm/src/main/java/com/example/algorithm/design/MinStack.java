package com.example.algorithm.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/5/20
 * @since 1.0.0
 */
public class MinStack {

    /**
     * leetcode 155 min stack
     *
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     * **/

    /**
     * 题目分析 - in constant time 意味着空间换时间
     *
     * 设计思路 - 设计一个最小栈，最好使用一个stack作为封装
     * **/
    /** initialize your data structure here. */
    private Stack<Integer> store;
    private Stack<Integer> min;

    public MinStack() {
        store = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        //保存元素先进入
        store.push(x);
        if(min.isEmpty() || min.peek() >= x){
            min.push(x);
        }
    }

    public void pop() {
        if(store.isEmpty()){
            throw new RuntimeException("栈为空，不能pop");
        }
        if(store.peek().equals(min.peek())){
            store.pop();
            min.pop();
        }else{
            store.pop();
        }
    }

    public int top() {
        if(store.isEmpty()){
            throw new RuntimeException("栈为空，不能top()");
        }
        return store.peek();
    }

    public int getMin() {
        if(store.isEmpty()){
            throw new RuntimeException("栈为空，不能getMin()");
        }
        return min.peek();
    }

}
