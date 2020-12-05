package com.example.algorithm.slidingwindow;

import java.util.Collections;
import java.util.HashMap;

/**
 * 〈159〉<br>
 * 〈159〉
 *
 * @author eleme
 * @create 4/24/20
 * @since 1.0.0
 *
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 *
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 *
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 *
 */
public class LengthOfLengthestSubstringTwoDistinct {

    /*   sliding window
         记住 删除滑动窗口最左边的值
    */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;
        for(;right < s.length();right++){
            hm.compute(s.charAt(right), (k, v) -> v == null? 1:v +1);
            while(hm.size() > 2){
                hm.compute(s.charAt(left), (k,v) -> v == 1? null:v - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println( lengthOfLongestSubstringTwoDistinct("abaccc"));
    }
}
