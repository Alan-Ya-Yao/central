package com.example.grammer.common;

import java.util.List;

public class CommonUtils {

    public static <T> void printList(List<T> list){
        for(T t: list){
            System.out.print(t +", ");
        }
        System.out.println();
    }
}
