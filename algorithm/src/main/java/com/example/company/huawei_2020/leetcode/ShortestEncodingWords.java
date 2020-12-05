package com.example.company.huawei_2020.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/14/20
 * @since 1.0.0
 */
public class ShortestEncodingWords {
    /**
     * leetcode 820. Short Encoding of Words
     * https://leetcode-cn.com/problems/short-encoding-of-words/
     */
    public static int minimumLengthEncoding(String[] words) {
            HashSet<String> hs = new HashSet<>();
            hs.addAll(Arrays.asList(words));
            for(String word : words){
                for(int i = 1; i < word.length(); i++){
                    hs.remove(word.substring(i));
                }
            }
            String tmp = hs.stream().collect(Collectors.joining("#"));
            System.out.println(tmp);
            return hs.stream().map(e -> {return e + "#";}).collect(Collectors.joining()).length();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }
}
