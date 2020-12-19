package com.example.preInterview_202012;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 */
public class HashMapPractice {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
//        map.compute('a', (key, value) -> {return value +=3;}); //会报NPE

        //没有这则为1，有则加2
        map.compute('a', (key, value) -> {return value == null? 1: value + 2;});
        System.out.println(map.get('a'));
        //
        map.compute('a', (key, value) -> {return value == null? 1: value + 2;});
        System.out.println(map.get('a'));
        //可以删除
        map.compute('a', (k, v) -> {return null;});
        if(map.isEmpty()){
            System.out.println("map is empty");
        }
    }

}
