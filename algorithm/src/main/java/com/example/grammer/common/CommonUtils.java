package com.example.grammer.common;

import com.example.algorithm.datastrcture.entity.ListNode;

import java.util.List;

public class CommonUtils {

    public static <T> void printList(List<T> list){
        for(T t: list){
            System.out.print(t +", ");
        }
        System.out.println();
    }

    public static void printLinkedList(ListNode head){
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.val + " " );
            tmp = tmp.next;
        }
        System.out.println();
    }
}
