package com.example.algorithm.binarysearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/24/20
 * @since 1.0.0
 */
public class BinarySearchBasic {

    /**
     * 给定一个有序的数组，查找value是否在数组中，不存在返回-1。
     * */
    public static int binarySearch(int[] nums, int value){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == value){
                return mid;
            }
            if(value > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 34. Find First and Last Position of Element in Sorted Array
     *
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * If the target is not found in the array, return [-1, -1].
     *
     * example # 1
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     *
     * Example # 2
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * */
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        int leftmost = -1, rightmost = -1;
        //寻找leftmost
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target){
                r = mid - 1;
            }else{
               l = mid + 1;
            }
        }
        if(l > nums.length - 1){
            leftmost = -1;
        }else{
            leftmost = nums[l] == target? l:-1;
        }

        //寻找rightmost
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        if(r < 0){
            rightmost = -1;
        }else{
            rightmost = nums[r] == target? r:-1;
        }
        return new int[]{leftmost, rightmost};
    }


    /**
     * 287. Find the Duplicate Number
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
     *
     * Input: [1,3,4,2,2]
     * Output: 2
     *
     * Input: [3,1,3,4,2]
     * Output: 3
     * */

    public static int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int accumulatedSum = 0;
            for(int i = 0; i <= nums.length - 1; i++){
                if(nums[i] <= mid){
                    accumulatedSum += 1;
                }
            }
            if(accumulatedSum <= mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7, 8, 9, 11};
        System.out.println(binarySearch(nums, 5));

        int[] nums2 = {5,7,7,8,8,10};

//        searchRange(new int[]{1}, 0);
        findDuplicate(new int[]{1,3,4,2,2});

    }
}
