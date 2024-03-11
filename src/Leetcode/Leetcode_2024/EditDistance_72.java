package Leetcode.Leetcode_2024;

public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c2.length;
        int n = c1.length;

        if(m == 0) return n;
        if(n == 0) return m;

        int[][] dp = new int[m][n];
        dp[0][0] = c1[0] == c2[0] ? 0 : 1;

        for(int i = 1; i<m; i++) {
            if(c1[0] != c2[i]) dp[i][0] = 1 + dp[i - 1][0];
            else dp[i][0] = Math.max(dp[i - 1][0], i);
        }
        for(int i = 1; i<n; i++) {
            if(c2[0] != c1[i]) dp[0][i] = 1 + dp[0][i - 1];
            else dp[0][i] = Math.max(dp[0][i - 1], i);
        }

        for(int i = 1; i<m; i++) {
            for(int j = 1; j<n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                if(c1[j] == c2[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                else dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m - 1][n - 1];
    }
}
