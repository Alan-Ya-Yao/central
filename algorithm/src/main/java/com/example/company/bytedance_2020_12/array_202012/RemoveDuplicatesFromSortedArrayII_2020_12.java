package com.example.company.bytedance_2020_12.array_202012;

public class RemoveDuplicatesFromSortedArrayII_2020_12 {

    /**
     * 80. Remove Duplicates from Sorted Array II
     * */
    /**
     * easy two pointer 双指针，3个区域
     * 简化版本的滑动窗口问题
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0, j = 1;
        int duplicatesNumber = 0;
        // [0, i]都是符合条件的， [i, j]已经遍历过的，[j, length] 还未遍历过
        for(;j < nums.length;j++){
            if(nums[i] != nums[j]){ //没有重复
                duplicatesNumber = 0;
                //边界向左边移动
                i++;
                nums[i] = nums[j];
            }else if(nums[i] == nums[j] && duplicatesNumber == 0){
                duplicatesNumber++;
                //边界向左边移动
                i++;
                nums[i] = nums[j];
            }else{
                continue;
            }
        }
        return i+1;
    }
}
