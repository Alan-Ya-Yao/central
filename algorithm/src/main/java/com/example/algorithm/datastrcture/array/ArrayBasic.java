package com.example.algorithm.datastrcture.array;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/2/20
 * @since 1.0.0
 */
public class ArrayBasic {

    /**
    * leetcode 674 longest continuous increasing subsequence
     *
    *  注意 - 这道题目是标准滑动窗口
     *
    * Given an unsorted array of integers,
    * find the length of longest continuous increasing subsequence (subarray).
    *
    * Input: [1,3,5,4,7]
      Output: 3
      Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
      Even though [1,3,5,7] is also an increasing subsequence,
     it's not a continuous one where 5 and 7 are separated by 4.
    **/
    public int findLengthOfLCIS(int[] nums) {

        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }

        int left = 0;
        for(int right = 0; right < nums.length; right ++){
            if(right == 0){
                result = 1;
                continue;
            }
            if(nums[right] > nums[right - 1]){
                result = Math.max(result, right - left + 1);
            }else{
                left = right;
            }
        }
        return result;
    }

    /***
     * leetcode 56 Merge Intervals
     * Given a collection of intervals, merge all overlapping intervals.
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     *
     * */
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[0][];
        if(intervals == null || intervals.length == 0){
            return result;
        }

        //step 1 - sort intervals
        Arrays.sort(intervals, (e1, e2) -> {return  e1[0] - e2[0];});

        // merge the intervals
        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(resList.get(resList.size() - 1)[1] < intervals[i][0]){
                resList.add(intervals[i]);
            }else{
                resList.get(resList.size() - 1)[1] = intervals[i][1];
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

    //leetcode 41 find first missing positive number
    //using hashset
    public int firstMissingPositiveI(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        int i = 1;
        for(; i <= nums.length;i++){
            if(!hs.contains(i)){
                return i;
            }
        }
        return i;
    }


    /**
     * leetcode 41 find first missing positive number
    *   Input: [1,2,0]
        Output: 3
        *
        Input: [3,4,-1,1]
        Output: 2
        *
        Input: [7,8,9,11,12]
        Output: 1

    * */
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] - 1 < nums.length  && nums[i] != i + 1
                    && nums[nums[i] - 1] !=nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     *  leetcode 54. Spiral Matrix
     *  Given a matrix of m x n elements (m rows, n columns),
     *  return all elements of the matrix in spiral order.
     *  Input:
     *  [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     *  ]
     *  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 ){
            return result;
        }
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        //
        int totalElements = matrix.length * matrix[0].length;
        int k = 0;
        while (k < totalElements) { // 每转一圈，k去判断totalElements
            //go left
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                k++;
            }
            if (++top > bottom) {
                break;
            }

            //go down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                k++;
            }
            if (--right < left) {
                break;
            }

            //go right
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                k++;
            }
            if (--bottom < top) {
                break;
            }

            // go up
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                k++;
            }
            if (++left> right) {
                break;
            }
        }
        return result;
    }
    /**
    *  剑指 61
     *  从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     *  ～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(nums);
    }
}
