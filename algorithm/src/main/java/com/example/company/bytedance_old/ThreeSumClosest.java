package com.example.company.bytedance_old;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/8/20
 * @since 1.0.0
 */
public class ThreeSumClosest {

    /**
     *  leetcode 16
     *  Given an array nums of n integers and an integer target,
     *  find three integers in nums such that the sum is closest to target.
     *  Return the sum of the three integers.
     *  You may assume that each input would have exactly one solution.
     *
     *  Input: nums = [-1,2,1,-4], target = 1
     *  Output: 2
     *  Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //先给一个fake值
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i ++){
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                result = Math.abs(tmp - target) < Math.abs(result - target)? tmp : result;
                if(tmp >= target){
                    r--;
                }else{
                    l ++;
                }
            }
        }
        return result;
    }


}
