package Leetcode.Leetcode_2021.April_2021;

//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
//
//        "AAJF" ，将消息分组为 (1 1 10 6)
//        "KJF" ，将消息分组为 (11 10 6)
//        注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
//
//        给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
//
//        题目数据保证答案肯定是一个 32 位 的整数。
//
//         
//
//        示例 1：
//
//        输入：s = "12"
//        输出：2
//        解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//        示例 2：
//
//        输入：s = "226"
//        输出：3
//        解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

public class DecodeWays_91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        if (s.charAt(0) == '0')
            return 0;
        else dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '2' || s.charAt(i - 1) == '1') {
                    if (i >= 2)
                        dp[i] = dp[i - 2];
                    else dp[i] = 1;
                } else return 0;
            } else {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    if ((s.charAt(i) <= '6' || s.charAt(i - 1) == '1') && i - 2 >= 0) dp[i] = dp[i - 1] + dp[i - 2];
                    else {
                        if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                            dp[i] = dp[i - 1] + 1;
                        else if (s.charAt(i - 1) == '1') dp[i] = dp[i - 1] + 1;
                        else dp[i] = dp[i - 1];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[len - 1];
    }

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; ++i) {
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                }
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    f[i] += f[i - 2];
                }
            }
            return f[n];
        }
    }

}
