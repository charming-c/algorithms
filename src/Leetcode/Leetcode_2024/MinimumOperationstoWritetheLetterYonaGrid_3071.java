package Leetcode.Leetcode_2024;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始、大小为 n x n 的矩阵 grid ，其中 n 为奇数，且 grid[r][c] 的值为 0 、1 或 2 。
 *
 * 如果一个单元格属于以下三条线中的任一一条，我们就认为它是字母 Y 的一部分：
 *
 * 从左上角单元格开始到矩阵中心单元格结束的对角线。
 * 从右上角单元格开始到矩阵中心单元格结束的对角线。
 * 从中心单元格开始到矩阵底部边界结束的垂直线。
 * 当且仅当满足以下全部条件时，可以判定矩阵上写有字母 Y ：
 *
 * 属于 Y 的所有单元格的值相等。
 * 不属于 Y 的所有单元格的值相等。
 * 属于 Y 的单元格的值与不属于Y的单元格的值不同。
 * 每次操作你可以将任意单元格的值改变为 0 、1 或 2 。返回在矩阵上写出字母 Y 所需的 最少 操作次数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,2,2],[1,1,0],[0,1,0]]
 * 输出：3
 * 解释：将在矩阵上写出字母 Y 需要执行的操作用蓝色高亮显示。操作后，所有属于 Y 的单元格（加粗显示）的值都为 1 ，而不属于 Y 的单元格的值都为 0 。
 * 可以证明，写出 Y 至少需要进行 3 次操作。
 */
public class MinimumOperationstoWritetheLetterYonaGrid_3071 {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int mid = n / 2;
        int[] sum = new int[3];
        int[][] res = new int[4][3];
        Arrays.fill(sum, 0);
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int num = grid[i][j];
                if(i == j && i == mid) continue;
                sum[num]++;
                if(i == j) {
                    if(i < mid) {
                        res[0][num]++;
                        res[3][num]++;
                    }
                    else {
                        res[1][num]++;
                        res[2][num]++;
                    }
                }
                if(i + j + 1 == n) {
                    if(i < mid) {
                        res[0][num]++;
                        res[1][num]++;
                    }
                    else {
                        res[3][num]++;
                        res[2][num]++;
                    }
                }
                if(j == mid) {
                    if(i < mid) {
                        res[2][num]++;
                    }
                    else {
                        res[0][num]++;
                    }
                }
                if(i == mid) {
                    if(j < mid) {
                        res[1][num]++;
                    }
                    else {
                        res[3][num]++;
                    }
                }
            }
        }
        sum[grid[mid][mid]]++;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<1; i++) {
            res[i][grid[mid][mid]]++;
            int m = res[i][0];
            int ni = res[i][1];
            int k = res[i][2];
            ans = Math.min(ans, sum[1] + sum[2] + m - ni);
            ans = Math.min(ans, sum[1] + sum[2] + m - k);
            ans = Math.min(ans, sum[0] + sum[2] - m + ni);
            ans = Math.min(ans, sum[0] + sum[2] + ni - k);
            ans = Math.min(ans, sum[0] + sum[1] - m + k);
            ans = Math.min(ans, sum[0] + sum[1] + k - ni);
        }
        return ans;
    }
}
