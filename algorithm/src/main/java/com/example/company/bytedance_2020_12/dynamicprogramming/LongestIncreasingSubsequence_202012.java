package com.example.company.bytedance_2020_12.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence_202012 {

    /***
     *  300. Longest Increasing Subsequence
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     *
     * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     *
     *  
     *
     * Example 1:
     *
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Example 2:
     *
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     *
     * */

    /**
    * 第二类dp问题 d[i]取决于 d[0],d[1] .. d[i - 1]
    状态
    * d[i], 以i结尾包括i点在内的，最大严格递增长度
    状态转移
    * d[i] = max(d[j] + 1, if nums[i] > nums[j]) for j = 0,1 , ... ,i -1
    初始值
    * d[0] = 1
    返回值
    * d[i] i = 0 .... n - 1 中最大值
    */
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        Arrays.fill(d, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= i - 1;j++){
                if(nums[i] > nums[j]){
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        int longestValue = 0;
        for(int i = 0; i < d.length; i++){
            longestValue = Math.max(d[i], longestValue);
        }
        return longestValue;
    }
}
