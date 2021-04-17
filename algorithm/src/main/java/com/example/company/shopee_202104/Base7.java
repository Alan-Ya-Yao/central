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
        int absNum = Math.abs(num);
        StringBuilder sb = new StringBuilder();// not thread safe
        while(absNum != 0){
            sb.insert(0, absNum%7);
            absNum = absNum/7;
        }
        if(num < 0){
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
    }
}
