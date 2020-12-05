package com.example.company.bytedance_old;


import com.example.algorithm.datastrcture.entity.ListNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/3/20
 * @since 1.0.0
 */
public class AddTwoNumbers {

    /**
     * leetcode 2 Add Two Numbers - tags list basic operation
     * <p>
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = l1 , p2 = l2, current = dummyHead;
        int carry = 0;
        while(p1 != null || p2 != null){
            int x = p1 != null ? p1.val :0;
            int y = p2 != null ? p2.val :0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
        }
        if(carry != 0){
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
