package Leetcode.Leetcode_2020.November;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//         
//
//        示例 1:
//
//        输入: [7,1,5,3,6,4]
//        输出: 7
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。


public class 买卖股票的最佳时机II {
//    我自己的想法是按照递归来写，但是传入部分数组老是语法报错，烦烦烦
//    public int maxProfit(int[] prices) {
//        int cursor1 = 0;
//        int cursor2 = 0;
//        int len = prices.length;
//        int i = 1;
//        if(len == 0 || len == 1){
//            return 0;
//        }
//        if(len == 2){
//            if(prices[0]>=prices[1]){
//                return 0;
//            }
//            else return prices[1]-prices[0];
//        }
//        cursor1 = prices[0];
//        for(; i<len; i++){
//            if(cursor1 > prices[i]){
//                cursor1 = prices[i];
//            }
//            else break;
//        }
//        if(i == len-1) return 0;
//        cursor2 = prices[i];
//        int j = i+1;
//        for(; j<len; j++){
//            if(cursor2 < prices[j]){
//                cursor2 = prices[j];
//            }
//            else break;
//        }
//        return cursor2-cursor1+maxProfit((prices+j)[len]);
//    }

    //    动态规划
    /*考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。

    定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。

    考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，
    或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，
    并获得 prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：

    dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}

    再来考虑 dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，
    或者前一天结束时还没有股票，即 dp[i−1][0]，这时候我们要将其买入，并减少 prices[i] 的收益。可以列出如下的转移方程：

    dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}

    对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候 dp[0][0]=0，dp[0][1]=−prices[0]。

    因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，
    因此这时候 dp[n−1][0] 的收益必然是大于 dp[n−1][1] 的，最后的答案即为 dp[n−1][0]。
    */
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    //    改进
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }

//    贪心算法
    class Solution3 {
        public int maxProfit(int[] prices) {
            int ans = 0;
            int n = prices.length;
            for (int i = 1; i < n; ++i) {
                ans += Math.max(0, prices[i] - prices[i - 1]);
            }
            return ans;

        }
    }

}
