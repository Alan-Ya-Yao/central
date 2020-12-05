package com.example.algorithm.datastrcture.list;

import com.example.algorithm.datastrcture.entity.ListNode;

public class ListNode202010 {

    /**
     * leetcode 143
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     * Example 1:
     *
     * Given 1->2->3->4, reorder it to 1->4->2->3.
     * Example 2:
     *
     * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     * */

    /**
     * 常规链表操作
     1.链表一切为二（采用快慢指针）
     2.逆序后半部分链表（recursion）
     3.交替merge 两个链表成一个链表
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = getTheMidListNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeTwoListAlternatively(head, l2);
    }

    private ListNode getTheMidListNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        if(head == null  || head.next == null){
            return head;
        }
        ListNode tmpHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmpHead;
    }
    /**
     *采用常规merge list的方法 - 更为通用
     *创建dummyhead方法
     */
    private ListNode mergeTwoListAlternatively(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode rear = dummyHead;
        while(head1 != null && head2 != null){
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            rear.next = head1;
            rear.next.next = head2;
            rear = rear.next.next;
            head1 = tmp1;
            head2 = tmp2;
        }
        if(head1 != null){
            rear.next = head1;
        }
        if(head2 != null){
            rear.next = head2;
        }
        return dummyHead.next;
    }

    private static void printList(ListNode head){
        System.out.print(head.val + ",");
        printList(head.next);
    }


    /**
     * 61. Rotate List
     *
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     *
     *
     * 注意是向右移动
     * 用一个total，记录链表长度，
     * 然后通过k，算出，需要从第几个位子切开，
     * 切开后，重新拼装链表
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 1;
        ListNode pointer = head;
        while(pointer != null){
            pointer = head.next;
            length++;
        }
        int remainder = k % length;
        int step = k - remainder;
        pointer = head;
        while(step != 0){
            pointer = pointer.next;
            step --;
        }
        ListNode tmpHead = pointer.next;
        pointer.next = null;
        ListNode tmpRear = tmpHead;
        while(tmpRear.next != null){
            tmpRear = tmpRear.next;
        }
        tmpRear.next = head;
        return tmpHead;
    }

    public static void main(String[] args) {
        ListNode202010 solution = new ListNode202010();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        solution.rotateRight(l1, 4);
    }
}
