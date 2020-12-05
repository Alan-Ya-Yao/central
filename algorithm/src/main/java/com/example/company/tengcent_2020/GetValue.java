package com.example.company.tengcent_2020;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/11/20
 * @since 1.0.0
 */
public class GetValue {
    public static int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i = 0; i < gifts.length; i++){
            hs.compute(gifts[i], (key, value) -> {return value == null ? 1: value + 1;});
            if(hs.get(gifts[i]) > gifts.length / 2){
                return gifts[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getValue(new int[]{1, 2, 3, 2, 2}, 5));
    }
}
