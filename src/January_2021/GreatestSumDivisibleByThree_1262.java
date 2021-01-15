package January_2021;

//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
//
//         
//
//        示例 1：
//
//        输入：nums = [3,6,5,1,8]
//        输出：18
//        解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。

public class GreatestSumDivisibleByThree_1262 {
    // 被真正的动态规划给惊到了
    // 还是太菜了
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (nums[i-1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i-1]);
            } else if (nums[i-1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i-1]);
            } else if (nums[i-1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i-1]);
            }
        }
        return dp[n][0];
    }
}
