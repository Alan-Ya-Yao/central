package com.example.company.shopee_202104;

/**
 * /**
 *
 * @ClassName: SubarraySumEqualsK
 * @description:
 * @author: pengyi
 * @create: 2021-04-18 01:04
 **/
public class SubarraySumEqualsK {

    /**
     * 560. Subarray Sum Equals K
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     *
     * Example 2:
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     *
     * 典型滑动窗口
     * 1.如何记录滑动窗口状态
     * 2.i,j 滑动过程描述,通常直接先加进去重要
     */
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int windowSum = 0;
        int left = 0, right = 0;
        int result = 0;
        for(;right < nums.length;right++){
            windowSum += nums[right];
            if(windowSum == k){
                result++;
            }else if(windowSum > k){
                while(windowSum >k){
                    windowSum -= nums[left];
                    left++;
                    if(windowSum == k && left <= right ){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        System.out.println( solution.subarraySum(new int[]{-1, -1, 1}, 0));
    }
}
