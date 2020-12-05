package com.example.company.huawei_2020;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/12/20
 * @since 1.0.0
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

    /**
     * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
     * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
     *
     * */
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int target=Integer.parseInt(br.readLine());
        int[] nums=new int[target];//用来存放质数数组；
        int result=0;//用来存放结果；
        int count=0;//质数数组下标；
        for(int i=2;i<=target;i++){
            int judge=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    judge=1;
                    break;
                }
            }
            if(judge==0){
                nums[count]=i;
                count++;
            }
        }
        for(int i=0;i<count-1;i++){
            for(int j=i;j<count;j++){
                if(nums[i]+nums[j]==target){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static void initimattion() throws IOException{
        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String message=read.readLine();
        String[] data=message.split(" ");
        int n1=Integer.parseInt(data[0]);
        int n2=Integer.parseInt(data[1]);
    }
}