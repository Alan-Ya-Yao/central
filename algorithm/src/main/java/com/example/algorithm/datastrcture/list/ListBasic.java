package com.example.algorithm.datastrcture.list;

import com.example.algorithm.datastrcture.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/29/20
 * @since 1.0.0
 */
public class ListBasic {


    public static void printList(ListNode head) {
        if (head != null) {
            System.out.print(head.val);
            printList(head.next);
        } else {
            System.out.println();
        }
    }

    /**
     * 206. Reverse Linked List
     * Reverse a singly linked list.
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     **/
    public ListNode reverseList(ListNode head) {
        //采用bottom to top,注意bottom时返回head值
        if (head == null || head.next == null) {
            return head;
        }
        //表明采用bottom to top策略
        ListNode newHead = reverseList(head.next);
        //每次recursion操作当前节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList_iteration(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //采用fakeHead
        ListNode fakeHead = new ListNode(-1);
        while(head != null){
            ListNode tmp = head.next;
            head.next = fakeHead.next;
            fakeHead.next = head;
            head = tmp;
        }
        return fakeHead.next;
    }







    /**
     * leetcode 24 swap nodes in pairs
     * 依然是一个bottom to top 的recursion
     * PDD原题
     * list中两两reverse
     * * * * Input: 1->2->3->4->5->NULL
     * Output: 2->1->4->3->5->NULL
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode toConnect = swapPairs(head.next.next);
        ListNode newToconnect = head.next;
        head.next.next = head;
        head.next = toConnect;
        return newToconnect;
    }


    /**
     * leetcode 25 reverse nodes in K-Group
     * <p>
     * 思路采用bottom to top recursion method
     * <p>
     * <p>
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * <p>
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k
     * then left-out nodes in the end should remain as it is.
     * <p>
     * <p>
     * Given this linked list: 1->2->3->4->5
     * <p>
     * For k = 2, you should return: 2->1->4->3->5
     * <p>
     * For k = 3, you should return: 3->2->1->4->5
     * <p>
     * //思路
     *    每次需要reverse的节点为 [head, end)注意不包含end
     * <p>

     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        for (int i = 1; i < k && end != null; i++) {
            end = end.next;
        }
        //链表不足 k 长度, 保持left-out nodes remain as it is
        if (end == null) {
            return head;
        }
        end = end.next;
        ListNode popHead = reverseKGroup(end, k);
        ListNode pointer = head;
        ListNode fakeHead = new ListNode(-1);
        while(pointer != end){
            ListNode tmp = pointer.next;
            pointer.next = fakeHead.next;
            fakeHead.next = pointer;
            pointer = tmp;
        }
        //链接
        head.next = popHead;
        return fakeHead.next;
    }



    /**
     *  leetcode 141 Linked List Cycle
     *  Given a linked list, determine if it has a cycle in it.
     *
     *  To represent a cycle in the given linked list, we use an integer pos which
     *  represents the position (0-indexed) in the linked list where tail connects to.
     *  If pos is -1, then there is no cycle in the linked list.
     *
     *  Input: head = [3,2,0,-4], pos = 1
     *  Output: true
     */

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow  != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycle_hs(ListNode head){
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(head != null){
            if(nodeSet.contains(head)){
                return true;
            } else{
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }



    /**
     *  leetcode 142 Linked List Cycle II
     *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     *  To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     *  Input: head = [3,2,0,-4], pos = 1
     *  Output: tail connects to node index 1
     *
     * **/

    public ListNode detectCycle_brutal_force(ListNode head) {
        if(head == null) {
            return head;
        }
        HashSet<ListNode> hset = new HashSet<>();
        while(head != null){
            if(hset.contains(head)){
                return head;
            }
            hset.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 142. Linked List Cycle II
     * 这道题非常巧妙.
     * 找到相遇点之后，
     * 一个从头出发，一个从相遇点出发
     * 两者相遇则为beginning点
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast.next == null || fast.next.next == null){
            return null;
        }
        ListNode starter = head;
        while(starter != slow){
            starter = starter.next;
            slow = slow.next;
        }
        return starter;
    }


    /**
     *  leetcode 160  intersection of two linked list
     *  Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     *
     *  Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     *  Output: Reference of the node with value = 8
     *
     *  If the two linked lists have no intersection at all, return null.
     *  Your code should preferably run in O(n) time and use only O(1) memory.
     * */
    public ListNode getIntersectionNode_brutal_force(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        HashSet<ListNode> hset = new HashSet<>();
        while (headA != null){
            hset.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(hset.contains(headB)){
                return  headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     *  小技巧 - 如果两个链表，不相交，最后headA, 与 headB 都会是null
     * **/
    public ListNode getIntersectionNode_two_pointers(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA, b = headB;
        while(a != b){
            a = a == null ? headB:a.next;
            b = b == null ? headA:b.next;
        }
        return a;
    }


    /**
     * leetcode 23 merge K Sorted Lists
     * Merge k sorted linked lists and return it as one sorted list.
     * Analyze and describe its complexity.
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     * */
    //可以采用divider_conquer(本质也是recursion)，也可以直接采用recursion brutal force
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKLists_post_order_traverse(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists_post_order_traverse(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        if(left + 1 == right){
            return merge_two_linked_list(lists[left], lists[right]);
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeKLists_post_order_traverse(lists, left, mid);
        ListNode rightList = mergeKLists_post_order_traverse(lists, mid + 1, right);
        return merge_two_linked_list(leftList, rightList);
    }

    public ListNode merge_two_linked_list(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode fakeHead = new ListNode(-1);
        ListNode rear = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                rear.next = l1;
                l1 = l1.next;
            }else{
                rear.next = l2;
                l2 = l2.next;
            }
            rear = rear.next;
        }
        if(l1 == null){
            rear.next = l2;
        }
        if(l2 == null){
            rear.next = l1;
        }
        return fakeHead.next;
    }

    /**
    * 19. Remove Nth Node From End of List
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
        System.out.println("original list elements : ");
//        printList(reverseList_iteration(l1));

//        printList(reverseKGroupI(l1, 3));


    }
}
