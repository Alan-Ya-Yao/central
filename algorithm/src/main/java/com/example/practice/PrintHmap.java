package com.example.practice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * /**
 *
 * @ClassName: PrintHmap
 * @description:
 * @author: pengyi
 * @create: 2021-03-15 11:59
 **/
public class PrintHmap {

    public static void main(String[] args) {
        Map<String, Practice> hmap = new ConcurrentHashMap<>();

        hmap.put("your", new Practice("name", "12312"));
        hmap.put("me", new Practice("name1", "123"));
        System.out.println(hmap);

    }
}
