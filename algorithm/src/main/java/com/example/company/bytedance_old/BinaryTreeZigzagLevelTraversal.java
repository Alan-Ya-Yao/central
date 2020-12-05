package com.example.company.bytedance_old;


import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/12/20
 * @since 1.0.0
 */
public class BinaryTreeZigzagLevelTraversal {

    /**
     * 103. Binary Tree Zigzag Level Order Traversal
     *  Given a binary tree, return the zigzag level order traversal of its nodes' values.
     *  (ie, from left to right, then right to left for the next level and alternate between)
     *
     *  Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *    [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder_inOrder(root, 1, result);
        return result;
    }

    public void zigzagLevelOrder_inOrder(TreeNode root, int level,  List<List<Integer>>result){
        if(root == null){
            return;
        }
        if(result.size() < level){
            result.add(new ArrayList<Integer>());
        }
        List<Integer> tmp = result.get(level - 1);
        if(level % 2 == 0){
            tmp.add(0,root.val);
        }else{
            tmp.add(root.val);
        }
        zigzagLevelOrder_inOrder(root.left, level + 1, result);
        zigzagLevelOrder_inOrder(root.right, level + 1, result);
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftChildDepth = maxDepth(root.left);
        int rightChildDepth = maxDepth(root.right);
        return Math.max(leftChildDepth, rightChildDepth) + 1;
    }


    /**  最大路径长度，注意可以不用走过root节点
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * */
//    int maxSum = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        maxPathSum_inorder(root);
//        return maxSum;
//    }
//
//    public int maxPathSum_inorder(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        int leftGain = Math.max(maxPathSum_inorder(root.left), 0);
//        int rightGain = Math.max(maxPathSum_inorder(root.right), 0);
//        maxSum = Math.max(maxSum, root.val + leftGain + rightGain);
//        return root.val + Math.max(leftGain, rightGain);
//    }


    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum_Single_dfs(root);
        return result;
    }
    private int maxPathSum_Single_dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSinglePath = maxPathSum_Single_dfs(root.left);
        int rightSinglePath = maxPathSum_Single_dfs(root.right);
        result = Math.max(result, root.val + (leftSinglePath >= 0? leftSinglePath :0) + (rightSinglePath >= 0?rightSinglePath:0));
        return root.val + (Math.max(leftSinglePath, rightSinglePath) >= 0 ? Math.max(leftSinglePath, rightSinglePath):0);
    }


    /**
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     *  右边view
     * */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView_rightOrder(root, 0, result);
        return result;
    }

    public void rightSideView_rightOrder(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        rightSideView_rightOrder(root.right, level + 1, result);
        rightSideView_rightOrder(root.left, level+1, result);
    }

    /**
     *
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
     * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *  最低公共父节点
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left:right;
    }
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        diameterOfBinaryTree_inOrder(root);
        return diameter - 1;
    }
    public int diameterOfBinaryTree_inOrder(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftPath = diameterOfBinaryTree_inOrder(root.left);
        int rightPath = diameterOfBinaryTree_inOrder(root.right);
        diameter = Math.max(diameter, leftPath + rightPath + 1);
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        t1.left = t0;
        t1.right = t2;
        BinaryTreeZigzagLevelTraversal solution = new BinaryTreeZigzagLevelTraversal();
        solution.maxPathSum(t1);
    }
}
