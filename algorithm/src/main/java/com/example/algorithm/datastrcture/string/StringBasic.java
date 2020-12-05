package com.example.algorithm.datastrcture.string;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/27/20
 * @since 1.0.0
 */
public class StringBasic {

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例:
     *
     * s = "abaccdeff"
     * 返回 "b"
     *
     * s = ""
     * 返回 " "
     *
     * */


    /**
     *
     *  leetcode 8 String to Integer (atoi)
     *  Example 1:
     *
     * Input: "42"
     * Output: 42
     * Example 2:
     *
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     *              Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     *
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * Example 4:
     *
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     *              digit or a +/- sign. Therefore no valid conversion could be performed.
     *
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     *              Thefore INT_MIN (−231) is returned.
     *
     * */

    public static int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        if(index == str.length()){
            return 0;
        }
        boolean isPositive = true;
        if(str.charAt(index) == '-'){
            isPositive = false;
            index++;
        }else if(str.charAt(index) == '+'){
            isPositive = true;
            index++;
        }
        int initial = 0;
        for(int i = index; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return  isPositive? initial: - initial;
            }
            if(initial >= (Integer.MAX_VALUE - Character.getNumericValue(str.charAt(i))) / 10){
                return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            initial = initial * 10 + Character.getNumericValue(str.charAt(i));
        }
        return isPositive? initial:-initial;
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("1"));
        String string = "";
        System.out.println(string.isEmpty());
    }

}
