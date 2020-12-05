package com.example.algorithm.slidingwindow;

import java.util.HashMap;

/**
 * 〈3〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/24/20
 * @since 1.0.0
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * "abcabcbb" -> 3
 */

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) {return 0;}
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1); //需要要有这个Math.max. abba，走到第二个a的时候，left会后退
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("abba");
        System.out.println(length);
    }
}
