package April_2021;

import java.util.Arrays;

//给定一个字符串 S，计算 S 的不同非空子序列的个数。
//
//        因为结果可能很大，所以返回答案模 10^9 + 7.
//
//         
//
//        示例 1：
//
//        输入："abc"
//        输出：7
//        解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。

public class DistinctSubsequenceII_940 {

    // 真心不知道自己错在哪里？？？？？？
    class Solution {
        // public int distinctSubseqII(String S) {
        //     int mod = 1000_000_007;
        //     int length = S.length();
        //     int[] dp = new int[length+1];
        //     int[] map = new int[26];
        //     dp[0] = 1;
        //     Arrays.fill(map,-1);
        //     for(int i = 1; i<=length; i++){
        //         if(map[S.charAt(i-1) - 'a'] == -1){
        //             dp[i] = 2 * dp[i-1] % mod;
        //         }
        //         else{
        //             dp[i] = 2*dp[i-1] % mod - dp[map[S.charAt(i-1) - 'a']];
        //         }
        //         map[S.charAt(i-1) -'a'] = i-1;
        //     }
        //     dp[length]--;
        //     if(dp[length] < 0){
        //         dp[length] += mod;
        //     }

        //     return dp[length];
        // }

        public int distinctSubseqII(String S) {
            int MOD = 1_000_000_007;
            int N = S.length();
            int[] dp = new int[N+1];
            dp[0] = 1;

            int[] last = new int[26];
            Arrays.fill(last, -1);

            for (int i = 0; i < N; ++i) {
                int x = S.charAt(i) - 'a';
                dp[i+1] = dp[i] * 2 % MOD;
                if (last[x] >= 0)
                    dp[i+1] -= dp[last[x]];
                dp[i+1] %= MOD;
                last[x] = i;
            }

            dp[N]--;
            if (dp[N] < 0) dp[N] += MOD;
            return dp[N];
        }

    }
}
