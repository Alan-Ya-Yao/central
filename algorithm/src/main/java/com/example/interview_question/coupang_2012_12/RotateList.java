package com.example.interview_question.coupang_2012_12;

import com.example.algorithm.datastrcture.entity.ListNode;

public class RotateList {
    /**
     *  一面第一题
     * 61. Rotate List
     * Given the head of a linked list, rotate the list to the right by k places.
     *
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     * */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        //find the length
        // and connect the head to rear as a ring if k % n != 0
        int length = 1;
        ListNode pointer = head;
        while(pointer.next != null){
            pointer = pointer.next;
            length++;
        }
        if(k % length != 0){
            pointer.next = head;
        }else{
            return head;
        }

        int step = length - k % length;
        //注意只能走 step - 1，对于链表少走一步
        pointer = head;
        while (step > 1){
            pointer = pointer.next;
            step --;
        }
        ListNode newHead = pointer.next;
        pointer.next = null;
        return newHead;
    }


}
