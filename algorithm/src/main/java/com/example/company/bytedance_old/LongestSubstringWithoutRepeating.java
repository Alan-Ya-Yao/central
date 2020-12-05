package com.example.company.bytedance_old;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/3/20
 * @since 1.0.0
 */
public class LongestSubstringWithoutRepeating {
    /**
     * leetcode 3 Longest Substring Without Repeating Characters - tags classic sliding windows
     *
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.length() == 0){
            return result;
        }
        int[] mem = new int[256];
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            mem[s.charAt(i)] += 1;
            while(mem[s.charAt(i)] >= 2){
                mem[s.charAt(l)] -=1;
                l++;
            }
            result = Math.max(result, i - l + 1);
        }
        return result;
    }
}
