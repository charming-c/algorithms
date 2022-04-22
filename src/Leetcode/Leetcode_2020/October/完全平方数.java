package Leetcode.Leetcode_2020.October;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
//        示例 1:
//
//        输入: n = 12
//        输出: 3
//        解释: 12 = 4 + 4 + 4.
//        示例 2:
//
//        输入: n = 13
//        输出: 2
//        解释: 13 = 4 + 9.

import java.util.Arrays;

public class 完全平方数 {
    public int numSquares1(int n) {
        int len = 0;
        return getLen(n,len);
    }
    //这个函数用于递归，求解可拆分的完全平方数的个数，最少我做不到好吧
    private int getLen(int n , int len){
        if(n == 0){
            return len;
        }
        if(n < 4){
            n = n-1;
            len++;
            return getLen(n,len);
        }else{
            for(int i = n/2; i>1; i--){
                if(((n - i*i) < 2*i+1)&& (i*i <= n)){
                    len++;
                    n = n - i*i;
                    break;
                }
            }
            return getLen(n,len);
        }
    }
    //这里使用动态规划，寻找最优子解
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
}
