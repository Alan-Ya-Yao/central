package com.example.algorithm.dynamic.dp;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 6/24/20
 * @since 1.0.0
 */
public class Square {

    /*
    *
    *   leetcode 221. Maximal Square
    *
    *   Given a 2D binary matrix filled with 0's and 1's,
    *   find the largest square containing only 1's and return its area.
    *
    *   Input:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        Output: 4
    * */

    public int maximalSquare(char[][] matrix) {
        int maxlength = 0;
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == 1){ // dp里默认元素为零，只处理需要处理的
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                       dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                       maxlength = Math.max(maxlength, dp[i][j]);
                    }
                }
            }
        }
        return maxlength * maxlength;
    }

    /**
     * leetcode 1277. Count Square Submatrices with All Ones
     *
     * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     *Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     *
     * */
    public int countSquares(int[][] matrix) {
        int sum = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return sum;
        }
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
