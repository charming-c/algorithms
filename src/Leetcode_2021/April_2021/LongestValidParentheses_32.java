package Leetcode_2021.April_2021;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//         
//
//        示例 1：
//
//        输入：s = "(()"
//        输出：2
//        解释：最长有效括号子串是 "()"
//        示例 2：
//
//        输入：s = ")()())"
//        输出：4
//        解释：最长有效括号子串是 "()()"

import java.util.Arrays;

public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || len == 1) return 0;

        int[] dp = new int[len];
        Arrays.fill(dp, 0);

        if (s.charAt(0) == '(' && s.charAt(1) == ')') dp[1] = 2;
        int ans = dp[1];

        for (int i = 2; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                }

                if (s.charAt(i - 1) == ')') {
                    if (i - dp[i - 1] - 1 > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                    if (i - dp[i - 1] - 1 == 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                    }
                }

                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
