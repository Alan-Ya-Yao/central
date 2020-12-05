package com.example.algorithm.slidingwindow;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 *
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 * Input:
 * s = "ABAB", k = 2
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 *
 * Input:
 * s = "AABABBA", k = 1
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 */
public class LongestRepeatingCharacterReplacement {

    /* 采用滑动窗口 如何让滑动窗口满足条件
    * */
    public int characterReplacement(String s, int k) {
        if(s == null){
            return 0;
        }
        int[] map = new int[26];
        int left = 0;
        int charMax = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right ++){
            int index = s.charAt(right) - 'A';
            map[index] ++;
            charMax = Math.max(charMax, map[index]);
            if(right - left + 1 > charMax + k){
                map[s.charAt(left) - 'A']--;
                left ++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}
