package com.example.company.bytedance_2020_12.dynamicprogramming;

public class MaximumLengthOfRepeatedSubarray_2020_12 {
    /**
     *  1.暴力法
     *  2.dp
     *  状态
     *  d[i][j] 表示以i 和 j 结尾，最大长度
     *  状态转移
     *  d[i][j] = 0 if A[i] != B[j]
     *           = d[i - 1][j - 1] + 1 if A[i] == B[j]
     *  初始化
     *  d[1][j]
     d[i][1]
     *  返回值
     由max值中间记录
     **/

    public int findLength(int[] A, int[] B) {
        int[][] status = new int[A.length][B.length];
        //初始化
        for(int j = 0; j < B.length ; j++ ){
            if(A[0] == B[j]){
                status[0][j] = 1;
            }
        }
        //初始化
        for(int i = 0; i < A.length ; i++){
            if(A[i] == B[0]){
                status[i][0] = 1;
            }
        }
        int maxLength = 0;
        for(int i = 1; i < A.length; i ++){
            for(int j = 1; j < B.length; j++){
                if(A[i] == B[j]){
                    status[i][j] = status[i - 1][j - 1] + 1;
                }else{
                    status[i][j] = 0;
                }
                maxLength = Math.max(status[i][j], maxLength);
            }
        }
        return maxLength;
    }
}
