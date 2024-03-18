package Leetcode.Leetcode_2024;

public class OutofBoundaryPaths_576 {
    int[][] step = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for(int s = 1; s<=maxMove; s++) {
            for(int i = 0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    if(i == 0) dp[i][j][s] += 1;
                    if(j == 0) dp[i][j][s] += 1;
                    if(i == m - 1) dp[i][j][s] += 1;
                    if(j == n - 1) dp[i][j][s] += 1;
                }
            }
        }

        for(int s = 1; s<=maxMove; s++) {
            for(int i = 0; i<m; i++) {
                for(int j = 0; j<n; j++) {
                    for(int[] d : step) {
                        int r = i + d[0];
                        int c = j + d[1];
                        if(r >= 0 && r < m && c >= 0 && c < n) {
                            dp[i][j][s] += dp[r][c][s - 1];
                            dp[i][j][s] %= (int) (1e9 + 7);
                        }
                    }
                }
            }
        }


        return dp[startRow][startColumn][maxMove];

    }
}
