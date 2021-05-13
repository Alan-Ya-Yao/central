package com.example.practice;

import java.util.Arrays;
import java.util.HashSet;

/**
 * /**
 *
 * @ClassName: RemoveDuplicates
 * @description:
 * @author: pengyi
 * @create: 2021-04-27 15:18
 **/
public class RemoveDuplicates {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
       // String tmp = "BBCER00015006,BBCER00012832,BBCER00007321,BBCER00020401,BBCER00015006,BBCER00012832,BBCER00007321,BBCER00020401,BBCER00015006,BBCER00012832,BBCER00007321,BBCER00020401,BBCER00015006,BBCER00012832,BBCER00015006,BBCER00020401,BBCER00015006";
        String tmp = "BBCER00014592,BBCER00015006,BBCER00015104,BBCER00015106,BBCER00015148,BBCER00015211,BBCER00015214,BBCER00015215,BBCER00015398,BBCER00015566,BBCER00015572,BBCER00015574,BBCER00015584,BBCER00018815,BBCER00020071,BBCER00020072,BBCER00024916,BBCER00025021,BBCER00025415";
        String[] tmps = tmp.split(",");
        hashSet.addAll(Arrays.asList(tmps));
        hashSet.forEach(System.out::println);
    }
}
