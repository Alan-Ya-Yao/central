package com.example.algorithm.datastrcture.tree;

import com.example.algorithm.datastrcture.entity.TreeNode;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/10/20
 * @since 1.0.0
 */
public class MaxPathSum2020_11 {

    /**
     * leetcode 124. Binary Tree Maximum Path Sum
     * */
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
}
