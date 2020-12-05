package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/30/20
 * @since 1.0.0
 *
 * leetcode 93 - Restore IP Addresses
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 *
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 */
public class RestoreIpAddress {

    /***
     *  leetcode 93 - Restore IP Addresses
     *
     * */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        //提前判断
        if(s == null || s.length() < 4){
            return result;
        }
        restorIpAddress_backtracking(s, tmp, result, 0);
        return result;
    }

    public static void restorIpAddress_backtracking(String s, List<String> tmp, List<String> result, int position){
        // 回溯结束调价
        if(tmp.size() == 4 ){
            if(position == s.length()){
               StringBuffer sbuffer = new StringBuffer();
               for(String stmp : tmp){
                   sbuffer.append(stmp + ".");
               }
               sbuffer.deleteCharAt(sbuffer.length() - 1);
               result.add(sbuffer.toString());
            }
            return;
        }
        for(int i = position; i <= s.length() - 1; i++){
            //子字符串
            String subS = s.substring(position, i + 1);
            //写法一
//            if( i- position + 1 <= 3 && 0 <= Integer.valueOf(subS) && Integer.valueOf(subS) <= 255 && !(subS.startsWith("0") && subS.length() > 1) ){
//                tmp.add(subS);
//                //开始回溯
//                restorIpAddress_backtracking(s, tmp, result, i + 1);
//                //移除tmp最后一个元素
//                tmp.remove(tmp.size() - 1);
//            }
            //写法二
            if(i - position + 1 > 3 || Integer.valueOf(subS) > 255 || (subS.startsWith("0") && subS.length() > 1)) {
                continue;
            }

            tmp.add(subS);
            restorIpAddress_backtracking(s, tmp, result, i + 1);
            tmp.remove(tmp.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        List<String>  result = restoreIpAddresses("25525511135");
        result.stream().forEach(System.out::println);
    }
}
