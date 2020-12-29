package com.example.preInterview_202012;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lambda_2020_12 {
    public static void main(String[] args) {
        String [] tmps = new String[]{"ac", "bd", "cd", "ef"};

        String tmpString = Arrays.stream(tmps).collect(Collectors.joining());
        System.out.println(tmpString); //acbdcdef

        List<String> tmpList = Arrays.stream(tmps).map(e -> {
            return e + "-";
        }).collect(Collectors.toList());
        tmpList.stream().forEach(System.out::print); //ac-bd-cd-ef-
    }
}
