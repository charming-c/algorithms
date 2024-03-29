package Leetcode.Leetcode_2021.July_2021;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//        此外，你可以假设该网格的四条边均被水包围。
//
//         
//
//        示例 1：
//
//        输入：grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        输出：1

public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    setZero(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    public void setZero(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return;
        if (grid[i][j] == '0') return;
        else {
            grid[i][j] = '0';
            setZero(grid, i + 1, j);
            setZero(grid, i, j + 1);
            setZero(grid, i - 1, j);
            setZero(grid, i, j - 1);
        }
    }
}
