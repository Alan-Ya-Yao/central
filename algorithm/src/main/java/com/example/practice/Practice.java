package com.example.practice;

import lombok.*;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 11/12/20
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Practice {

    private String name;
    private String age;
    public static void main(String[] args) {
//        char[] tmp = new char[2];
//        for(int i = 0; i < tmp.length;i++){
//            tmp[i] = 'a';
//        }
//        System.out.println();


        String s = "dafasd";
        for(Character c:s.toCharArray()){
            System.out.println(c);
        }

        Date date = new Date("ada");
        System.out.println(date);
    }
}
