package com.example.algorithm.slidingwindow;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/28/20
 * @since 1.0.0
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int maxLength = 0;
        int left = 0;
        int[] array = new int[256];
        for(int right = 0; right < s.length(); right++){
            array[s.charAt(right)]++;
            while(array[s.charAt(right)] >= 2){
                array[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
