package Leetcode.Leetcode_2021.March_2021;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//         
//
//        示例 1：
//
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[1,2,3,6,9,8,7,4,5]

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m * n);
        for (int i = 0; i < m; i++) {
            if (i != 0 && (n < 2 || m < 2)) break;
            for (int j = i; j < n; j++) {
                ans.add(matrix[i][j]);
            }
            if (m == i + 1) break;
            for (int j = i + 1; j < m; j++) {
                ans.add(matrix[j][n - 1]);
            }
            if (n == i + 1) break;

            for (int j = n - 2; j >= i; j--) {
                ans.add(matrix[m - 1][j]);
            }
            for (int j = m - 2; j > i; j--) {
                ans.add(matrix[j][i]);
            }
            m = m - 1;
            n = n - 1;
        }
        return ans;
    }
}
