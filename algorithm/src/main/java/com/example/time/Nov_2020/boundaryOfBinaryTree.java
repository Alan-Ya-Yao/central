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
public class boundaryOfBinaryTree {

//    /**
//     *
//     * 545. Boundary of Binary Tree
//     *
//     * Input:
//     *     ____1_____
//     *    /          \
//     *   2            3
//     *  / \          /
//     * 4   5        6
//     *    / \      / \
//     *   7   8    9  10
//     *
//     * Ouput:
//     * [1,2,4,7,8,9,10,6,3]
//     *
//     * Explanation:
//     * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
//     * The leaves are node 4,7,8,9,10.
//     * The right boundary are node 1,3,6,10. (10 is the right-most node).
//     * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
//     * **/

    /**
     *  采用三段式遍历，左边view（去除叶子结点）， 叶节点，左边view（去除叶子结点）
     * */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        return null;
    }

    private void leftViewWithOutLeaf(TreeNode root, int depth,  List<Integer> result){
        if(root.left == null && root.right == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
    }
}
