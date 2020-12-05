package com.example.company.bytedance_old;

import com.example.algorithm.datastrcture.entity.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/8/20
 * @since 1.0.0
 */
public class ReverseNodesInKGroup {
    /**
     *  leetcode 25. Reverse Nodes in k-Group
     *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     *  k is a positive integer and is less than or equal to the length of the linked list.
     *  If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *
     *  Given this linked list: 1->2->3->4->5
     *
     *  For k = 2, you should return: 2->1->4->3->5
     *
     *  For k = 3, you should return: 3->2->1->4->5
     * */

    /**
     *  list 类型题目，典型的recursion method
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        //首先构建recursin 截止条件，采用bottom_to_top方式
        ListNode tail = head;
        for(int i = 1; i < k && tail!= null; i++){
            tail = tail.next;
        }
        if(tail == null){
            return head;
        }
        ListNode bottomHead = reverseKGroup(tail.next, k);
        //采用iteration 迭代 反转链表
        //迭代反转链表，构建一个dummy head
        ListNode dummyHead = new ListNode(-1);
        //保留需要反转链表的头，和它下一个不被反转的节点
        ListNode endNext = tail.next;
        ListNode pointer = head;
        while(pointer != endNext){    //这里是一个关键点
            ListNode tmp = pointer.next; //  保留下一个节点
            pointer.next = dummyHead.next; // 先建立链接
            dummyHead.next = pointer;
            pointer = tmp;
        }
        head.next = bottomHead;
        return dummyHead.next;
    }
}
