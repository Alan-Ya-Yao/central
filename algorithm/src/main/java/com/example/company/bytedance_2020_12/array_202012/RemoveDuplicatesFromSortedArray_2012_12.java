package com.example.company.bytedance_2020_12.array_202012;

public class RemoveDuplicatesFromSortedArray_2012_12 {
    /**
     *
     * leetcode 26. Remove Duplicates from Sorted Array
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4]
     * Explanation: Your function should return length = 5,
     * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
     * It doesn't matter what values are set beyond the returned length.
     *
     * */

    /**
     * 采用双指针，保证nums 前length的值都唯一
     *
     * 双指针，隔离出3个区域，弄清楚3个区域的关系
     * 0 - i 的区间
     * */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 1;
        for(; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
