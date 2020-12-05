package com.example.algorithm.recursion;

import com.example.algorithm.datastrcture.entity.*;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/5/20
 * @since 1.0.0
 */
public class RecursionBasic {

    /**
     *  重要 把树的深度，变为1，同时返回根节点
     *  这个操作技巧在 union find 查并集中有广泛应用
     *  flatTree = find 操作
     * **/
    public static int flatTree(int[] tree, int i){
        int tmp = tree[i];
        if(tmp != i){
            tmp = flatTree(tree, tmp);
        }
        tree[i] = tmp;
        return tmp;
    }

    /**
     * * leetcode 25 reverse Nodes in K-group
    *
    *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    *
    *  k is a positive integer and is less than or equal to the length of the linked list.
    *  If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
    * Given this linked list: 1->2->3->4->5

    *  For k = 2, you should return: 2->1->4->3->5

    *  For k = 3, you should return: 3->2->1->4->5

    * */
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }




    public static void main(String[] args) {
        //构建两颗树
        int[] tree = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        //4是这颗树的根节点
        for(int i = 0; i < 4; i++){
            tree[i] = i + 1;
        }
        //5是这颗树的根节点
        for(int i = 8; i >5; i--){
            tree[i] = i - 1;
        }

        System.out.println(Arrays.toString(tree));

        for(int i = 0; i < tree.length;i++){
            flatTree(tree, i);
        }

        System.out.println(Arrays.toString(tree));
    }
}
