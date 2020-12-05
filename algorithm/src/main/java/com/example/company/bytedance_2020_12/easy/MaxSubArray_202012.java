package com.example.company.bytedance_2020_12.easy;

public class MaxSubArray_202012 {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Follow up: If you have figured out the O(n) solution,
     * try coding another solution using the divide and conquer approach, which is more subtle.
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * */
    public int maxSubArray(int[] nums) {
        int[] s = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                s[i] = nums[i];
            }else{
                if(s[i - 1] > 0){
                    s[i] = nums[i] + s[i - 1];
                }else{
                    s[i] = nums[i];
                }
            }
            result = Math.max(result, s[i]);
        }
        return result;
    }
}
