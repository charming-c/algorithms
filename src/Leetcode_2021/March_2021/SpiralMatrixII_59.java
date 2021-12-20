package Leetcode_2021.March_2021;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//         
//
//        示例 1：
//
//
//        输入：n = 3
//        输出：[[1,2,3],[8,9,4],[7,6,5]]

public class SpiralMatrixII_59 {
    class Solution {

            //  其实和昨天的题没有什么区别
        public int[][] generateMatrix(int n) {
            int[][] ret = new int[n][n];
            int num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n - 1; j++) {
                    ret[i][j] = num++;
                }
                for (int j = i; j < n - 1; j++) {
                    ret[j][n - 1] = num++;
                }
                for (int j = n - 1; j > i; j--) {
                    ret[n - 1][j] = num++;
                }
                for (int j = n - 1; j > i; j--) {
                    ret[j][i] = num++;
                }
                if (i == n - 1) ret[i][i] = num;
                n--;
            }
            return ret;
        }
    }
}
