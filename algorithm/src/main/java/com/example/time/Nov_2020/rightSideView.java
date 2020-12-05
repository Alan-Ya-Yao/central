package com.example.time.Nov_2020;

import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/17/20
 * @since 1.0.0
 */
public class rightSideView {

    /**
     * 199. Binary Tree Right Side View
     * Given a binary tree, imagine yourself standing on the right side of it,
     * return the values of the nodes you can see ordered from top to bottom.
     *
     * Input: [1,2,3,null,5,null,4]
     * Output: [1, 3, 4]
     * Explanation:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     *
     * */
    /**
     * step 1 采用dfs, 右遍先根序
     * step 2 层数 == size，表明为右先根序的节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        rightSideView_dfs(root, 0, res);
        return res;
    }

    private void rightSideView_dfs(TreeNode root, int depth, List<Integer> result){
        if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
        depth += 1;
        rightSideView_dfs(root.right, depth, result);
        rightSideView_dfs(root.left, depth, result);
    }
}



