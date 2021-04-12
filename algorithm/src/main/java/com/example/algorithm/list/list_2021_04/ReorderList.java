package com.example.algorithm.list.list_2021_04;

import com.example.algorithm.datastrcture.entity.ListNode;
import com.example.algorithm.list.list_2021_03.ListBasic;

import java.util.List;

/**
 * /**
 *
 * @ClassName: ReorderList
 * @description:
 * @author: pengyi
 * @create: 2021-04-11 16:17
 **/
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2; l2.next = l3; l3.next = l4;

//        ListBasic.printList(l1);
        ReorderList solution = new ReorderList();
        solution.reorderList(l1);
        ListBasic.printList(l1);
    }
}
