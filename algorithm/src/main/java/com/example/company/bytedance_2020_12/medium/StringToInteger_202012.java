package com.example.company.bytedance_2020_12.medium;

public class StringToInteger_202012 {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int result = 0;
        int sign = 0; // 0 - positive, 1 - negative
        //必须要先要去掉开头
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        //第一个非null字符，只可以为 - 或 +
        if(i < str.length() && str.charAt(i) == '-' ){
            sign = 1;
            i++;
        }else if( i < str.length() && str.charAt(i) == '+' ){
            sign = 0;
            i++;
        }
        //必须是digit 否者直接返回result
        for(; i < str.length(); i++){
            if('0' <= str.charAt(i) && str.charAt(i) <= '9'){
                if(sign == 0){ //正数
                    //防止溢出
                    if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10  && str.charAt(i) - '0' >= 7)){
                        return Integer.MAX_VALUE;
                    }
                    result = result * 10 + (str.charAt(i) - '0');
                }else{
                    if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && str.charAt(i) - '0'>= 8)){
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 - (str.charAt(i) - '0');
                }

            }else{
                break;
            }
        }
        return result;
    }
}
