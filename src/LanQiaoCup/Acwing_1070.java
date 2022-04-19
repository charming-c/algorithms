package LanQiaoCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing_1070 {

    // 区间dp，真的难顶
    public  static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] res = bufferedReader.readLine().toCharArray();

        int length = res.length;
        int[][] dp = new int[length][length];


        for(int i = 0; i<length; i++) dp[i][i] = 1;

        for(int len = 2; len <= length; len++) {
            for(int i = 0; i<length - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = 0x3f3f3f;
                if(match(res, i, j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j-1]) + 1);

                for(int k = i; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
            }
        }
        System.out.println(dp[0][length - 1]);
    }

    private static boolean match(char[] res, int i, int j) {
        if(res[i] == '(' && res[j] == ')') return true;
        else return res[i] == '[' && res[j] == ']';
    }

}
