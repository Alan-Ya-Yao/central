package com.example.company.bytedance_2020_12.tree;

import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree_2020_12 {
    /**
     *  lc 662. Maximum Width of Binary Tree
     *  树的最大宽度
     *
     *  Input:
     *
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     *   Output: 8
     *   Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
     */
    int maxWidth = Integer.MIN_VALUE;
    Map<Integer, Integer> depthIndex = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs_inorder(root, 0, 0);
        return maxWidth;
    }

    private void dfs_inorder(TreeNode root, int depth, int index){
        if(root == null){
            return;
        }
        //只记录每个depth的，第一个index
        depthIndex.compute(depth, (key, value) ->value == null ? index:value);
        maxWidth = Math.max(maxWidth, index - depthIndex.get(depth) + 1);
        dfs_inorder(root.left, depth + 1, index * 2 + 1);
        dfs_inorder(root.right, depth + 1, index * 2 + 2);
        return;
    }
}
