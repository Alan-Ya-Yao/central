package com.example.algorithm.twopointers;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/5/20
 * @since 1.0.0
 */
public class TrappingRainWater {


    /**
     * leetcode 42 Trapping Rain Water
     *
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     *
     * **/

    /**
     *  method one : brutal force , time complexity O(n ^ 2 )
     *  reference _ https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * **/
    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length == 0){
            return  result;
        }

        for(int i = 0; i < height.length; i++){

            int leftMax = 0, rightMax = 0;
            for(int j = i; j >= 0; j--){
                leftMax = Math.max(height[j], leftMax);
            }
            for(int j = i; j <= height.length - 1; j++){
                rightMax = Math.max(height[j], rightMax);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }

        return result;
    }


    /**
     * method two - two pointers
     * 采用双指针，优化计算过程，整体思路和brutal force是一样的
     * **/
    public int trap_two_pointers(int[] height) {

        int result = 0;
        if(height == null || height.length == 0){
            return  result;
        }

        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(i <= j){
            if(height[i] <= height[j]){
                if(height[i] >= leftMax){
                    leftMax = height[i];
                }else{
                    result += leftMax - height[i];
                }
                i++;
            }else{
                if(height[j] >= rightMax){
                    rightMax = height[j];
                }else{
                    result += rightMax - height[j];
                }
                j--;
            }
        }
        return result;
    }


}
