package com.example.grammer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/8/20
 * @since 1.0.0
 */
public class ArrayListPractice {
        public static void main(String[] args) {
            LinkedList<Integer> lis = new LinkedList<>();
            lis.add(1);
            lis.add(2);
            lis.add(3);
            for(int i = 0; i < lis.size();i++){
                System.out.println(lis.get(i));
            }
    }
}
