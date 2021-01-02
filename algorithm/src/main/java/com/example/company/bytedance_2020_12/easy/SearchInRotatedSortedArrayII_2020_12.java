package com.example.company.bytedance_2020_12.easy;

public class SearchInRotatedSortedArrayII_2020_12 {

    /**
     * 对 nums[right] == nums[mid]特殊处理，right --,之后重新进行二分法
     *
     * 81. Search in Rotated Sorted Array II
     * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     *
     */
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        //采用闭区间
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return true;
            }
            //一直减到不想等
            // while(right >= mid && nums[mid] == nums[right]){
            //     right --;
            // }
            // if(right < mid){
            //     continue;
            // }
            //相同则跳过，重新计算
            if(nums[mid] == nums[right]){
                right --;
                continue;
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
        return false;
    }
}
