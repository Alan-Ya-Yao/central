package com.example.company.bytedance_2020_12.binarySearch;

public class FindFirstandLastPositionOfElementInSortedArray_2020_12 {

    /***
     *  34. Find First and Last Position of Element in Sorted Array
     *
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * Follow up: Could you write an algorithm with O(log n) runtime complexity?
     *
     *
     * **/

    public int[] searchRange(int[] nums, int target) {
        int firstIndex = firstPosition(nums, target);
        int lastIndex = lastPosition(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int firstPosition(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = (j - i) / 2 + i;
            if(nums[mid] == target){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        if(j + 1 > nums.length - 1){
            return -1;
        }
        return nums[j + 1] == target? j + 1: -1;
    }

    private int lastPosition(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = (j - i) / 2 + i;
            if(nums[mid] == target){
                i = mid + 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        if(i - 1 < 0){
            return -1;
        }
        return nums[i - 1] == target ? i - 1: -1;
    }
}
