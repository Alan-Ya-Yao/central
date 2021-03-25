package com.example.algorithm.list.list_2021_03;

import com.example.algorithm.datastrcture.entity.ListNode;

/**
 * /**
 *
 * @ClassName: ListBasic
 * @description:
 * @author: pengyi
 * @create: 2021-03-23 20:35
 **/
public class ListBasic {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * Input: head = [1,2,3,4,5]
     * Output: [2,1,4,3,6,5]
     * **/
    public ListNode swapPairs(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode newHead = swapPairs(head.next.next);
       ListNode tmp = head.next;
       head.next.next = head;
       head.next = newHead;
       return tmp;
    }

    /**
     * intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5],
     * **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while(l1 != l2){
            l1 = l1 != null ? l1.next:headB;
            l2 = l2 != null ? l2.next:headA;
        }
        return l1;
    }
}
