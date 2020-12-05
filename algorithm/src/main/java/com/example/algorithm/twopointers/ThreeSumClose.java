package com.example.algorithm.twopointers;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/29/20
 * @since 1.0.0
 *
 *
 * leetcode 16
 *
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 */
public class ThreeSumClose {

    // two pointes + sorting
    public static int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //找最接近的数，先给一个可能的结果
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length ; i ++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                // 更为接近target
                if(Math.abs(target - currentSum) < Math.abs(target - result)){
                    result = currentSum;
                }
                //和targe对比
                if(currentSum < target){
                    left ++;
                }else if(currentSum > target){
                    right --;
                }else {
                    return currentSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{0, 2, 1, -3}, 1);
    }
}
