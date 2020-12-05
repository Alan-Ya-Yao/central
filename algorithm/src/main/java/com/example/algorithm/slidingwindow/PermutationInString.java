package com.example.algorithm.slidingwindow;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *  
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
    /*
    *
    * */
    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0){
            return true;
        }
        int[] array_s1 = new int[256];
        int[] array_s2 = new int[256];
        for(int i = 0; i < s1.length(); i++){
            array_s1[s1.charAt(i)]++;
        }
        int left = 0;
        for(int right = 0; right < s2.length(); right ++){
            array_s2[s2.charAt(right)] ++;
            if(right - left + 1 == s1.length()){
                if(Arrays.equals(array_s1 , array_s2)){
                    return true;
                }
                array_s2[s2.charAt(left)]--;
                left ++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
