package com.example.algorithm.datastrcture.tree;

import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/27/20
 * @since 1.0.0
 */
public class TreeBasic {


    /**
     * basic search - bottom to top recursion method
     * pre-order, in-order, post-order 典型的从bot to top的divide & conquer算法
     *
     * divide & conquer本身是一种递归形式
     *
     * 递归注意递归截止条件
     */

    public static List<TreeNode> preOrder(TreeNode root){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null){
            return result;
        }
        result.add(root);
        List<TreeNode> leftList = preOrder(root.left);
        List<TreeNode> rightList = preOrder(root.right);
        result.addAll(leftList);
        result.addAll(rightList);
        return result;
    }


    /*
        典型 recursion
        第一步确定是 bottom to up
        第二步返回值 采用每一次把sub result组装成总的result 并返回，而非把result 带入每一次recursion
        ..
        确定recursion停止条件
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        List<Integer> leftResult = inorderTraversal(root.left);
        List<Integer> rightResult = inorderTraversal(root.right);
        result.addAll(leftResult);
        result.add(root.val);
        result.addAll(rightResult);
        return result;
    }

    public static List<TreeNode> postOrder(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<TreeNode> leftList = postOrder(root.left);
        List<TreeNode> rightList = postOrder(root.right);
        result.addAll(leftList);
        result.addAll(rightList);
        result.add(root);
        return result;
    }



    /**
     * leetcode 103 Binary Tree Zigzag Level Order Traversal
     * **/
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }

        zigzagLevelOrder_recursion(root, 0, result);
        return result;
    }

    public static void zigzagLevelOrder_recursion(TreeNode root, int level, List<List<Integer>> result){
        if(root == null){
            return;
        }
        List<Integer> tmp;
        if(level >= result.size()){
            tmp = new ArrayList<>();
            result.add(tmp);
        }else{
            tmp = result.get(level);
        }

        //zigzag 顺序开始
        if(level % 2 == 1){
            tmp.add(0, root.val);
        }else{
            tmp.add(tmp.size(), root.val);
        }
        zigzagLevelOrder_recursion(root.left, level + 1, result);
        zigzagLevelOrder_recursion(root.right, level + 1, result);
    }



    /**
     * classic : bot to top recursion
     *
     * **/
    /**
     * Leetcode 236 lowest common ancestor of a binary tree
     * 采用bot-to-top recursion
     * 每一次recursion 返回值
     1.null - 表示找不到p/q, 即不为p 或 q 任何一个值
     2.p || q - 表示找到p 或 q，即为p 或 q 的ancestor
     3.如果左右两个分支都找到 p || q, 则为lowest common ancestor
     4.lowest common ancestor会以一个值往上传递地
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);
        if(leftChild != null && rightChild != null){
            return root;
        }
        return leftChild != null? leftChild: rightChild;
    }

    /*
    *  lowest Common Ancestor : Top to Bottom -brutal 方法
    * */

    public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return root;
        }
        //p, q都在 root的左子树
        if(hasTreeNode(root.left, p) && hasTreeNode(root.left, q)){
            return lowestCommonAncestor_(root.left, p, q);
        }
        //p,q 都在root的右子树
        if(hasTreeNode(root.right, p) && hasTreeNode(root.right, q)){
            return lowestCommonAncestor_(root.right, p, q);
        }
        return root;
    }

    public boolean hasTreeNode(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }
        if(root == p){
            return true;
        }
        return hasTreeNode(root.left, p) || hasTreeNode(root.right, p);
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
        TreeNode root = null;
        if(nums == null || nums.length == 0){
            return root;
        }
        return sortedArrayToBST_recursion_top_bot(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST_recursion_top_bot(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST_recursion_top_bot(nums, left, mid - 1);
        root.right = sortedArrayToBST_recursion_top_bot(nums, mid + 1, right);
        return root;
    }


    public static void printList(List<TreeNode> list){
        list.stream().forEach(e -> System.out.print(e.val + " "));
        return;
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
         *         2    4   6   8
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

//        printList(preOrder(t0));
//        System.out.println();
//        printList(inOrder(t0));
//        System.out.println();
//        printList(postOrder(t0));

        List<List<Integer>> res = zigzagLevelOrder(t0);
        res.stream().forEach(e -> System.out.println(e.toString()));
    }

}
