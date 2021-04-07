package April_2021;

//给你两个数组 nums1 和 nums2 。
//
//        请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
//
//        数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//        输出：18
//        解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
//        它们的点积为 (2*3 + (-2)*(-6)) = 18 。

public class MaxDotProductOfTwoSubsequences_1458 {

    // 芜湖
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int n = nums1.length;

        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = nums1[0] * nums2[0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j != 0)
                        dp[i][j] = Math.max(dp[i][j - 1], nums1[j] * nums2[i]);
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], nums1[j] * nums2[i]);
                    continue;
                }


                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (nums1[j] * nums2[i] <= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
                } else {
                    int temp = Math.max(dp[i - 1][j - 1] + nums1[j] * nums2[i], nums1[j] * nums2[i]);
                    dp[i][j] = Math.max(dp[i][j], temp);
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    // 其实思路一模一样
    class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[][] f = new int[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int xij = nums1[i] * nums2[j];
                    f[i][j] = xij;
                    if (i > 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                    }
                    if (j > 0) {
                        f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                    }
                    if (i > 0 && j > 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + xij);
                    }
                }
            }

            return f[m - 1][n - 1];
        }
    }


}
