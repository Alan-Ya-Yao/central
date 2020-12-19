package com.example.company.bytedance_2020_12.easy;

import java.util.Stack;

public class ValidParentheses_202012 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c.equals('（') || c.equals('{') || c.equals('[')){
                stack.push(c);
            }else  if(c.equals(')') && !stack.isEmpty() &&stack.peek().equals('(')){
                stack.pop();
            } else  if(c.equals('}') && !stack.isEmpty() && stack.peek().equals('{')){
                stack.pop();
            } else if(c.equals(']') && !stack.isEmpty()&& stack.peek().equals('[')){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
