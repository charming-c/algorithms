package Leetcode.Leetcode_2022.May_2022;

public class CountNumberofTexts_2266 {
    public int countTexts(String pressedKeys) {
        int len = pressedKeys.length();
        char[] keys = pressedKeys.toCharArray();
        int[] res = new int[]{0,0,3,3,3,3,3,4,3,4};
        int mod = (int) (1e9 + 7);

        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i<len; i++) {
            int tmp = res[Integer.parseInt(String.valueOf(keys[i]))];
            int l = i-1;
            dp[i] = dp[i-1];
            while (l >= 0 && tmp > 1) {
                if(keys[i] == keys[l]) {
                    if(l - 1 > 0)
                        dp[i] = (dp[i] + dp[l-1]) % mod;
                    else dp[i] = (dp[i] + 1) % mod;
                }
                else break;
                l--;
                tmp--;
            }
        }

        return dp[len - 1] % mod;
    }
}
