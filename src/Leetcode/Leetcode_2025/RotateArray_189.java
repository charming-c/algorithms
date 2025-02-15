package Leetcode.Leetcode_2025;

public class RotateArray_189 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][1] = -1 * prices[0];
        dp[0][0] = 0;

        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[len - 1][0];
    }
}
