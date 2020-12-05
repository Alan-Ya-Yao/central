package com.example.algorithm.design;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/5/20
 * @since 1.0.0
 */
public class LRUCache {

    /**
     *
     *
     * leetcode 146 - LRU Cache
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
     * otherwise return -1.
     *
     * put(key, value) - Set or insert the value if the key is not already present.
     * When the cache reached its capacity,
     * it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     *
     *   LRUCache cache = new LRUCache( 2 capacity );
     **   cache.put(1,1);
          cache.put(2,2);
          cache.get(1);       // returns 1
          cache.put(3,3);    // evicts key 2
          cache.get(2);       // returns -1 (not found)
          cache.put(4,4);    // evicts key 1
          cache.get(1);       // returns -1 (not found)
          cache.get(3);       // returns 3
          cache.get(4);       // returns 4
     * follow - up
     * Could you do both operations in O(1) time complexity?
     *
    */

    /**
     * 需要的数据
     * */
    private int capacity;
    private int size;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head;
    private DLinkedNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode == null){
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public void put(int key, int value) {

        if(cache.containsKey(key)){
            DLinkedNode tmp = cache.get(key);
            tmp.value = value;
            moveToHead(tmp);
            return;
        }

        DLinkedNode node = new DLinkedNode(key, value);
        cache.put(key, node);
        addNode(node);
        size++;

        if(size > capacity){
            DLinkedNode tail = popTail();
            cache.remove(tail.key);
            size --;
        }
        return;
    }

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    // 删除节点
    private void removeNode(DLinkedNode node){
        //断开旧链接，建立头节点链接
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
        return;
    }

    //添加一个新节点, 永远添加到头节点
    private void addNode(DLinkedNode node){

        //新的节点先建立链接，后断开旧节点链接
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
        return;
    }

    //把节点移动到头节点
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
        return;
    }

    //移除末尾节点
    private DLinkedNode popTail(){
        DLinkedNode prevTail = tail.prev;
        removeNode(prevTail);
        return prevTail;
    }

}

