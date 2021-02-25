package February_2021;

//给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//
//        矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
//
//
//
//         
//
//        示例 1：
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[[1,4,7],[2,5,8],[3,6,9]]


public class TransposeMatrix_867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        return ans;
    }
}
