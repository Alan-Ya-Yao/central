package com.example.practice;

import java.util.*;

/**
 * /**
 *
 * @ClassName: ShuffleCollections
 * @description:
 * @author: pengyi
 * @create: 2021-06-11 22:30
 **/
public class ShuffleCollections {


    public static void main(String[] args) {

        /**
         * shuffle a collection
         * */
        Set<String> st = new HashSet<String>();
        st.add("alan");
        st.add("winkie");
        st.add("YUAN");
        st.add("daniel");
        for(int i = 0; i < 3; i ++){
            List<String> ls = new ArrayList<>(st);
            Collections.shuffle(ls);
            for(String s : ls){
                System.out.print( s + " ");
            }
            System.out.println("- - - - ");
        }

    }
}
