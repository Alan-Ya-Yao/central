package com.example.algorithm.design;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/21/20
 * @since 1.0.0
 */
public class AllOne {

    /**
     *
     *  leetcode 432 all O one data structure
     *
     *  Implement a data structure supporting the following operations:
     *
     * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
     * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
     * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
     * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
     * Challenge: Perform all these in O(1) time complexity.
     *
     * */

    /** Initialize your data structure here. */
    HashMap<String, ListDNode> map;
    ListDNode head;
    ListDNode rear;

    class ListDNode{
        String key;
        Integer value;
        ListDNode prev;
        ListDNode next;
        ListDNode(String key, Integer value){
            this.key = key;
            this.value = value;
        }
    }


    public AllOne() {
        map = new HashMap<String, ListDNode>();
        head = new ListDNode("", Integer.MAX_VALUE);
        rear = new ListDNode("", Integer.MIN_VALUE);
        head.next = rear;
        rear.prev = head;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
            ListDNode current = map.get(key);
            current.value += 1;
            ListDNode prev = current.prev;
            while(prev.value < current.value){
                prev = prev.prev;
            }
            //删除 current，把 current插入到prev的next位置
            removeNode(current);
            insertDNode(prev, current);
        }else{
            ListDNode tmp = new ListDNode(key, 1);
            map.put(key, tmp);
            insertDNode(rear.prev, tmp);
        }
        return;
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            ListDNode current = map.get(key);
            current.value -= 1;
            if(current.value == 0){
                map.remove(key);
                removeNode(current);
                return;
            }

            if(current.value >= current.next.value){
                return;
            }
            ListDNode next = current.next;
            while(current.value < next.value){
                next = next.next;
            }
            removeNode(current);
            insertDNode(next.prev, current);
        }
        return;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return map.isEmpty() ? "":head.next.key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return map.isEmpty() ? "":rear.prev.key;
    }


    /**
     * 十分关键一步，抽象为链表的基本操作，而不是多个组合操作合而为一
     * */
    public void removeNode(ListDNode tmp){
        if(tmp == null){
            return;
        }
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        return;
    }

    public void insertDNode(ListDNode position, ListDNode tmp){
        if(position == null || tmp == null){
            return;
        }
        tmp.next = position.next;
        position.next.prev = tmp;
        position.next = tmp;
        tmp.prev = position;
        return;
    }

    public static void main(String[] args) {
        AllOne solution = new AllOne();
        solution.inc("hello");
        solution.inc("world");
        solution.inc("leet");
        solution.inc("code");
        solution.inc("DS");
        solution.inc("leet");
        solution.inc("DS");
        solution.dec("leet");
        solution.dec("leet");
        solution.inc("hello");
        solution.inc("hello");
        solution.inc("hello");
        solution.dec("world");
        solution.dec("leet");
        solution.dec("code");
        solution.dec("DS");

        System.out.println(solution.getMinKey());
        solution.dec("b");
        System.out.println(solution.getMaxKey());
        System.out.println(solution.getMinKey());


    }
}
