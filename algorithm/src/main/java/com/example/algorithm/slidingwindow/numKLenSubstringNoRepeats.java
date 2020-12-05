package com.example.algorithm.slidingwindow;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/27/20
 * @since 1.0.0
 *
 * leetcode 1100
 *
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 * Example 1:
 *
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 *
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation:
 * Notice K can be larger than the length of S. In this case is not possible to find any substring.
 *
 */
public class numKLenSubstringNoRepeats {

    /*
    * 一看substring 采用滑动窗口
    * 窗口左边移动条件：1.出现重复character，2.窗口长度大于K
    * */
    public static int numKLenSubstrNoRepeats(String S, int K) {
        if(S == null|| K > S.length()){
            return 0;
        }
        int[] array = new int[256];
        int left = 0;
        int result = 0;
        for(int right = 0; right < S.length(); right++){
         //直接往窗口里添加
            array[S.charAt(right)]++;
            //滑动窗口满足条件
            if(array[S.charAt(right)] == 1 && right - left + 1 == K) {
                result++;
            }
            //调整left of window使window满足条件
            while(array[S.charAt(right)]== 2 || right - left + 1 == K){
                array[S.charAt(left)] --;
                left ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
}
