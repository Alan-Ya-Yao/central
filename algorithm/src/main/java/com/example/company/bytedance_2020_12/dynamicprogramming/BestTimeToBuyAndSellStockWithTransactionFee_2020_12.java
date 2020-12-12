package com.example.company.bytedance_2020_12.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithTransactionFee_2020_12 {


    /**
     * 核心思想 - 每天2中状态 - 有股票和无股票, 可以进行的操作有根据前一状态决定
     * 两种解法
     * 1.dp, 值是累计的，只需比较最后一个值
     * 2.recursion遍历, 记录遍历值
     */

    /**
     * 采用dp -
     *状态
     * d[i][0] : 第i天没有股票最大利润
     * d[i][1] : 第i天持有股票最大利润
     * 状态转移
     * d[i][0] = max(d[i-1][0], d[i-1][1] + prices[i] - fee)
     * d[i][1] = max(d[i-1][1], d[i-1][0] - prices[i])
     * 初始值
     * d[0][0] = 0;
     * d[0][1] = -prices[0]
     * 最终返回值
     * max(d[n-1][0], d[n-1][1])
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] status = new int[prices.length][2];
        status[0][0] = 0;
        status[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            status[i][0] = Math.max(status[i - 1][0], status[i - 1][1] + prices[i] - fee);
            status[i][1] = Math.max(status[i - 1][1], status[i - 1][0] - prices[i]);
        }
        return Math.max(status[prices.length - 1][0], status[prices.length - 1][1]);
    }

    public int maxProfit_dfs(int[]prices, int fee){
        maxProfit_dfs_helper(prices,0, 0, 0, fee);
        return profit;
    }

    int profit = 0;
    /**
     * status = 0 - 手里木股票， 下一步 1.不作为，2.买入股票
     * status = 1 - 手里有股票， 下一步 1.不作为 2.卖出股票 （卖出股票时，有2元手续费）
     * */
    private void maxProfit_dfs_helper(int[]prices, int status, int index, int currentPrices, int fee){
        if(index == prices.length){
            return;
        }
        if(status == 0){//木有股票
            //不作为
            maxProfit_dfs_helper(prices, status, index + 1, currentPrices, fee);
            profit = Math.max(profit, currentPrices);
            //买入
            maxProfit_dfs_helper(prices, status + 1, index + 1, currentPrices - prices[index], fee);
            profit = Math.max(profit, currentPrices - prices[index]);
        }else{//有股票
            //不作为
            maxProfit_dfs_helper(prices, status, index + 1, currentPrices, fee);
            profit = Math.max(profit, currentPrices);
            //卖出
            maxProfit_dfs_helper(prices, status - 1, index + 1, currentPrices + prices[index] - fee, fee);
            profit = Math.max(profit, currentPrices + prices[index] - fee);
        }
        return;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee_2020_12 solution = new BestTimeToBuyAndSellStockWithTransactionFee_2020_12();
        int[] tmp = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(solution.maxProfit(tmp, 2));
        System.out.println(solution.maxProfit_dfs(tmp, 2));
    }
}
