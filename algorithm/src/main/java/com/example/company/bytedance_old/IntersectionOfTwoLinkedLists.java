package com.example.company.bytedance_old;

import com.example.algorithm.datastrcture.entity.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/3/20
 * @since 1.0.0
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 160. Intersection of Two Linked Lists
     *
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     * intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
     * Output: Reference of the node with value = 8
     *
     * intersectVal = 0, listA = [2,6,4], listB = [1,5]
     * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy = null;
        if(headA == null || headB == null){
            return dummy;
        }
        ListNode p1 = headA, p2 = headB;
        //p1 与 p2同时走到null时候，则表明什么不相交
        while(p1 != null || p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1 == null? headB:p1.next;

            p2 = p2 == null? headA:p2.next;
        }
        return dummy;
    }
}
