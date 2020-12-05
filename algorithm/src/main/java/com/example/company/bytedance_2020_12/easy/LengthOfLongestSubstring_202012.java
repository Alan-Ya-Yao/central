package com.example.company.bytedance_2020_12.easy;

public class LengthOfLongestSubstring_202012 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s == "" || s.length() == 0){
            return 0;
        }
        int[] status = new int[256];
        int left = 0, right = 0;
        int result = Integer.MIN_VALUE;
        for(; right <= s.length() - 1;right++){
            while(status[s.charAt(right)] == 1){
                status[s.charAt(left)] = 0;
                left ++;
            }
            status[s.charAt(right)] = 1;
            result = Math.max(result, right - left + 1);

        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
