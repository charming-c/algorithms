package Leetcode.Leetcode_2022.April_2022;

/**
 * 你需要从空字符串开始 构造 一个长度为 n 的字符串 s ，构造的过程为每次给当前字符串 前面 添加 一个 字符。构造过程中得到的所有字符串编号为 1 到 n ，其中长度为 i 的字符串编号为 si 。
 *
 * 比方说，s = "abaca" ，s1 == "a" ，s2 == "ca" ，s3 == "aca" 依次类推。
 * si 的 得分 为 si 和 sn 的 最长公共前缀 的长度（注意 s == sn ）。
 *
 * 给你最终的字符串 s ，请你返回每一个 si 的 得分之和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babab"
 * 输出：9
 * 解释：
 * s1 == "b" ，最长公共前缀是 "b" ，得分为 1 。
 * s2 == "ab" ，没有公共前缀，得分为 0 。
 * s3 == "bab" ，最长公共前缀为 "bab" ，得分为 3 。
 * s4 == "abab" ，没有公共前缀，得分为 0 。
 * s5 == "babab" ，最长公共前缀为 "babab" ，得分为 5 。
 * 得分和为 1 + 0 + 3 + 0 + 5 = 9 ，所以我们返回 9 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-scores-of-built-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SumofScoresofBuiltStrings_6036 {

    // 解法一：扩展kmp算法 https://oi-wiki.org/string/z-func/
    public long sumScores(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int[] z = new int[len];

        for(int i = 1, l = 0, r = 0; i<len; i++) {
            if(i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            }
            else {
                z[i] = Math.max(0, r - i + 1);
                while(i + z[i] < len && str[z[i]] == str[i + z[i]]) z[i]++;
            }
            if(r < i + z[i] - 1) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        long ans = len;
        for(int i = 1; i<len; i++) {
            ans += z[i];
        }
        return ans;
    }


    // 字符串哈希 + 二分求解
    class Solution {
        //字符串hash+二分
        public long sumScores(String s) {
            //字符串hash计算方法为 * num % mod
            int num = 137, mod = 9999971;
            char[] cs = s.toCharArray();
            int n = cs.length;
            long ans = n;
            //预处理出，以不同字符cs[i]结尾的字符串的hash值
            long[] f = new long[n + 1], c = new long[n + 1];
            c[0] = 1;
            for (int i = 1; i <= n; i++) {
                f[i] = f[i - 1] * num + cs[i - 1] - 'a' + 1;
                f[i] %= mod;
                c[i] = (c[i - 1] * num) % mod;
            }
            //以i开头最长公共前缀
            for (int i = 1; i < n; i++) {
                //以索引i开头的字符串，最短公共前缀为0，最长公共前缀为n-i
                int l = 0, r = n - i;
                //二分答案
                while (l < r) {
                    int mid = l + (r - l + 1) / 2;
                    //t的计算是重点
                    long t = (f[i + mid] - f[i] * c[mid] % mod + mod) % mod;
                    if (t == f[mid]) l = mid;
                    else r = mid - 1;
                }
                ans += l;
            }
            return ans;
        }
    }


}
