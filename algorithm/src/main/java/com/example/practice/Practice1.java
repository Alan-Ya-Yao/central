package com.example.practice;

import java.util.regex.Pattern;

/**
 * /**
 *
 * @ClassName: Practice1
 * @description:
 * @author: pengyi
 * @create: 2021-04-16 11:26
 **/
public class Practice1 {
    public static void main(String[] args) {
        String partition = "dt='20210415'";
        Pattern p_partition = Pattern.compile("dt=\'[0-9]{8,11}\'");
        if(!p_partition.matcher(partition).matches()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
