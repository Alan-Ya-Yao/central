package com.example.algorithm.math;

/**
 * /**
 *
 * @ClassName: Hexadecimal
 * @description:
 * @author: pengyi
 * @create: 2021-04-23 23:03
 **/
public class Hexadecimal {

    /**
     *    405. Convert a Number to Hexadecimal
     *     Given an integer num, return a string representing its hexadecimal representation.
     *     For negative integers, two’s complement method is used.
     *     对于负整数，我们通常使用 补码运算 方法。
     *
     * All the letters in the answer string should be lowercase characters,
     * and there should not be any leading zeros in the answer except for the zero itself.

     * Example 1:
     *
     * Input: num = 26
     * Output: "1a"
     * Example 2:
     *
     * Input: num = -1
     * Output: "ffffffff"
     *
     * */
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        int remainder = 0;
        char[] convertHex = {'0', '1', '2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuffer sb = new StringBuffer();
        while(num != 0){
            remainder = num % 16;
            num = num  / 16;
            if(remainder < 0){
                remainder += 16;
            }
            char tmp = convertHex[remainder];
            sb.insert(0, tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Hexadecimal solution = new Hexadecimal();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
         int k = -1;//负数转无符号数
    }
}
