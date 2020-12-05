package com.example.company.bytedance;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/24/20
 * @since 1.0.0
 */
public class FirstCharRepeatOneTime {
    /*
    * leetcode chinese version 50
    * 第一个只出现一次的字符
    *
    * s = "abaccdeff"
    *  返回 "b"

    * s = ""
    * 返回 " "
    * */

    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()){
            map.compute(c, (k, v) -> {return v == null? 1: v+1;});
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
