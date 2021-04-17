package com.example.company.shopee_202104;

import java.util.Arrays;

/**
 * /**
 *
 * @ClassName: MaximumProduct
 * @description:
 * @author: pengyi
 * @create: 2021-04-15 17:34
 **/
public class MaximumProduct {

    /**
     *
     * 628. Maximum Product of Three Numbers
     * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
     * Input: nums = [1,2,3,4]
     * Output: 24
     **/

    /**
     * 题解 最大值 max1* max2 * max3, 或者 max1 * min2 * min1
     * */
    public int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        //排序即可解决
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[nums.length - 1] * nums[1] * nums[0]);
    }

}
