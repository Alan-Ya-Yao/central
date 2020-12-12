package com.example.company.bytedance_2020_12.list;

import com.example.algorithm.datastrcture.entity.ListNode;

public class LinkedListCycleII_2020_12 {

    /**
     *
     * leetcode 142. Linked List Cycle II
     *
     *  采用hashset
     *  采用定理
     *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
     * following the next pointer.
     * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
     *  Note that pos is not passed as a parameter.
     *
     * Notice that you should not modify the linked list.
     *
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode quick = head, slow = head;
        //判断是否有圈，得到它们之间第一次相碰见的点
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                break;
            }
        }
        if(quick != slow){
            return null;
        }
        ListNode restartAtHead = head;
        while(restartAtHead != quick){
            restartAtHead = restartAtHead.next;
            quick = quick.next;
        }
        return restartAtHead;
    }

}
