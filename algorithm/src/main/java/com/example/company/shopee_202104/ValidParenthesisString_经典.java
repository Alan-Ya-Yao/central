package com.example.company.shopee_202104;

import java.util.HashMap;
import java.util.Stack;

/**
 * /**
 *
 * @ClassName: ValidParenthesisString
 * @description:
 * @author: pengyi
 * @create: 2021-04-17 16:58
 **/
public class ValidParenthesisString_经典 {

    /**
     * 678. Valid Parenthesis String
     *Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     *
     * The following rules define a valid string:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "(*)"
     * Output: true
     * Example 3:
     *
     * Input: s = "(*))"
     * Output: true
     *
     * */


    /**
     *  leetcode 20 Valid Parentheses
     *
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     *
     * */
    public static boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        HashMap<Character, Character> hmap = new HashMap<Character, Character>();
        hmap.put(')','(');
        hmap.put(']','[');
        hmap.put('}','{');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(hmap.values().contains(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() || hmap.get(s.charAt(i)) != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 678. Valid Parenthesis String
     * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
     *
     * The following rules define a valid string:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "(*)"
     * Output: true
     * Example 3:
     *
     * Input: s = "(*))"
     * Output: true
     *
     * */

    /**
     *  超级经典的递归调用
     *
     * */
    public boolean checkValidString(String s) {
        return checkValidString_dfs(s, 0, 0);
    }

    private boolean checkValidString_dfs(String s, int total, int position){
        if(position == s.length()){
            return total == 0? true:false;
        }
        if(total < 0){
            return false;
        }
        if(s.charAt(position) == '('){
            return checkValidString_dfs(s, total + 1, position + 1);
        }else if(s.charAt(position) == ')'){
            return checkValidString_dfs(s, total - 1, position + 1);
        }else{
            return checkValidString_dfs(s, total + 1, position + 1)
                    || checkValidString_dfs(s, total, position + 1)
                    || checkValidString_dfs(s, total - 1, position - 1);
        }
    }




    /**
     * 补充一道自定义 question
     *  没有* 判断是否是valid string
     * */
    public boolean checkValidString_common(String s){
        return checkValidString_common_dfs(s, 0, 0);
    }

    private boolean checkValidString_common_dfs(String s, int total, int position){
        if(position == s.length()){
            return total == 0 ? true:false;
        }
        if(s.charAt(position) == '('){
            return checkValidString_common_dfs(s, total + 1, position + 1);
        }else{ // == ")"
            total -= 1;
            if(total < 0){
                return false;
            }
            return checkValidString_common_dfs(s,total, position + 1);
        }
    }

    public static void main(String[] args) {
        ValidParenthesisString_经典 solution = new ValidParenthesisString_经典();
        System.out.println(solution.checkValidString_common("(()())("));
        System.out.println(solution.checkValidString("(*))"));
    }

}
