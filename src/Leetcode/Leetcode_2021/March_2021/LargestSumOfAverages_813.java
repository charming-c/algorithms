package Leetcode.Leetcode_2021.March_2021;

//我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
//
//        注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
//
//        示例:
//        输入:
//        A = [9,1,2,3,9]
//        K = 3
//        输出: 20
//        解释:
//        A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
//        我们也可以把 A 分成[9, 1], [2], [3, 9].
//        这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.

public class LargestSumOfAverages_813 {

    // 我又没有自信了。。。
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[] P = new double[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        double[] dp = new double[N];
        for (int i = 0; i < N; ++i)
            dp[i] = (P[N] - P[i]) / (N - i);

        for (int k = 0; k < K - 1; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = i + 1; j < N; ++j)
                    dp[i] = Math.max(dp[i], (P[j] - P[i]) / (j - i) + dp[j]);

        return dp[0];
    }
}
