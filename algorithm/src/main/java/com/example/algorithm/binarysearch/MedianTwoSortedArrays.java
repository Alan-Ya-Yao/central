package com.example.algorithm.binarysearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/9/20
 * @since 1.0.0
 */
public class MedianTwoSortedArrays {


    /**
     *  leetcode 4 median of two sorted arrays
     *
     *  There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * example 1
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     *
     * example 2
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     *
     * **/

    /**思路 O(log(m + n)) 采用binary search 方法
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }

    public int findKthNumber(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length, length2 = nums2.length;
        int start1 = 0, start2 = 0;
        while(k != 1){

        }
        return 0;
    }

    public double findMedianSortedArrays_brutal_force(int[] nums, int[] nums2){
        int total = nums.length + nums2.length;
        int mid = total / 2;
        int i = 0, j = 0;
        return 0.0;
    }
}
