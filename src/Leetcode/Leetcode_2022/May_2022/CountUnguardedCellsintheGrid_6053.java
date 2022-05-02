package Leetcode.Leetcode_2022.May_2022;

public class CountUnguardedCellsintheGrid_6053 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] res = new int[m][n];
        for(int i = 0; i<walls.length; i++) {
            int x = walls[i][0];
            int y = walls[i][1];
            res[x][y] = 2;
        }

        for (int[] guard : guards) {
            res[guard[0]][guard[1]] = 2;
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i<guards.length; i++) {
            int x = guards[i][0];
            int y = guards[i][1];

            for(int j = 0; j<4; j++) {
                int a = x + dirs[j][0];
                int b = y + dirs[j][1];
                while (check(a, b, res)) {
                    res[a][b] = 1;
                    a += dirs[j][0];
                    b += dirs[j][1];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(res[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int x, int y, int[][] res) {
        int m = res.length;
        int n = res[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if(res[x][y] == 2) return false;
        return true;
    }
}
