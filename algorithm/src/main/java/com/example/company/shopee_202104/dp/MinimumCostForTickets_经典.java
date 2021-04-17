package com.example.company.shopee_202104.dp;

import java.util.Arrays;

/**
 * /**
 *
 * @ClassName: MinimumCostForTickets_经典
 * @description:
 * @author: pengyi
 * @create: 2021-04-17 20:36
 **/
public class MinimumCostForTickets_经典 {

    /**
     * In a country popular for train travel,
     * you have planned some train travelling one year in advance. 
     * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
     *
     * Train tickets are sold in 3 different ways:
     *
     * a 1-day pass is sold for costs[0] dollars;
     * a 7-day pass is sold for costs[1] dollars;
     * a 30-day pass is sold for costs[2] dollars.
     * The passes allow that many days of consecutive travel. 
     * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
     *
     * Return the minimum number of dollars you need to travel every day in the given list of days.
     *
     *
     * Example 1:
     *
     * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
     * Output: 11
     * Explanation:
     * For example, here is one way to buy passes that lets you travel your travel plan:
     * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
     * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
     * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
     * In total you spent $11 and covered all the days of your travel.
     * Example 2:
     *
     * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
     * Output: 17
     * Explanation:
     * For example, here is one way to buy passes that lets you travel your travel plan:
     * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
     * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
     * In total you spent $17 and covered all the days of your travel.
     *
     *
     *
     * */

    /**
     *
     * 十级 reference https://www.cnblogs.com/grandyang/p/14205874.html
     * 典型动态编程
     * 状态定义 1: dp[i],表示 days[i]的最低花销
     * 转移方程 2： dp[i] = min  if days[i - 1] + cost[0]
     *              if days[j] + 3 > days[i], then dp[j] + cost[1] ; j from 0 to i - 1
     *              if day[j] + 30 > days[i], then dp[j] + cost[2] ; j from 0 to i - 1
     * 初始化值（重要）
     *
     * */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return -1;
    }
}
