package com.example.company.bytedance_2020_12;

public class FindMin {
    /*
     * lc 153. Find Minimum in Rotated Sorted Array
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     *
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * */


    /**
     * 不建议采用闭区间 - 采用开区间，因为最小值可能在范围内
     * 左闭，右开
     */
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }


    public static void main(String[] args) {

        System.out.println("111");
    }
}
