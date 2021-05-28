package com.example.algorithm.recursion.recursion_classic_202104;



/**
 * /**
 *
 * @ClassName: DecodeString
 * @description:
 * @author: pengyi
 * @create: 2021-04-16 15:33
 **/
public class DecodeString {

    /**
     *  leetcode 394
     *       * Input: s = "2[abc]3[cd]ef"
     *      * Output: "abcabccdcdcdef"
     *
     * 强力 reference https://cloud.tencent.com/developer/article/1489554
     * */
    /**
     *  只有四种 字符
     *  字符，直接入栈
     *  【 开始递归
     *   】 结束递归
     *   数字：表明递归后的后置处理
     *
     *   经典的地方: 递归前后置处理
     * */
    public String decodeString(String s) {
        return decodeString_dfs(s);
    }
    int ptr = 0;
    private String decodeString_dfs(String s){
        StringBuffer sb = new StringBuffer();
        StringBuffer sub = new StringBuffer();
        int repeatNumber = 0;
        while(ptr != s.length()){
            if(Character.isAlphabetic(s.charAt(ptr))){
                sb.append(s.charAt(ptr));
                ptr++;
            }else if(s.charAt(ptr) == '['){
                ptr++;
                sub = new StringBuffer(decodeString_dfs(s));
            }else if(Character.isDigit(s.charAt(ptr))){
                repeatNumber = repeatNumber * 10 + Character.getNumericValue(s.charAt(ptr));
                ptr++;
            }
            else{ //如果等于']'
                StringBuffer midResult = new StringBuffer();
                while (repeatNumber != 0){
                    midResult.append(sub);
                    repeatNumber --;
                }
                ptr++;
            }
        }
        return sb.append(sub).toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String input = "3[a]2[bc]";
        System.out.println(solution.decodeString(input));
    }
}
