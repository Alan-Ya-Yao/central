package com.example.company.tengcent_2020;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 9/10/20
 * @since 1.0.0
 */


public class GetGray {

    /**  牛客网 - 腾讯题目专区
    *
    * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
    * 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
    *   给定一个整数n，请返回n位的格雷码，顺序为从0开始。
    * */
    public static String[] getGray(int n) {
        /**
         典型 bottom to top with assembling subresult at each step
         */
        if(n == 1){
            return new String[]{"0", "1"};
        }
        //get subRestult
        String[] subResult = getGray(n - 1);
        // start to assemble result
        String[] add_0_to_result = new String[subResult.length];
        for(int i = 0; i < subResult.length; i++){
            add_0_to_result[i] = "0" + subResult[i];
        }
        String[] add_1_to_result = new String[subResult.length];
        for(int i = subResult.length - 1; i >= 0; i--){
            add_1_to_result[subResult.length - 1 - i] = "1" + subResult[i];
        }
        //采用sb方法
        String[] result = new String[subResult.length * 2];
        for(int i = 0; i < subResult.length; i++){
            result[i] = add_0_to_result[i];
        }

        for(int i = 0; i < subResult.length; i++){
            result[subResult.length + i] = add_1_to_result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        getGray(2);
    }
}
