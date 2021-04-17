package com.example.company.shopee_202104;

import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: RightSideView
 * @description:
 * @author: pengyi
 * @create: 2021-04-16 16:23
 **/
public class RightSideView {
    /**
     * easy 右先顺
     * 一个表明，当前递归层数
     * 一个表明，当前递归第一个节点
     **/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightSideView_recursion(root, result, 0);
        return result;
    }

    private void rightSideView_recursion(TreeNode root, List<Integer> result, int level){
        if(root == null){
            return;
        }
        if(result.size() <= level){
            result.add(root.val);
        }
        rightSideView_recursion(root.right, result, level + 1);
        rightSideView_recursion(root.left, result, level + 1);
        return;
    }
}
