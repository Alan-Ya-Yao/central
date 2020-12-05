package com.example.algorithm.tailrecursion;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 8/12/20
 * @since 1.0.0
 *
 * 尾递归重点 学习
 * https://segmentfault.com/a/1190000018448766
 */
public class FibSeq {
    public  static int fib(int num){
        if(num < 2){
            return num;
        }
        return fib(num - 2) + fib(num - 1);
    }

    public static int fib1(int num){
        if(num < 2){
            return num;
        }
        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        for(int i = 2 ; i <= num; i++){
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }

    //初始值  num1 = 0, num2 = 1
    public static int fib2(int num, int num1, int num2){
        if(num == 0){
            return num1;
        }
        return fib2(num - 1, num2, num2 + num1);
    }

    public static void main(String[] args) {


        int num = 40;
        long time = System.currentTimeMillis();
        System.out.println(fib(num));
        System.out.println("fib 耗时 + : {}" + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        System.out.println(fib1(num));
        System.out.println("fib1 耗时 + : {}" + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        System.out.println(fib2(num, 0, 1));
        System.out.println("fib2 耗时 + : {}" + (System.currentTimeMillis() - time));


    }
}
