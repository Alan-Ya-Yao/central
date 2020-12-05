package com.example.algorithm.dynamic.dp;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/9/20
 * @since 1.0.0
 */
public class MaximumSubarray {

    //leetcode 53. Maximum Subarray
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * 超级经典的dp问题
     */
     public int maxSubArray(int[] nums) {
         int maxSum = Integer.MIN_VALUE;
         int endSum = 0;
         for(int i = 0; i < nums.length; i++){
             endSum = Math.max(nums[i], nums[i] + endSum);
             maxSum = Math.max(maxSum, endSum);
         }
         return maxSum;
     }
}
