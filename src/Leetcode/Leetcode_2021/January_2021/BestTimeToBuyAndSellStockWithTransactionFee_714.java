package Leetcode.Leetcode_2021.January_2021;

//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
//
//        你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
//        返回获得利润的最大值。
//
//        注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
//
//        示例 1:
//
//        输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//        输出: 8
//        解释: 能够达到的最大利润:
//        在此处买入 prices[0] = 1
//        在此处卖出 prices[3] = 8
//        在此处买入 prices[4] = 4
//        在此处卖出 prices[5] = 9
//        总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    // 每一个交易日，有手里买入一份股票和没有持有股票两个状态，所以可以使用状态转移方程
    // 很轻易就可以找到状态转移方程
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = prices[0] * (-1);
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }
    // 注意到这里的状态转移方程就只有两个状态，并且每一个至于前一层状态有关，所以就可以简化变量
    // 不必特意开辟一个数组
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int sell = 0, buy = -prices[0];
            for (int i = 1; i < n; ++i) {
                sell = Math.max(sell, buy + prices[i] - fee);
                buy = Math.max(buy, sell - prices[i]);
            }
            return sell;
        }
    }

   // 现在感觉动态规划没有想象中那么难啊
}
