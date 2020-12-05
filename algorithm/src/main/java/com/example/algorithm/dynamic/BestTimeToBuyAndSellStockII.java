package com.example.algorithm.dynamic;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author eleme
 * @create 5/12/20
 * @since 1.0.0
 */
public class BestTimeToBuyAndSellStockII {

    /**
     *  leetcode 122 Best Time to Buy and Sell Stock II
     *
    *   Say you have an array prices for which the ith element is the price of a given stock on day i.
     *
     *  Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     *
     *  Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     *
     *      Input: [7,1,5,3,6,4]
     *      Output: 7
     *      Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     *
    *       Input: [1,2,3,4,5]
     *      Output: 4
     *      Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     *              engaging multiple transactions at the same time. You must sell before buying again.
     *
     *      不断寻找波峰波谷
    * */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            while(i < prices.length - 1&& prices[i] >= prices[i + 1]){
                i++;
            }
            //一开始就是向上
            int valley = i;
            while(i < prices.length - 1 && prices[i] < prices[i + 1]){
                i++;
            }
            int peak = i;
            profit += prices[peak] - prices[valley];
        }
        return profit;
    }
}
