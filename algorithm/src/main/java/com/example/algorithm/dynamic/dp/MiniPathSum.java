package com.example.algorithm.dynamic.dp;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 8/21/20
 * @since 1.0.0
 */
public class MiniPathSum {
    /**
     * 64. Minimum Path Sum
     *  Given a m x n grid filled with non-negative numbers,
     *  find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *  You can only move either down or right at any point in time.
     *
     *  Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * **/

    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++){ // row
            for(int j = 0; j< grid[0].length; j++){ // column
                if(i == 0){
                    result[i][j] = j == 0? grid[i][j]: result[i][j - 1] + grid[i][j];
                }else{
                    result[i][j] = j == 0? result[i - 1][j] + grid[i][j]: Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
                }
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }
}
