package com.example.algorithm.dynamic_programming_202012.stock;

public class BestTimeToBuyAndSellStockII_2020_12 {
    /**
     *
     * Say you have an array prices for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     *
     * */

    /**
     * 采用dp - 有状态的dp - 其实是dfs
     * 有2种状态（手里有股票，手里木股票）
     *
     * 状态转移方程式
     * d[i][0] = max(d[i-1][0], d[i-1][1] + prices[i])
     * d[i][1] = max(d[i-1][1], d[i-1][0] - prices[i])
     *
     * 初时值
     * d[0][0] = 0
     * d[0][1] = 0
     *
     * 返回
     * max(d[length-1][0], d[length-1][1])
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] status = new int[prices.length][2];
        status[0][0] = 0;
        status[0][1] = -prices[0]; //初始化值要注意
        for(int i = 1; i < prices.length;i++){
            status[i][0] = Math.max(status[i - 1][0], status[i - 1][1] + prices[i]);
            status[i][1] = Math.max(status[i - 1][1], status[i - 1][0] - prices[i]);
        }
        return Math.max(status[prices.length - 1][0], status[prices.length - 1][1]);
    }
}
