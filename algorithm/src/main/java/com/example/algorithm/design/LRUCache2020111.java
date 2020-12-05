package com.example.algorithm.design;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/9/20
 * @since 1.0.0
 */
public class LRUCache2020111 {
    /**
     * 整体思路
     * 1.采用double linked list + hashmap
     * 2.不能采用单链表，是因为不方便把中间节点，移动到末尾节点，表示最新used的节点
     *
     * 先定义数据结构 + 辅助函数
     *
     */

    class DLinkedNode {
        Integer key;
        Integer value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    DLinkedNode head ;
    DLinkedNode rear ;
    HashMap<Integer, DLinkedNode> hs;
    int capacity;
    int current;

    public LRUCache2020111(int capacity) {
        this.capacity = capacity;
        this.current = 0;
        this.head = new DLinkedNode(-1, -1);
        this.rear = new DLinkedNode(-1, -1);
        head.next = rear;
        rear.prev = head;
        hs = new HashMap<Integer, DLinkedNode>();
    }

    public int get(int key) {
        DLinkedNode node = hs.get(key);
        if(node == null){
            return -1;
        }
        removeTheDLinkedNode(node);
        putToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        //如果有则更新，没有则新建
        DLinkedNode node = hs.get(key);
        if(node != null){
            node.value = value;
            removeTheDLinkedNode(node);
            putToTail(node);
        }else {
            if (current == capacity) {
                DLinkedNode tmp = removeTheHead();
                current--;
                hs.remove(tmp.key);
            }
            node = new DLinkedNode(key, value);
            hs.put(key, node);
            current++;
            putToTail(node);
        }

    }

    private void removeTheDLinkedNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void putToTail(DLinkedNode node){
        rear.prev.next = node;
        node.prev = rear.prev;
        node.next = rear;
        rear.prev = node;
    }
    // remove必须返回值，因为要从hashmap中移除值
    private DLinkedNode removeTheHead(){
        DLinkedNode tmp = head.next;
        head.next.next.prev = head;
        head.next = head.next.next;
        return tmp;
    }

    public static void main(String[] args) {
        /***
         *
         ["LRUCache","put","put","put","put","get","get"]
         [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         *          * my result:
         * [null,null,null,null,null,1,-1]
         *          * correct result:
         * [null,null,null,null,null,-1,3]
         */
        LRUCache2020111 lrc = new LRUCache2020111(2);
        lrc.put(2,1);
        lrc.put(1,1);
        lrc.put(2,3);
        lrc.put(4,1);
        lrc.get(1);
        lrc.get(2);
        int value = lrc.get(2);
        System.out.println(value);
    }
}
