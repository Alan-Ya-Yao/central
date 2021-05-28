package com.example.grammer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * /**
 *
 * @ClassName: SetPractice
 * @description:
 * @author: pengyi
 * @create: 2021-05-18 23:47
 **/
public class SetPractice {

    public static void main(String[] args) {
        Set<String> setA = new HashSet<String>();
        setA.add("1");
        setA.add("2");
        setA.add("3");
        Set<String> setB = new HashSet<String>();
        setB.add("2");
        setB.add("3");
        setB.add("4");
        setA.retainAll(setB);
        System.out.println(setA);
        Set<String> setC = new HashSet<String>();
        setC.add("3");
        setC.add("4");
        setC.add("1");
        List<Set<String>> list = new ArrayList<>();
        list.add(setA);
        list.add(setB);
        list.add(setC);
        Set<String> setD = list.stream().reduce((e1,e2)-> {
            e1.retainAll(e2);
            return  e1;
        }).get();
        System.out.println(setD);
    }
}
