package com.example.company.shopee_202104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * /**
 *
 * @ClassName: RemoveKDigits
 * @description:
 * @author: pengyi
 * @create: 2021-04-18 00:35
 **/
public class RemoveKDigits {

    /***
     * 402. Remove K Digits
     * Given string num representing a non-negative integer num, and an integer k,
     * return the smallest possible integer after removing k digits from num.
     *
     *
     * Example 1:
     *
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     *
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     *
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     *
     * */

    /**
     *  数学技巧在里面  2axx，永远小于 2byy，因为a < b，建议保持字符串递增
     *
     * */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if(num == null || num.length() <= k){
            return "0";
        }
        return null;
    }

    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String num = "10001";
        int k = 4;
        System.out.println(solution.removeKdigits(num, k));
    }
}
