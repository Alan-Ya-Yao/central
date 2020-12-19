package com.example.company.bytedance_2020_12.list;

import com.example.algorithm.datastrcture.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_202012 {

    /**
     * 141. Linked List Cycle
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     *  
     *
     * Example 1:
     *
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * */

    /**
     * easy
     * hashset 和 快慢指针
     */
     public boolean hasCycle_hashset(ListNode head) {
         Set<ListNode> hs = new HashSet<ListNode>();
         while(head != null){
             if(hs.contains(head)){
                 return true;
             }
             hs.add(head);
             head = head.next;
         }
         return false;
     }

    public boolean hasCycle_iteration(ListNode head){
        if(head == null){
            return false;
        }
        ListNode quick = head, slow = head;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                return true;
            }
        }
        return false;
    }
}
