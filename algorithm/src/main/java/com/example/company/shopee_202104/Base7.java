package com.example.company.shopee_202104;

/**
 * /**
 *
 * @ClassName: Base7
 * @description:
 * @author: pengyi
 * @create: 2021-04-15 19:29
 **/
public class Base7 {

    /**
     * 504. Base 7
     *Given an integer, return its base 7 string representation.
     *
     * Example 1:
     * Input: 100
     * Output: "202"
     * Example 2:
     * Input: -7
     * Output: "-10"
     * */
    public static String convertToBase7(int num) {
        if(num == 0){
            return "0";
        }

        StringBuffer result = new StringBuffer();
        int carry = Math.abs(num);
        while(carry != 0){
            result.insert(0, carry % 7);
            carry = carry / 7;
        }
        return num > 0 ? result.toString() : "-" + result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
}
