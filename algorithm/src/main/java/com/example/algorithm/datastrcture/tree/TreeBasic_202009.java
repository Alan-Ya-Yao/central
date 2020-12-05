package com.example.algorithm.datastrcture.tree;



import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/8/20
 * @since 1.0.0
 */
public class TreeBasic_202009 {
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
        if(n == 0 || n == 1){
            return 1;
        }
        int result = 0;
        for(int i = 1; i <= n; i ++){
            result += numTrees(i - 1) * numTrees(n - i);
        }
        return  result;
    }

    /**
     * method two recursion with memory - 经典
     * */
    public int numTrees_(int n){
        int [] result = new int[n + 1];
        return numTrees_recursion(n, result);
    }

    private int numTrees_recursion(int n, int[]result){
        if (n == 1 || n == 0){
            return 1;
        }

        if(result[n] > 0){
            return result[n];
        }

        for(int i = 1; i <= n; i++){
            result[n] += numTrees_recursion(i - 1, result) * numTrees_recursion(n - i, result);
        }
        return result[n];
    }


    /**
     * 96. Unique Binary Search Trees = 2020_11_15
     * 典型dynamic programming
     * G(n) = G(j - 1) * G(n - j)  累加 1<= j <= n
     */
    public int numTrees_d(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <=n ; i++){
            for(int j = 1; j <= i; j++){
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }

    /**
     *  leetcode 95 unique bianry search tree II
     *  Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     *  典型 top to bottom with assemble subresult at each step
     *  https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
     * */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees_recursion(1,n);
    }

    private List<TreeNode> generateTrees_recursion(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> lChildren = generateTrees_recursion(start, i - 1);
            List<TreeNode> rChildren = generateTrees_recursion(i + 1, end );
            for(int l = 0; l < lChildren.size(); l++){
                for(int r = 0; r < rChildren.size(); r++) {
                    TreeNode lChildrenRoot = lChildren.get(l);
                    TreeNode rChildrenRoot = rChildren.get(r);
                    TreeNode root = new TreeNode(i);
                    root.left = lChildrenRoot;
                    root.right = rChildrenRoot;
                    result.add(root);
                }
            }
        }
        return result;
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
    /***
     * 错误的解法 - 原因
     * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/bao-zhun-sheng-guo-guan-fang-ti-jie-by-novice2mast/
    */
    //这是错误的解法
    public boolean isValidBST_Wrong(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean isValidLeft = isValidBST_Wrong(root.left);
        boolean isValidRight = isValidBST_Wrong(root.right);
        return isValidLeft
                && isValidRight
                && root.left != null? root.val >= root.left.val:true
                && root.right != null? root.val <= root.right.val:true;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return  true;
        }
        return isValidBST_Correct(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST_Correct(TreeNode root, Integer min, Integer max){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(!isValidBST_Correct(root.left, min, root.val)){return false;}
        if(!isValidBST_Correct(root.right, root.val, max)){return false;}
        return (root.val > min) && (root.val < max);
    }

    public static void main(String[] args) {
        TreeBasic_202009 solution = new TreeBasic_202009();
        solution.numTrees_(3);

        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(20);


        /**
         *      10
         *    5  15
         *      6  20
         *
         *       1
         *     1
         *
         * */

        t0.left = t1;

//        t0.right = t2;
//        t2.left = t3;
//        t2.right = t4;


        System.out.println(solution.isValidBST(t0));


    }
}
