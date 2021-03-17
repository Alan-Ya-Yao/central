package com.example.grammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 4/26/20
 * @since 1.0.0
 */
public class StringPractice {
    public static void main(String[] args) {
//        String tmp = "";
//        String[] ar = tmp.split(",");
//        System.out.println(ar[0]);


        List<String> ls = new ArrayList<>();
        ls.add("好你好");
        ls.add("很腻害");
        System.out.println(ls.toString());

        StringBuffer sb = new StringBuffer();
        sb.append("id : ").append("my id").append("\n");
        sb.append("name : ").append("my name").append("\n");
        sb.append("description : ").append("my desc");
        System.out.println(sb);

    }


}
