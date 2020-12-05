package com.example.algorithm.dynamic.dp;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/9/20
 * @since 1.0.0
 */
public class LongestPalindromicString {

    //leetcode 5 longest palindromic subtring
    /**
    * Given a string s, find the longest palindromic substring in s.
    *  You may assume that the maximum length of s is 1000.
    *  Input: "babad"
    *  Output: "bab"
    *   Note: "aba" is also a valid answer.
     *   https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
    * */
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        String result = s.substring(0, 1);
        for(int len = 0; len <= s.length(); len ++ ){
            for(int i = 0; i + len < s.length(); i++){ //肯定 i + len < s.length()否者j就超界限
                int j = i + len;
                if(len == 0){
                    dp[i][j] = true;
                }else if(len == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true:false;
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] ? true: false;
                }
                if(dp[i][j] && len + 1 > result.length()){
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }



    //这个thinking 不能处理 "ccc"情况
    public static String longestPalindrome_dp2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] longestPalidromeLength = new int[s.length()];
        for(int i = 0; i < s.length();i++){
            if(i == 0){
                longestPalidromeLength[i] = 1;
                continue;
            }
            if(i == 1){
                if(s.charAt(i) == s.charAt(i - 1)){
                    longestPalidromeLength[i] = 2;
                }else{
                    longestPalidromeLength[i] = 1;
                }
                continue;
            }
            if(i - longestPalidromeLength[i - 1] > 0 && s.charAt(i - longestPalidromeLength[i - 1] - 1) == s.charAt(i)){
                    longestPalidromeLength[i] = longestPalidromeLength[i - 1] + 2;
                    continue;
            }
            if(s.charAt(i) == s.charAt(i - 1)){
                longestPalidromeLength[i] = 2;
                continue;
            }
            longestPalidromeLength[i] = 1;
        }
        int maxEnding = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length();i++){
            if(maxLength < longestPalidromeLength[i]){
                maxLength = longestPalidromeLength[i];
                maxEnding = i;
            }
        }
        return s.substring(maxEnding - maxLength + 1, maxEnding + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome_dp2("ccc"));
    }
}
