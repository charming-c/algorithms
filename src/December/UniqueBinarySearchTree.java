package December;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
//        示例:
//
//        输入: 3
//        输出: 5
//        解释:
//        给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

public class UniqueBinarySearchTree {
    //    出现了重叠子问题，我们可以尝试适用备忘录式递归。
    public int numTrees1(int n) {
        int[] record = new int[n + 1];
        record[0] = 1;
        return helper(n, record);
    }

    public int helper(int n, int[] record) {
        if (n == 0 || n == 1) {     // 递归出口
            return 1;
        }
        if (record[n] > 0) {        // 如果计算过了
            return record[n];       // 提前返回结束递归求解，省时省空间
        }
        for (int i = 1; i <= n; i++) {
            record[n] += helper(i - 1, record) * helper(n - i, record);
        }
        return record[n];
    }
//    出现重叠子问题，考虑动态规划，定义dp数组含义。
//
//    dp[i]表示用i个节点构造出的二叉搜索树的方法总数。
//
//    那么状态转移方程为：
//    dp[i] = \sum_{j=0}^{i-1} dp[j] \times dp[i - j - 1]dp[i]=∑
//    j=0
//    i−1
//            ​
//    dp[j]×dp[i−j−1]
//
//    解释：根节点用掉一个数，剩下i-1个，dp[j]用掉j个，只剩下i-j-1个，因此是dp[i-j-1]

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
