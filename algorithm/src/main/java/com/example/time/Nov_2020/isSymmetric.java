package com.example.time.Nov_2020;

import com.example.algorithm.datastrcture.entity.TreeNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/17/20
 * @since 1.0.0
 */
public class isSymmetric {

    /**
     * 101. Symmetric Tree
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 典型从bot -到-  top
     *
     * 我的解决思路是： 1st. reverse tree(需要复制一个树先）, 再 2nd 判断是否是一样的树
     * */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode copiedTree = copyTree(root);
        TreeNode reverseTree = reverseTree(copiedTree);
        return checkSameTree(root, reverseTree);

    }

    /**
     *  复制一个树
     *  recursion from bottom to top
     * */
    private TreeNode copyTree(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode leftCopy = copyTree(root.left);
        TreeNode rightCopy = copyTree(root.right);
        TreeNode tmpRoot = new TreeNode(root.val);
        tmpRoot.left = leftCopy;
        tmpRoot.right = rightCopy;
        return tmpRoot;
    }

    /**
     * reverse a tree
     * recursion from bottom to top
     * */
    private TreeNode reverseTree(TreeNode root){
        if(root == null){
            return root;
        }
        TreeNode reverseLeft = reverseTree(root.left);
        TreeNode reverseRight = reverseTree(root.right);
        root.left = reverseRight;
        root.right = reverseLeft;
        return root;
    }

    /**
     * check a tree is the same
     * 从上至下
     * */
    private boolean checkSameTree(TreeNode root1, TreeNode root2){
        //都为空
        if(root1 == null && root2 == null){
            return  true;
        }else if(root1 == null  || root2 == null) {
            //其中之一为空
            return false;
        }else{
            return root1.val == root2.val && checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right);
        }
    }


    public boolean isSymmetric_leetcode_solution(TreeNode root){
       return checkSymmetric_two_pointer(root, root);
    }

    private boolean checkSymmetric_two_pointer(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null){
            return true;
        }else if(p1 == null || p2 == null){
            return false;
        }else{
            return p1.val == p2.val && checkSymmetric_two_pointer(p1.left, p2.right) && checkSymmetric_two_pointer(p1.right, p2.left);
        }
    }
}
