package com.example.company.coupang_2020_12;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber_202012 {

    /**
     *  利用string 排序, 拼接在一起
     *  179. Largest Number
     *  Given a list of non-negative integers nums, arrange them such that they form the largest number.
     *
     * Note: The result may be very large, so you need to return a string instead of an integer.
     *
     *
     * Example 1:
     *
     * Input: nums = [10,2]
     * Output: "210"
     * Example 2:
     *
     * Input: nums = [3,30,34,5,9]
     * Output: "9534330"
     *
     **/
    /**
     *  利用string 排序, 拼接在一起
     **/
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        //turn into string array
        String[] numsString = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsString[i] = String.valueOf(nums[i]);
        }
        //排序 the numsString
        // if s1 + s2 > s2 + S1, S1 排在 S2 前面
        Arrays.sort(numsString, (x, y )->{
            String tmp1 = x + y;
            String tmp2 = y + x;
            return - tmp1.compareTo(tmp2);
        });

        if(Integer.valueOf(numsString[0]) == 0){
            return "0";
        }

        return Arrays.stream(numsString).collect(Collectors.joining());
    }
}
