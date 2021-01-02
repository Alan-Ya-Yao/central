package com.example.algorithm.dynamic_programming_202012.stock;

public class BestTimeToBuyAndSellStockIII_2020_12 {

    /**
     * 123. Best Time to Buy and Sell Stock III
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     *  
     *
     * Example 1:
     *
     * Input: prices = [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     *
     *
     * */


    /**
     * 采用dp
     * 状态
     * status[i][0][0] 没股票，交易0
     * status[i][0][1] 没股票，交易1
     * status[i][0][2] 没股票，交易2
     * status[i][1][0] 有股票, 交易0
     * status[i][1][1] 有股票, 交易1
     * status[i][1][1] 有股票, 交易2
     **
     ** 状态转移
     * status[i][0][0] = status[i - 1][0][0]
     * status[i][0][1] = max(status[i - 1][0][1], status[i - 1][1][0] +prices[i])
     * status[i][0][2] = max(status[i - 1][0][2], status[i - 1][1][1] + prices[i])
     * status[i][1][0] = max(status[i - 1][1][0], status[i - 1][0][0] - prices[i])
     * status[i][1][1] = max(status[i - 1][1][1], status[i - 1][0][1] - prices[i])
     * status[i][1][2] = max(status[i - 1][1][2], status[i -1][0][2] - prices[i])
     */

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        //定义状态
        int[][][] status = new int[prices.length][2][3];
        //初始化
        status[0][0][0] = 0;
        status[0][0][1] = 0;
        status[0][0][2] = 0;
        status[0][1][0] = -prices[0];
        status[0][1][1] = -prices[0];
        status[0][1][2] = -prices[0];
        for(int i = 1; i < prices.length ;i++){
            status[i][0][0] = status[i - 1][0][0];
            status[i][0][1] = Math.max(status[i - 1][0][1], status[i - 1][1][0] +prices[i]);
            status[i][0][2] = Math.max(status[i - 1][0][2], status[i - 1][1][1] + prices[i]);
            status[i][1][0] = Math.max(status[i - 1][1][0], status[i - 1][0][0] - prices[i]);
            status[i][1][1] = Math.max(status[i - 1][1][1], status[i - 1][0][1] - prices[i]);
            status[i][1][2] = Math.max(status[i - 1][1][2], status[i -1][0][2] - prices[i]);
        }
        int a = Math.max(status[prices.length - 1][0][1], status[prices.length - 1][0][2]);
        return a;
    }
}
