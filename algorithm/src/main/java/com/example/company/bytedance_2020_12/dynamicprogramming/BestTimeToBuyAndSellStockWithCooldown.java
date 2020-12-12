package com.example.company.bytedance_2020_12.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     *  有状态的dp问题,十分经典
     */
    public int maxProfit(int[] prices) {
        maxProfit_dfs(prices, 0, 0, 0);
        return profit;
    }

    /**
     * method 1 - 采用recursion 遍历树方法 - 一天只有一个状态，
     * status = 0 表明没有股票，可以买，可以不作为
     * status = 1 表明有股票，可以卖，可以不作为
     */
    int profit;
    private void maxProfit_dfs(int[] prices, int index, int status, int currentProfit){
        if(index >= prices.length){
            return;
        }
        if(status == 0){ // 手里没有股票
            //不作为
            maxProfit_dfs(prices, index + 1, status, currentProfit);
            profit = Math.max(profit, currentProfit);
            //买股票
            maxProfit_dfs(prices, index + 1, status + 1, currentProfit - prices[index]);
            profit = Math.max(profit, currentProfit - prices[index]);
        }else{ //手里有股票
            //不作为
            maxProfit_dfs(prices, index + 1, status, currentProfit);
            profit = Math.max(profit, currentProfit);
            //卖股票
            maxProfit_dfs(prices, index + 2, status - 1, currentProfit + prices[index]);
            profit = Math.max(profit, currentProfit + prices[index]);
        }
        return;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(solution.maxProfit(new int[]{1,2,5, 7, 8, 11, 1, 13, 22,23}));
    }
}
