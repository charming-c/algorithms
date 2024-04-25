package Leetcode.Leetcode_2024;

public class MinimumNumberofOperationstoSatisfyConditions_3122 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][10];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[j][grid[i][j]] += 1;
            }
        }
        int[][] ans = new int[n][10];
        for(int i = 0; i<10; i++) {
            ans[0][i] = dp[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 10; k++) {
                int pre = 0;
                for (int x = 0; x < 10; x++) {
                    if (x == k) continue;
                    else pre = Math.max(pre, ans[i - 1][x]);
                }
                ans[i][k] = pre + dp[i][k];
            }
        }
        int res = 0;
        for(int i = 0; i<10; i++) {
            res = Math.max(res, ans[n- 1][i]);
        }
        return m*n - res;
    }

}
