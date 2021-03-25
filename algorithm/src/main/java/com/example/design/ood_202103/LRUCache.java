package com.example.design.ood_202103;

import com.example.algorithm.design.LRUCache2020111;

import java.util.HashMap;

/**
 * /**
 *
 * @ClassName: LRU
 * @description:
 * @author: pengyi
 * @create: 2021-03-23 21:38
 **/
public class LRUCache {


    /**
     *
     * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
     *
     * Implement the LRUCache class:
     *
     * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
     * int get(int key) Return the value of the key if the key exists, otherwise return -1.
     * void put(int key, int value) Update the value of the key if the key exists.
     * Otherwise, add the key-value pair to the cache.
     * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
     *
     *
     * **/

    int capacity;
    int size;

    DLinkNode head;
    DLinkNode rear;
    HashMap<Integer, DLinkNode> map;

    static class DLinkNode{
        int value;
        int key;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode(-1, -1);
        rear = new DLinkNode(-1, -1);
        head.next = rear;
        head.prev = rear;
        rear.prev = head;
        rear.next = head;
        map = new HashMap<>();
    }

    //先链接，再断开
    private void removeNode(DLinkNode dLinkNode){
        dLinkNode.prev.next = dLinkNode.next;
        dLinkNode.next.prev = dLinkNode.prev;
        dLinkNode.next = null;
        dLinkNode.prev = null;
        return;
    }
    //先链接，再断开
    private void addToHead(DLinkNode dLinkNode){
        dLinkNode.prev = head;
        dLinkNode.next = head.next;
        head.next.prev = dLinkNode;
        head.next = dLinkNode;
        return;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DLinkNode tmp = map.get(key);
            removeNode(tmp);
            addToHead(tmp);
            return tmp.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //有，则更新
        if(map.containsKey(key)){
            DLinkNode tmp = map.get(key);
            tmp.value = value;
            removeNode(tmp);
            addToHead(tmp);
        }else{
            if(size >= capacity){
                //注意这个顺序
                map.remove(rear.prev.key);
                removeNode(rear.prev);
                size --;
            }
            DLinkNode newNode = new DLinkNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size ++;
        }
        return;
    }

    public static void main(String[] args) {
        LRUCache lrc = new LRUCache(2);
        lrc.put(1,1);
        lrc.put(2,2);
        System.out.println(lrc.get(1));
        lrc.put(3,3);
        System.out.println(lrc.get(2));
        lrc.put(4,4);
        System.out.println(lrc.get(1));
        System.out.println(lrc.get(3));
        System.out.println(lrc.get(4));
    }
}
