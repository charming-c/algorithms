package Leetcode.Leetcode_2021.July_2021;

//给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
//
//        移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
//
//        返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
//
//         
//
//        示例 1：
//
//        输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//        输出：3
//        解释：
//        有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
//        示例 2：
//
//        输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//        输出：0
//        解释：
//        所有 1 都在边界上或可以到达边界。

public class NumberOfEnclaves_1020 {
        static int count = 0;
        static int m = 0;
        static int n = 0;


    public static int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    getOut(grid, i, j);
                }
            }
        }
        return count;
    }

    public static boolean getOut(int[][] grid, int col, int vol) {
        if (col < 0 || col >= m) return true;
        if (vol < 0 || vol >= n) return true;

        if (grid[col][vol] == 2) return true;
        if (grid[col][vol] == 1) {
            if (col - 1 < 0 || col + 1 >= m || vol - 1 < 0 || vol + 1 >= n) {
                grid[col][vol] = 2;
                return true;
            }
            grid[col][vol] = 0;
            if (getOut(grid, col - 1, vol) || getOut(grid, col, vol - 1) || getOut(grid, col + 1, vol) || getOut(grid, col, vol + 1)) {
                grid[col][vol] = 2;
                return true;
            } else {
                count++;
                for(int i=0;i<m; i++){
                    for(int j = 0; j<n;j++){
                        System.out.print(grid[i][j]+" ");
                    }
                    System.out.print("\n");
                }
                System.out.print("\n");
                return false;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}};
        numEnclaves(grid);
        for(int i=0;i<m; i++){
            for(int j = 0; j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

}
