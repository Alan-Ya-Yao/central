package com.example.algorithm.tree;

import com.example.algorithm.datastrcture.entity.TreeNode;
import scala.Int;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.example.grammer.common.CommonUtils;

public class tree_202012_复习 {


    public static List<Integer> preOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        List<Integer> leftPreOrder = preOrder(root.left);
        List<Integer> rightPreOrder = preOrder(root.right);
        result.addAll(leftPreOrder);
        result.addAll(rightPreOrder);
        return result;
    }

    public static  List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    public static List<TreeNode> postOrder(TreeNode root) {
        return null;
    }

    /**
     * leetcode 103 Binary Tree Zigzag Level Order Traversal
     * **/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
    }
    /**
     * Leetcode 236 lowest common ancestor of a binary tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }

    /**
     *  leetcode 108. Convert Sorted Array to Binary Search Tree
     *
     *  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     *  For this problem, a height-balanced binary tree is defined as a binary tree
     *  in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * */
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }

    /***
     *  2020_09
     *  leetcode 96. Unique Binary Search Trees
     *  Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
     *
     * solution https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-cong-yuan-shi-de-di-/
     */
    /**
     * method one recursion -  top to bottom with subresult - assemble to subresult - 经典
     * */
    public int numTrees(int n) {
        return 0;
    }

    /**
     *  leetcode 95 unique bianry search tree II
     *  Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     *  典型 top to bottom with assemble subresult at each step
     *  https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
     * */

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    /**
     *  leetcode 98 validate binary search tree
     *  Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     * **/
    public boolean isValidBST(TreeNode root) {
        return false;
    }

    /**
     * leetcode 124. Binary Tree Maximum Path Sum
     * */
    public int maxPathSum(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(8);
        TreeNode t7 = new TreeNode(1);
        TreeNode t8 = new TreeNode(0);
        TreeNode t9 = new TreeNode(-3);

        /*
         *                5
         *             /     \
         *            3       7
         *          /   \    /  \
         *         2    4   6    8
         *        /    /
         *       1    0
         *   post Order : 1, 2, 0, 4, 3, 6, 8, 7, 5
         * */
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t4.left = t8;
        //       t8.right = t9;

        CommonUtils.printList(preOrder(t0));

    }
}
