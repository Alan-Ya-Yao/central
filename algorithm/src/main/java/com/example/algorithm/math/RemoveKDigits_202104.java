package com.example.algorithm.math;

/**
 * /**
 *
 * @ClassName: RemoveKDigits
 * @description:
 * @author: pengyi
 * @create: 2021-04-18 20:37
 **/
public class RemoveKDigits_202104 {

    /**
     *
     * 402. Remove K Digits
     * Given string num representing a non-negative integer num, and an integer k,
     * return the smallest possible integer after removing k digits from num.
     *
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
     **/

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k == 0 ){
            return num;
        }
        if(k >= num.length()){
            return "0";
        }
        int point = 0;
        StringBuffer sb = new StringBuffer(num);
        while(k != 0){
            //已经是最后一个点了
            if(point + 1 == num.length()){
                sb.deleteCharAt(point);
                k--;
            }else{
                if(sb.charAt(point) > sb.charAt(point + 1)){
                    sb.deleteCharAt(point);
                    k--;
                }else if(sb.charAt(point) < sb.charAt(point + 1)){
                    sb.deleteCharAt(point + 1);
                    k--;
                }else{
                    point++;
                }
            }
        }
        //remove leading zero
        return String.valueOf(Integer.valueOf(sb.toString()));
    }

    public static void main(String[] args) {
        RemoveKDigits_202104 solution = new RemoveKDigits_202104();
        solution.removeKdigits("10001", 4);
    }
}
