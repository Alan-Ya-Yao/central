package com.example.algorithm.binarysearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/2/20
 * @since 1.0.0
 *
 * Leetcode 33 Search in rotated sorted array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {


    /**
     *  二分搜索关键每次排除一半的元素
     * **/
    public int search(int[] nums, int target) {

        int result = -1;
        if(nums == null || nums.length == 0){
            return result;
        }

        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = (right + left) / 2;
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
                } else{
                    left = mid + 1;
                }
            }
        }
        return - 1;
    }

}
