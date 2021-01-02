package com.example.company.bytedance_2020_12.review_202012;

public class SearchInRotatedSortedArray_2012_12 {
    /**
     * 33. Search in Rotated Sorted Array
     * binary search
     * 题目已经假设 all elment unique
     **/
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        //采用闭区间
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
