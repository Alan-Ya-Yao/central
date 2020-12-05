package com.example.company.bytedance_2020_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yuan.yao07@ele.me
 * @create 11/28/20
 * @since 1.0.0
 */
public class maximumSwap {

    /**
     *  leetcode 670 maximum swap https://leetcode-cn.com/problems/maximum-swap/
     *
     *  牛逼 reference https://blog.csdn.net/magicbean2/article/details/79203146
     *
     *  Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
     *
     * Example 1:
     * Input: 2736
     * Output: 7236
     * Explanation: Swap the number 2 and the number 7.
     * Example 2:
     * Input: 9973
     * Output: 9973
     * Explanation: No swap.
     *
     * 解题思路 - 寻找逆序对
     * */
    public static int maximumSwap(int num) {
        if(num == 0){
            return 0;
        }
        int[] intArray = convertIntToArray(num);
        int leftSwap = -1, rightSwap = -1;
        int maxRightViewIndex = intArray.length - 1;
        for(int i = intArray.length - 1; i >= 0; i--){
            if(intArray[i] < intArray[maxRightViewIndex]){
                leftSwap = i;
                rightSwap = maxRightViewIndex;
            }
            if(intArray[i] > intArray[maxRightViewIndex]){
                maxRightViewIndex = i;
            }
        }

        swapTwoIndex(intArray, leftSwap, rightSwap);

        StringBuffer sb = new StringBuffer();
        for(int in: intArray){
            sb.append(in);
        }

        return Integer.valueOf(sb.toString());
    }

    private static void swapTwoIndex(int[] num, int left, int right){
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
    }

    private static int[] convertIntToArray(int num){
        List<Integer> res = new ArrayList<>();
        while(num != 0){
            res.add(0,num % 10);
            num = num / 10;
        }
        return res.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        int num = 98368;
//        int[] nums = convertIntToArray(num);
//        swapTwoIndex(nums, 0,3);
//        System.out.println(Arrays.toString(nums));
        System.out.println(maximumSwap(num));
    }
}
