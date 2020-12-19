package com.example.algorithm.dynamic_programming_202012;

public class BestTimeToBuyAndSellStockWithCooldown_202012 {

    /*
    * 309. Best Time to Buy and Sell Stock with Cooldown
    * Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
    Example:

    Input: [1,2,3,0,2]
    Output: 3
    Explanation: transactions = [buy, sell, cooldown, buy, sell]
     * */
    public int maxProfit_recursion(int[] prices) {
        return dfs(prices,0,0);
    }

    private int dfs(int[] prices,int index,int status) {
        if(index>=prices.length) {
            return 0;
        }
        //定义三个变量，分别记录[不动]、[买]、[卖]
        int a=0,b=0,c=0;
        a = dfs(prices,index+1,status);
        if(status==1) {
            //递归处理卖的情况
            b = dfs(prices,index+2,0)+prices[index];
        } else {
            //递归处理买的情况
            c = dfs(prices,index+1,1)-prices[index];
        }
        //最终结果就是三个变量中的最大值
        return Math.max(Math.max(a,b),c);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown_202012 solution = new BestTimeToBuyAndSellStockWithCooldown_202012();
        System.out.println(solution.maxProfit_recursion(new int[]{1,2,3,0,2}));
    }
}
