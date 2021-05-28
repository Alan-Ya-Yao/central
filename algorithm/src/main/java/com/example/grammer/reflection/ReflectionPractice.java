package com.example.grammer.reflection;

import java.lang.reflect.Method;

/**
 * /**
 *
 * @ClassName: ReflectionPractice
 * @description:
 * @author: pengyi
 * @create: 2021-05-25 17:32
 **/
public class ReflectionPractice {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.grammer.reflection" + "." + "DataProvider");
        try{
            Method method = clazz.getDeclaredMethod("getDescription", String.class);
            method.setAccessible(true);
            System.out.println(method.invoke(null, "Yuan"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
