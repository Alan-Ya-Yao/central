package com.example.company.coupang_2020_12;

import com.example.algorithm.datastrcture.entity.ListNode;
import com.example.grammer.common.CommonUtils;

public class RotateList_2020_12 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null ) {
            return head;
        }

        //找到list的长度， 注意：如果k = length，则直接返回，不要形成循环链表
        ListNode tmp = head;
        int count = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            count += 1;
        }
        k = k % count;

        if (k == 0) {
            return head;
        }
        tmp.next = head;//目前可以构建成一个环

        ListNode newHead = head, newTail = head;
        for (int i = 0; i < count - k; i++) {
            newHead = newHead.next;
        }
        for (int j = 0; j < count - k - 1; j++) {
            newTail = newTail.next;
        }
        newTail.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        RotateList_2020_12 solution = new RotateList_2020_12();
        CommonUtils.printLinkedList(solution.rotateRight(l1, 7));
    }
}
