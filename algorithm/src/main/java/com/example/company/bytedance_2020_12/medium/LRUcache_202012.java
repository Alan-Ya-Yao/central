package com.example.company.bytedance_2020_12.medium;

import java.util.HashMap;

public class LRUcache_202012 {
    class DListNode{
        int key = 0;
        int value = 0;
        DListNode prev = null;
        DListNode next = null;
        DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity ;
    int currentSize;
    DListNode head;
    DListNode rear;
    HashMap<Integer, DListNode> hs;

    public LRUcache_202012(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        head = new DListNode(-1, -1);
        rear = new DListNode(-1, -1);
        head.next = rear;
        rear.prev = head;
        hs  = new HashMap<Integer, DListNode>();
    }

    public int get(int key) {
        if(hs.containsKey(key)){
            DListNode node = hs.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(hs.containsKey(key)){
            DListNode node = hs.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
            return;
        }
        if(currentSize == capacity){
            removeNode(rear.prev);
            currentSize --;
        }

        DListNode newNode = new DListNode(key, value);
        hs.put(key, newNode);
        addToHead(newNode);
        currentSize++;
        return;
    }

    private void removeNode(DListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        hs.remove(node.key);
        return;
    }
    private void addToHead(DListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        hs.put(node.key, node);
        return;
    }

}
