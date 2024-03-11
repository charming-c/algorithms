package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class JumpGameII_45 {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c2.length;
        int n = c1.length;
        int[][] dp = new int[m][n];
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;

        for(int i = 0; i<m; i++) {
            if(c1[0] == c2[i]) dp[i][0] = 1;
        }
        for(int i = 0; i<n; i++) {
            if(c2[0] == c1[i]) dp[0][i] = 1;
        }

        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if(c1[j] == c2[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return n - dp[m - 1][n - 1];
    }
}
