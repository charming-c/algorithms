package March_2021;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
//        字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//
//        题目数据保证答案符合 32 位带符号整数范围。
//
//         
//
//        示例 1：
//
//        输入：s = "rabbbit", t = "rabbit"
//        输出：3
//        解释：
//        如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//        (上箭头符号 ^ 表示选取的字母)
//        rabbbit
//        ^^^^ ^^
//        rabbbit
//        ^^ ^^^^
//        rabbbit
//        ^^^ ^^^

import java.util.Arrays;

public class DistinctSubsequence_115 {

    // 时间：o(n):8%
    // 空间：o(n):6%
    // 至少做出来了，哈哈哈
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++)
            Arrays.fill(dp[i],0);
        if(t.charAt(0) == s.charAt(0)) dp[0][0] = 1;
        for(int i = 1; i<m; i++){
            for(int j = 0; j<n; j++){
                if(t.charAt(j) != s.charAt(i))
                    dp[i][j] = dp[i-1][j];
                if(t.charAt(j) == s.charAt(i))
                    if(j != 0)
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    else
                        dp[i][j] = dp[i-1][j] + 1;
                if(j > i) break;
            }
        }
        return dp[m-1][n-1];
    }
}
