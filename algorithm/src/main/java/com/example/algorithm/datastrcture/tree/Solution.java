package com.example.algorithm.datastrcture.tree;

import java.util.Arrays;

/**
 * /**
 *
 * @ClassName: Solution
 * @description:
 * @author: pengyi
 * @create: 2021-04-26 18:56
 **/
public class Solution {

    public int[] maxLengthIncr(int [] num){
        if(num == null || num.length == 0){
            return num;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < num.length;i++){
            for(int j = i + 1; j < num.length; j++){
                if(num[j] > num[j - 1]){
                    if(j - i > end - start){
                        start = i;
                        end = j;
                    }
                }else{
                    break;
                }
            }
        }

        //build result
        int[] result = new int[end - start + 1];
        int j = 0;
        for(int i = start; i < end ;i++){
            result[j] = num[i];
            j++;
        }
        return result;
    }
    public static void main(String[]args){
        int[] num = new int[]{1,2,3,5,2,1,3,44,65,76,43,23};
        Solution solution = new Solution();
        int[] result = solution.maxLengthIncr(num);
        Arrays.stream(result).forEach(e -> System.out.println(e));
    }
}
