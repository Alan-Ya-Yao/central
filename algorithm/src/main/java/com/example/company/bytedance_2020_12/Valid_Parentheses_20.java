package com.example.company.bytedance_2020_12;

import java.util.Stack;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yuan.yao07@ele.me
 * @create 12/1/20
 * @since 1.0.0
 */
public class Valid_Parentheses_20 {


    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * Example 4:
     *
     * Input: s = "([)]"
     * Output: false
     * Example 5:
     *
     * Input: s = "{[]}"
     * Output: true
     * */
    public static boolean isValid(String s) {
        if(s == null || s.length() == 1){
            return false;
        }
        Stack<Character> st= new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp == '(' || tmp == '{' || tmp == '['){
                st.push(tmp);
            }else{
                if(st.isEmpty()){
                    return false;
                } else if(tmp == ')' && st.peek() == '('){
                    st.pop();
                }else if(tmp == '}' && st.peek() == '{'){
                    st.pop();
                } else if(tmp == ']' && st.peek() == '['){
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("){"));
    }
}
