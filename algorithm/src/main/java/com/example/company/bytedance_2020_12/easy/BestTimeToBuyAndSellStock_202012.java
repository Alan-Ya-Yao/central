package com.example.company.bytedance_2020_12.easy;

public class BestTimeToBuyAndSellStock_202012 {

    /**
     * lc 121. Best Time to Buy and Sell Stock
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *

     * */

    /**
     * 最简单的动态编程
     * s[i] 为 i为sell day的最大profit
     * s[i] 为 prices[i] - min. min 为 i之前最小值，遍历时需记住这个值
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            maxProfit = Math.max(prices[i] - min, maxProfit);
        }
        return maxProfit;
    }
}
