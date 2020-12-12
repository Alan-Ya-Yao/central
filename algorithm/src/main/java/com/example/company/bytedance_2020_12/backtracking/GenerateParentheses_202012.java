package com.example.company.bytedance_2020_12.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_202012 {

    /**
     * lt 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *  Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * */
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        generateParenthesis_backtracking(n, 0, 0, new StringBuffer(), result);
        return result;
    }

    private void generateParenthesis_backtracking(int n, int left, int right, StringBuffer sb, List<String> result){
        if(sb.length() == n * 2){
            result.add(sb.toString());
            return;
        }
        if(right > left){
            return;
        }
        if(left < n){
            generateParenthesis_backtracking(n, left + 1, right, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < n){
            generateParenthesis_backtracking(n, left, right + 1, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses_202012 solution = new GenerateParentheses_202012();
        solution.generateParenthesis(3);
    }
}
