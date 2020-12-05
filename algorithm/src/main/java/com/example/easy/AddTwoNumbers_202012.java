package com.example.easy;

import com.example.algorithm.datastrcture.entity.ListNode;

public class AddTwoNumbers_202012 {

    /*
    * lc 2
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null ){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int carry = 0;
        ListNode fakeHead = new ListNode(-1);
        ListNode rear = fakeHead;
        while(carry != 0 || l1 != null || l2 != null){
            int l1Int = l1 != null ? l1.val:0;
            int l2Int = l2 != null ? l2.val:0;
            int reminder = (carry + l1Int + l2Int) % 10;
            carry = (carry + l1Int + l2Int) / 10;
            rear.next = new ListNode(reminder);
            rear = rear.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return fakeHead.next;
    }
}
