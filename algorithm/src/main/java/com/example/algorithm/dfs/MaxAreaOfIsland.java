package com.example.algorithm.dfs;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/1/20
 * @since 1.0.0
 *
 *
 * leetcode 695 Max Area Of Island
 *
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array.
 * (If there is no island, the maximum area is 0.)
 *
 */
public class MaxAreaOfIsland {
    /*
    *   [[0,0,1,0,0,0,0,1,0,0,0,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,1,1,0,1,0,0,0,0,0,0,0,0],
         [0,1,0,0,1,1,0,0,1,0,1,0,0],
         [0,1,0,0,1,1,0,0,1,1,1,0,0],
         [0,0,0,0,0,0,0,0,0,0,1,0,0],
         [0,0,0,0,0,0,0,1,1,1,0,0,0],
         [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    * */

    //DFS Brutal Force
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        if(grid == null || grid .length == 0){
            return result;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                result = Math.max(result, maxAreaOfIsland_DFS(grid, i, j));
            }
        }
        return result;
    }

    public int maxAreaOfIsland_DFS(int[][] grid, int i, int j){
        //recursion 截止条件
        if(i < 0  || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0){
            return 0;
        }
        //不设置为0，会出现无限相互循环
        grid[i][j] = 0;
        return maxAreaOfIsland_DFS(grid, i + 1, j)
                + maxAreaOfIsland_DFS(grid, i - 1, j)
                + maxAreaOfIsland_DFS(grid, i, j + 1)
                + maxAreaOfIsland_DFS(grid, i, j - 1)
                + 1;
    }


    // adop the Deep first search algorithm - with memory
    public int maxAreaOfIsland_(int[][] grid) {
        //有返回值的题目，首先定义返回，不满足条件，返回默认值
        int result = 0;
        if(grid == null || grid.length == 0){
            return result;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                result = Math.max(result, maxAreaOfIsland_dfs(grid, visited, i, j));
            }
        }
        return result;
    }

    public int maxAreaOfIsland_dfs(int[][] grid, boolean[][]visited, int i, int j){
        if(i >= grid.length || i < 0  || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return maxAreaOfIsland_dfs(grid, visited, i + 1, j)
                + maxAreaOfIsland_dfs(grid, visited, i, j + 1)
                + maxAreaOfIsland_dfs(grid, visited, i, j - 1)
                + maxAreaOfIsland_dfs(grid, visited, i - 1, j)
                +1;
    }
}
