package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class EditDistance_72 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][][] dp = new int[m + 1][n + 1][2];
        for(int i = 0; i<=m; i++) {
            Arrays.fill(dp[i][0], 0);
        }
        for(int i = 0; i<=n; i++) {
            Arrays.fill(dp[0][i], 0);
        }
        int ans = 0;
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(matrix[i][j] == '0') {
                    Arrays.fill(dp[i][j], 0);
                }
                else {
                    if(ans == 0) ans = 1;
                    int[] left = dp[i][j - 1];
                    int[] top = dp[i - 1][j];
                    dp[i][j][0] = Math.min(left[0] + 1, top[0]);
                    dp[i][j][1] = Math.min(left[1], top[1] + 1);
                    ans = Math.max(ans, dp[i][j][0] * dp[i][j][1]);
                }
            }
        }
        return ans;
    }
}
