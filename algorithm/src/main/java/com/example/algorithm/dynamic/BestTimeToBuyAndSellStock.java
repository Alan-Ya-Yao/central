package com.example.algorithm.dynamic;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/12/20
 * @since 1.0.0
 */
public class BestTimeToBuyAndSellStock {

    /**
    *   leetcode 121 Best Time to Buy and Sell Stock
     *
     *  Say you have an array for which the ith element is the price of a given stock on day i.
     *
     *  If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     *  Note that you cannot sell a stock before you buy one.
     *
     *
     *  Input: [7,1,5,3,6,4]
     *  Output: 5
     *  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     *
    * */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null || prices.length == 0){
            return maxProfit;
        }
        int currentMin = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            currentMin = Math.min(currentMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - currentMin);
        }
        return maxProfit;
    }
}
