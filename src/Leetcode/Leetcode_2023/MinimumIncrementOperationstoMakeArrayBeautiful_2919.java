package Leetcode.Leetcode_2023;

public class MinimumIncrementOperationstoMakeArrayBeautiful_2919 {
    public long minIncrementOperations(int[] nums, int k) {
        int len = nums.length;
        long[][] dp = new long[len][3];
        int tmp = 0;
        if (nums[0] >= k) tmp = 0;
        else tmp = k - nums[0];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = tmp;
        }

        // dp[i][j] 当前处在 nums 的 i 位置，且前一个 >= k 的距离为 j 的花费最少的次数
        for (int i = 1; i < len; i++) {
            int d = nums[i] >= k ? 0 : k - nums[i];
            long min = Long.MAX_VALUE;
            if(i >= 3)
                for(int j = 0; j<3; j++) {
                    min = Math.min(min, dp[i - 1][j]);
                }
            else {
                min = 0;
            }

            dp[i][0] = min + d;
            dp[i][1] = dp[i - 1][0];
            dp[i][2] = dp[i - 1][1];

        }
        long ans = dp[len - 1][0];
        ans = Math.min(dp[len - 1][1], ans);
        ans = Math.min(dp[len - 1][2], ans);
        return ans;
    }
}
