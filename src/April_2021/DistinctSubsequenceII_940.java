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

            // 这里默认第零个位置为空字符，数值为1，那么申请的数组内存大小就是N+1
            int[] dp = new int[N + 1];
            dp[0] = 1;

            // 这里其实就是生成一处索引，记录所有字符出现的位置，方便在需要的时候找到M-1的位置
            int[] last = new int[26];
            // 将初值赋值为-1
            Arrays.fill(last, -1);

            // 这里依次遍历目标字符串
            for (int i = 0; i < N; ++i) {
                // 先确定在last里出现的那个位置的字母
                int x = S.charAt(i) - 'a';

                // 二话不说先将其前一个位置乘一倍
                dp[i + 1] = dp[i] * 2 % MOD;

                // 如果之前这个字符出现过，那么就要减去出现的位置数值
                if (last[x] >= 0)
                    dp[i + 1] -= dp[last[x]];
                dp[i + 1] %= MOD;
                // 每次都要刷新一下位置，因为是要找里N位置最近的出现的相同字符
                last[x] = i;
            }
            // 这里注意一下这里的i其实是对应与N-1哟

            // 多算了一个""字符，减去
            dp[N]--;
            // 如果算出负数加上模就好了
            if (dp[N] < 0) dp[N] += MOD;
            return dp[N];
        }

    }
}
