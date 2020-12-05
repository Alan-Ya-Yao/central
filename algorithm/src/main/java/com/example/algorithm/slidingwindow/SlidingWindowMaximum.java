package com.example.algorithm.slidingwindow;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum {

    /**
     * 暴力求解法
     * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
     */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int [0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int left = 0;
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        for(int right = 0; right < nums.length; right ++){
            //添加元素
            map.compute(nums[right], (key, value) -> value == null ? 1:value+1);
            //滑动窗口已经满足
            if(right - left + 1 == k){
                result[i] = Collections.max(map.keySet());
                //滑动窗尾元素移除
                map.compute(nums[left], (key, value) -> {
                    return value -= 1;
                });
                left++;
                i++;
            }
            map.entrySet().removeIf( e -> {return e.getValue() == 0;});

        }
        return result;
    }
    /*
    * 采用deque解决问题
    * 保证deque的首元素是最大值
    * 保证deque永远从首元素递减
    * */
    public static int[] maxSlidingWindowII(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int i = 0;
        for(int right = 0; right < nums.length; right ++){
            //保证deque从头到为递减
            while(!deque.isEmpty() && deque.peekLast() < nums[right]){
                deque.removeLast();
            }
            //元素入deque的尾巴
            deque.add(nums[right]);
            //满足window长度
            if(right - left + 1 == k){
                res[i++] = deque.peekFirst();
                //开始移除window的left值
                if(deque.peekFirst() == nums[left]){
                    deque.removeFirst();
                }
                left ++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        maxSlidingWindowII(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
