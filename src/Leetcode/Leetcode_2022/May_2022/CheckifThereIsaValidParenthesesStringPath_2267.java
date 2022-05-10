package Leetcode.Leetcode_2022.May_2022;

public class CheckifThereIsaValidParenthesesStringPath_2267 {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] ret = new boolean[m][n][n + m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int t = grid[i][j] == '(' ? 1 : -1;
                if (i == 0 && j == 0) {
                    if (grid[i][j] == '(') ret[i][j][1] = true;
                    else return false;
                } else {
                    for (int k = 0; k < n + m; k++) {
                        int kk = k - t;
                        if (kk < 0 || kk >= n + m) continue;
                        if (i != 0) ret[i][j][k] = ret[i][j][k] || ret[i - 1][j][kk];
                        if (j != 0) ret[i][j][k] = ret[i][j][k] || ret[i][j - 1][kk];

                    }
                }
            }
        }
        return ret[m - 1][n - 1][0];
    }
}
