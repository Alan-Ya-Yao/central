package com.example.algorithm.datastrcture.list;

import com.example.algorithm.datastrcture.entity.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 7/5/20
 * @since 1.0.0
 */
public class ListAdvanced {



   /**
   *  82. Remove Duplicates from Sorted List II
   *
   * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
   *
   * Return the linked list sorted as well.
   *
   * Example 1:
   * Input: 1->2->3->3->4->4->5
   * Output: 1->2->5
   *
   * Example 2:
   * Input: 1->1->1->2->3
   * Output: 2->3
   *
    *
    *  采用经典的recursion method
    *  这里使用tmp，是为了出现3，5等基数个相同点
     *  利用tmp 记录上次重复的值
     *
     *  tmp永远指向上次被删除的值
    * */

   public static  ListNode tmp;
   public static ListNode deleteDuplicatesII(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode currentHead = deleteDuplicatesII(head.next);
        if(tmp == null){
            tmp = currentHead;
        }
        if(head.val == tmp.val){
            return tmp.next; //注意这里一定是tmp
        }else{
            head.next = currentHead;
            tmp = head;
            return head;
        }

   }

    /**
     *
     * */
    public ListNode deleteDuplicates_iteration(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next !=null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                ListNode tmp = cur.next;
                while(tmp.next!= null && tmp.val == tmp.next.val){
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

   /** 13, 17 号
    * leetcode 83 remove duplicates from sorted list
    * Given a sorted linked list, delete all duplicates such that each element appear only once.
    * Input: 1->1->2
    * Output: 1->2
    *
    * Input: 1->1->2->3->3
    * Output: 1->2->3
    * */
    //采用最经典的recursion method
   public ListNode deleteDuplicates(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode dummyHead = deleteDuplicates(head.next);
       if(head.val == dummyHead.val){
           head.next = dummyHead.next;
       }else{
           head.next = dummyHead;
       }
       return head;
   }

   public static void printList(ListNode head){
       if(head == null ){
           return;
       }
       System.out.print(head.val + ",");
       printList(head.next);
   }



    public static void main(String[] args) {
            ListNode l1 = new ListNode(1);
            ListNode l2 = new ListNode(1);
            ListNode l3 = new ListNode(1);
            ListNode l4 = new ListNode(1);
            ListNode l5 = new ListNode(2);
            ListNode l6 = new ListNode(3);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            l4.next = l5;
            l5.next = l6;
            ListNode newHead = deleteDuplicatesII(l1);
            printList(newHead);

    }

}
