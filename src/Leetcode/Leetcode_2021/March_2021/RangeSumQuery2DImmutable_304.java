package Leetcode.Leetcode_2021.March_2021;
//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
//
//
//        上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
//
//         
//
//        示例：
//
//        给定 matrix = [
//        [3, 0, 1, 4, 2],
//        [5, 6, 3, 2, 1],
//        [1, 2, 0, 1, 5],
//        [4, 1, 0, 1, 7],
//        [1, 0, 3, 0, 5]
//        ]
//
//        sumRegion(2, 1, 4, 3) -> 8
//        sumRegion(1, 1, 2, 2) -> 11
//        sumRegion(1, 2, 2, 4) -> 12

public class RangeSumQuery2DImmutable_304 {

    // 一点想法也没有的解法，直接复制计算---在下的无脑解法
    class NumMatrix {
        private int[][] Matrix;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            if(row == 0) return;
            int col = matrix[0].length;
            Matrix = new int[col][row];
            Matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int i = row1; i<=row2; i++){
                for(int j = col1; j<= col2; j++){
                    sum += Matrix[i][j];
                }
            }
            return sum;
        }
    }


    // 每一行做一维前缀和
     class NumMatrix2 {
        private int[][] sums;

        public NumMatrix2(int[][] matrix) {
            int row = matrix.length;
            if(row == 0) return;
            int col = matrix[0].length;
            sums = new int[row][col + 1];
            for(int i = 0; i<row; i++){
                for(int j = 1; j< col + 1; j++){
                    sums[i][j] = sums[i][j-1] + matrix[i][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for(int i = row1; i<= row2; i++){
                ans += (sums[i][col2 + 1] - sums[i][col1]);
            }
            return ans;
        }
    }


    // 二维前缀和--很妙
    class NumMatrix3 {
        int[][] sums;

        public NumMatrix3(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m + 1][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

}
