package com.example.time.Nov_2020;

import com.example.algorithm.datastrcture.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/16/20
 * @since 1.0.0
 */
public class generateTrees {

    /**
     * 95. Unique Binary Search Trees II
     * Input: 3
     * Output:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     *
     * */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return generateTrees_bot_to_top(1, n);
    }

    private List<TreeNode> generateTrees_bot_to_top(int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            List<TreeNode> treeNodeList = new ArrayList<>();
            treeNodeList.add(null);
            return treeNodeList;
        }
        List<TreeNode> result = new ArrayList<>();
        for(int i = leftIndex; i <= rightIndex; i++){
            List<TreeNode> leftChildren = generateTrees_bot_to_top(leftIndex, i - 1);
            List<TreeNode> rightChildren = generateTrees_bot_to_top(i + 1, rightIndex);
            for(TreeNode treeNodeLeft: leftChildren){
                for(TreeNode treeNodeRight: rightChildren){
                    TreeNode root = new TreeNode(i);
                    root.left = treeNodeLeft;
                    root.right = treeNodeRight;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
