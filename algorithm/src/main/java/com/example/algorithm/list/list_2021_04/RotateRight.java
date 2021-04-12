package com.example.algorithm.list.list_2021_04;

import com.example.algorithm.datastrcture.entity.ListNode;

/**
 * /**
 *
 * @ClassName: RotateRight
 * @description:
 * @author: pengyi
 * @create: 2021-04-11 17:47
 **/
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        //求链表长度
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len ++;
            tmp = tmp.next;
        }
        //首尾相链
        tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = head;
        //找到位置，断开连接
        int step = len - k % len;
        //手动走第一步
        tmp = head;
        step --;
        //while循环接着走
        while(step != 0){
            tmp = tmp.next;
            step --;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }
}
