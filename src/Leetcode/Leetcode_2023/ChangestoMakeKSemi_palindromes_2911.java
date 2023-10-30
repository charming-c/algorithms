package Leetcode.Leetcode_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个整数 k ，请你将 s 分成 k 个 子字符串 ，使得每个 子字符串 变成 半回文串 需要修改的字符数目最少。
 *
 * 请你返回一个整数，表示需要修改的 最少 字符数目。
 *
 * 注意：
 *
 * 如果一个字符串从左往右和从右往左读是一样的，那么它是一个 回文串 。
 * 如果长度为 len 的字符串存在一个满足 1 <= d < len 的正整数 d ，len % d == 0 成立且所有对 d 做除法余数相同的下标对应的字符连起来得到的字符串都是 回文串 ，那么我们说这个字符串是 半回文串 。比方说 "aa" ，"aba" ，"adbgad" 和 "abab" 都是 半回文串 ，而 "a" ，"ab" 和 "abca" 不是。
 * 子字符串 指的是一个字符串中一段连续的字符序列。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcac", k = 2
 * 输出：1
 * 解释：我们可以将 s 分成子字符串 "ab" 和 "cac" 。子字符串 "cac" 已经是半回文串。如果我们将 "ab" 变成 "aa" ，它也会变成一个 d = 1 的半回文串。
 * 该方案是将 s 分成 2 个子字符串的前提下，得到 2 个半回文子字符串需要的最少修改次数。所以答案为 1 。
 */

public class ChangestoMakeKSemi_palindromes_2911 {
    public int minimumChanges(String s, int k) {

        // 找到 0～200 每个数的所有因子
        ArrayList[] factor = new ArrayList[201];
        for (int i = 0; i < 201; i++) {
            factor[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < 201; i++) {
            for (int j = i * 2; j < 201; j += i) {
                factor[j].add(i);
            }
        }

        int len = s.length();
        char[] res = s.toCharArray();

        // 找到每个子串变成半回文串要进行修改的次数
        // count[i][j] 从 [i,j) 子串出发
        int[][] count = new int[len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (j < len)
                    count[i][j] = getMinChange(s.substring(i, j).toCharArray(), factor[j - i]);
                else count[i][j] = getMinChange(s.substring(i).toCharArray(), factor[j - i]);
            }
        }

        // dp[i][j] 从 [0,i) 位置分割 j 次 花费的修改最小次数
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 0; i < len + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < k; j++) {
                if (dp[i][j] < Integer.MAX_VALUE) {
                    for (int m = i + 1; m < len + 1; m++) {
                        if (count[i][m] != Integer.MAX_VALUE)
                            dp[m][j + 1] = Math.min(dp[m][j + 1], dp[i][j] + count[i][m]);
                    }
                }
            }
        }
        return dp[len][k];
    }

    private int getMinChange(char[] res, List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = Math.min(isReverse(res, i), min);
        }
        return min;
    }

    private int isReverse(char[] res, int step) {
        int ans = 0;
        int len = res.length;
        if (len == 1) return Integer.MAX_VALUE;
        for (int i = 0; i < step; i++) {
            String s = "";
            for (int j = i; j < len; j += step) {
                s += res[j];
            }
            ans += reverse(s);
        }
        return ans;
    }

    private int reverse(String s) {
        int ans = 0;
        char[] res = s.toCharArray();
        int len = res.length;
        for (int i = 0; i < len / 2; i++) {
            if (res[i] != res[len - 1 - i]) {
                ans++;
            }
        }
        return ans;
    }
}
