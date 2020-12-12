package com.example.company.bytedance_2020_12.tree;

import com.example.algorithm.datastrcture.entity.TreeNode;

public class BinaryTreeMaximumPathSum_202012 {



    int maxSum = Integer.MIN_VALUE;
    public  int maxPathSum(TreeNode root) {
        maxLeg(root);
        return maxSum;
    }

    private int maxLeg(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxLeftLeg = maxLeg(root.left);
        int maxRightLeg = maxLeg(root.right);
        maxSum = Math.max(maxSum, root.val + (maxLeftLeg > 0 ? maxLeftLeg:0) + (maxRightLeg > 0 ? maxRightLeg:0));

        return root.val +  (Math.max(maxLeftLeg, maxRightLeg) > 0 ?  Math.max(maxLeftLeg, maxRightLeg) : 0);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        BinaryTreeMaximumPathSum_202012 solution = new BinaryTreeMaximumPathSum_202012();
        System.out.println(solution.maxPathSum(t2));

    }
}
