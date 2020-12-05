package com.example.company.tengcent_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/11/20
 * @since 1.0.0
 */
public class CodingNumber {

    //
    // https://blog.csdn.net/lh470342237/article/details/77899034?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] c = reader.readLine().trim().toCharArray();
        int sum = 0, tmp = 0;
        for(int i=0;i<4;++i){
            tmp *= 25;
            if(i<c.length){
                tmp += c[i] - 'a';
            }
            sum += tmp;
            if(i<c.length-1){
                sum += 1;

            }
        }
        System.out.println(sum);
    }
}
