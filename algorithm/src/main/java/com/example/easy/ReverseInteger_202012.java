package com.example.easy;

public class ReverseInteger_202012 {
    /**
     * 7. Reverse Integer
     *
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: x = 123
     * Output: 321
     * Example 2:
     *
     * Input: x = -123
     * Output: -321
     * */
    public int reverse(int x) {
        int re = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            //注意防止移除
            if(re > Integer.MAX_VALUE / 10 || (re == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(re < Integer.MIN_VALUE / 10 || (re == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            re = re * 10 + pop;
        }
        return re;
    }

    public static void main(String[] args) {
        int[] status = new int[256];
        status['c']= 1;
        System.out.println();
    }
}
