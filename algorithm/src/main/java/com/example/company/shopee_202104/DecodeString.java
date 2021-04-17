package com.example.company.shopee_202104;

import java.util.ArrayList;
import java.util.List;

/**
 * /**
 *
 * @ClassName: DecodeString
 * @description:
 * @author: pengyi
 * @create: 2021-04-15 20:39
 **/
public class DecodeString {

    /**
     *394. Decode String
     * Given an encoded string, return its decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
     * For example, there won't be input like 3a or 2[4].
     * Example 1:
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     * Example 2:
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     * Example 3:
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     * Example 4:
     * Input: s = "abc3[cd]xyz"
     * Output: "abccdcdcdxyz"
     */

    /**
     * 采用栈模拟 递归
     */
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //家里栈
        List<String> queue = new ArrayList<String>();
        //采用while循环更好一些,因为char之后字母，[, ], 数字，四种情况
        int ptr = 0;
        while (ptr != s.length()) {
            if (Character.isAlphabetic(s.charAt(ptr)) || s.charAt(ptr) == '[') {
                queue.add(String.valueOf(s.charAt(ptr)));
                ptr++;
            } else if (s.charAt(ptr) == ']') {
                //开始出栈
                List<String> tmp = new ArrayList<>();
                while (!queue.get(queue.size() - 1).equalsIgnoreCase("[")) {
                    tmp.add(queue.get(queue.size() - 1));
                    queue.remove(queue.size() - 1);
                }
                //（注意tmp 是相反的）
                //去掉"【"
                queue.remove(queue.size() - 1);
                //数字重复，拿出数字，去掉数字
                Integer repeatNumber = Integer.valueOf(queue.get(queue.size() - 1));
                queue.remove(queue.size() - 1);
                StringBuffer sb = new StringBuffer();
                while (repeatNumber != 0) {
                    for (int i = 0; i < tmp.size(); i++) {
                        sb.append(tmp.get(tmp.size() - 1 - i)); //要反则取数
                    }
                    repeatNumber--;
                }
                queue.add(sb.toString());
                ptr++;
            } else {
                //数字的话，先解析
                int total = 0;
                while (Character.isDigit(s.charAt(ptr))) {
                    total = total * 10 + Character.getNumericValue(s.charAt(ptr));
                    ptr++;
                }
                queue.add(String.valueOf(total));
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < queue.size(); i++) {
            result.append(queue.get(i));
        }
        return result.toString();
    }

    /**
     * 采用递归方式
     */

    public String decodeString_recursion(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[]{res.toString()};
    }


    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}
