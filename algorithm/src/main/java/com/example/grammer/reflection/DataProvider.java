package com.example.grammer.reflection;

import java.util.HashMap;

/**
 * /**
 *
 * @ClassName: DataProvider
 * @description:
 * @author: pengyi
 * @create: 2021-05-25 17:32
 **/
public class DataProvider {

    public static HashMap<String, String>  hs = new HashMap<>();

    static {
        hs.put("Yuan", "handsome Yuan");
        hs.put("Yao", "handsome Yao");
    }

    public static String getDescription(String name){
        return hs.get(name);
    }
}
