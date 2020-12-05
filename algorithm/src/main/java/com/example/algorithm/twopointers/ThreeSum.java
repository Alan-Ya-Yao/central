package com.example.algorithm.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/28/20
 * @since 1.0.0
 *
 * leetcode 15 3 sum
 * Given an array nums of n integers, are there elements a, b, c in nums
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return result;
        }
        //排序
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            //如果当前数字大于0, 则三数之和肯定大于0，结束循环
            if(nums[i] > 0) {break;}
            //如果nums[i - 1]与 nums[i] 相同，去重，跳过循环
            if(i > 0 && nums[i - 1] == nums[i]){continue;}
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // left去重
                    while(left < right && nums[left] == nums[left + 1]){
                            left ++;
                    }
                    //right去重
                    while(left < right && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if(sum < 0){
                    left ++;
                }else if(sum > 0){
                    right --;

                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       result.add(Arrays.asList(1, 2, 3));
       result.add(Arrays.asList(4, 5, 6));
       result.stream().forEach(System.out::println);
    }
}
