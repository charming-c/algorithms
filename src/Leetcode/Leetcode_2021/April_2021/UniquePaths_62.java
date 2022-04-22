package Leetcode.Leetcode_2021.April_2021;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//        问总共有多少条不同的路径？
//
//         
//
//        示例 1：
//
//
//        输入：m = 3, n = 7
//        输出：28

public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            ret[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ret[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
            }
        }

        return ret[m - 1][n - 1];
    }
}
