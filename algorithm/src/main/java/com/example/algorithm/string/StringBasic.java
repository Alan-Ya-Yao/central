package com.example.algorithm.string;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/29/20
 * @since 1.0.0
 */
public class StringBasic {



    /**
     *  leetcode 14. Longest Common Prefix
     *  Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * example
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     * */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // how to find the common prefix for two strings 非常好的方法
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // divid & conquer method for longestCommonPrefix

    public static String longestCommonPrefix_I(String[] strs) {
        if(strs == null || strs.length == 0){
            return null;
        }
        return longestCommonPrefix_I(strs, 0, strs.length -1);
    }

    public static String longestCommonPrefix_I(String[] strs, int left, int right){
        if(left == right){
            return strs[left];
        }
        //注意这里是right + left 不是 right - left
        int mid = (right + left) / 2;
        String leftCommonPrefix = longestCommonPrefix_I(strs, left, mid);
        String rightCommonPrefix = longestCommonPrefix_I(strs, mid + 1, right);
        return longeestCommonPrefix_two_string(leftCommonPrefix, rightCommonPrefix);
    }

    //how to find the prefix
    public static String longeestCommonPrefix_two_string(String s1, String s2){

       int min = Math.min(s1.length(), s2.length());
       for(int i = 0; i < min; i++){
           if(s1.charAt(i) != s2.charAt(i)){
               return s1.substring(0, i);
           }
       }
       return s1.substring(0, min);
    }


    /**
    * leetcode 151 reverse words in a string
    * Given an input string, reverse the string word by word.
    * note
    * 1.Your reversed string should not contain leading or trailing spaces
    * 2.You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     * Input: " a good   example "
     * Output: "example good a"
    * */
    public static String reverseWords(String s) {
        String stmp = s.trim();
        stmp = reverseString(stmp);
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < stmp.length(); i++){
          if(stmp.charAt(i) == ' '){
              continue;
          }
          int j = i;
          while(j< stmp.length() && stmp.charAt(j) != ' '){
              j ++;
          }
          result.append(reverseString(stmp.substring(i,j)) + ' ');
          i = j;
        }
        return result.toString().trim();
    }

    public static String reverseString(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        int left = 0, right = s.length() - 1;
        char[] tmpArray = s.toCharArray();
        while(left < right){
            char tmp = tmpArray[left];
            tmpArray[left] = tmpArray[right];
            tmpArray[right] = tmp;
            left ++;
            right --;
        }
        return new String(tmpArray);
    }

    /**
     * leetcode 71 - simplify path
     *
     * Given an absolute path for a file (Unix-style), simplify it.
     * Or in other words, convert it to the canonical path.
     *
     * In a UNIX-style file system, a period . refers to the current directory.
     * Furthermore, a double period .. moves the directory up a level.
     *
     * Note that the returned canonical path must always begin with a slash /,
     * and there must be only a single slash / between two directory names. 
     * The last directory name (if it exists) must not end with a trailing /.
     * Also, the canonical path must be the shortest string representing the absolute path.
     *
     * Input: "/a//b////c/d//././/.."
     * Output: "/a/b/c
     *
     * Input: "/home//foo/"
     * Output: "/home/foo"
     * */
    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return null;
        }
        Stack<String> stack = new Stack<String>();
        String[] p = path.split("/");
        for(String tmp : p){
            if(!stack.isEmpty() && tmp.equals("..")){
                stack.pop();
            } else if(!tmp.equals(".") && !tmp.equals("") && !tmp.equals("..")){
                stack.push(tmp);
            }
        }
        List<String> list = new ArrayList<String>(stack);
        if(list.isEmpty()){
            return "/";
        }
//        StringBuilder sb = new StringBuilder();
//        for(String stmp : list){
//            sb.append("/" + stmp);
//        }
//        return sb.toString();
        // lambda
        return list.stream().map( e -> {return "/" + e;}).collect(Collectors.joining());
    }


    /**
     *  leetcode 6 ZigZag Conversion
     *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     *  (you may want to display this pattern in a fixed font for better legibility)
     *  P   A   H   N
     *  A P L S I I G
     *  Y   I   R
     *  And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * */
    //采用模拟算法
    public static String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        ArrayList<StringBuffer> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++ ){
            result.add(new StringBuffer());
        }
        int position = 0; // position走到 0, 或者 numRows - 1 的时候，颠倒行走方向
        int direction = -1;
        for(int i = 0; i < s.length();i++){
           result.get(position).append(s.charAt(i));
           if(position == 0 || position == numRows - 1){
               direction = - direction;
           }
           position += direction;
        }
        return result.stream().collect(Collectors.joining());
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
