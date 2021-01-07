package com.example.company.bytedance_2020_12.design;

import java.util.Stack;

public class MinStack_2021_01 {

    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     *
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * Output
     * [null,null,null,null,-3,null,0,-2]
     *
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     *
     * **/

    /*
    * 简单设计题
    * 需要2个stack
    * 一个记录所有元素
    * 一个记录当前最小元素
    *
    * */

    /** initialize your data structure here. */
    private Stack<Integer> store;
    private Stack<Integer> min;

    public MinStack_2021_01() {
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
