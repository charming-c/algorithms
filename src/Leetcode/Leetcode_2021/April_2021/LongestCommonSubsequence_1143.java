package Leetcode.Leetcode_2021.April_2021;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
//        一个字符串的 子序列 是指这样一个新的字符串：
//        它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//        例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//        两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。


public class LongestCommonSubsequence_1143 {
    // 这道题和之前做的一到动态规划的困难题思路基本一样，所以很巧合就写出来了
    // 四月是我的dp月，冲冲冲！！！
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text2.length();
        int n = text1.length();
        if(m == 0 || n == 0) return 0;
        int flag1 = 0,flag2 = 0;
        int[][] dp = new int[m][n];

        for(int i = 0; i<m; i++){
            if(text1.charAt(0) == text2.charAt(i))
                flag1 = 1;

            dp[i][0] = flag1;
        }

        for(int j = 0; j<n; j++){
            if(text1.charAt(j) == text2.charAt(0))
                flag2 = 1;
            dp[0][j] = flag2;
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(text1.charAt(j) != text2.charAt(i)){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j-1]);
                }
            }
        }
        int ans = dp[0][n-1];
        for(int i = 1; i<m; i++){
            ans = Math.max(ans, dp[i][n-1]);
        }
        return ans;
    }
}
