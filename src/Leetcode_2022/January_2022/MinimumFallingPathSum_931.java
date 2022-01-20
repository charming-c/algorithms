package Leetcode_2022.January_2022;

import java.util.Arrays;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗+斜体标注：
 * [[2,1,3],      [[2,1,3],
 * [6,5,4],       [6,5,4],
 * [7,8,9]]       [7,8,9]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimumFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int ret[] = new int[len];
        Arrays.fill(ret, 0);

        for (int i = 0; i < len; i++) {
            ret[i] = matrix[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            int temp[] = new int[len];
            for (int j = 0; j < len; j++) {
                temp[j] = ret[j];
                if (j - 1 >= 0) {
                    temp[j] = Math.min(temp[j], ret[j - 1]);
                }
                if (j + 1 < len) {
                    temp[j] = Math.min(temp[j], ret[j + 1]);
                }
                temp[j] += matrix[i][j];
            }
            ret = (int[]) Arrays.copyOf(temp, len);
        }

        int ans = ret[0];
        for (int i = 1; i < len; i++) {
            ans = Math.min(ans, ret[i]);
        }
        return ans;
    }

}
