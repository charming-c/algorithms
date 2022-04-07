package LanQiaoCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Acwing_1050 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
        streamTokenizer.nextToken();
        int T = (int) streamTokenizer.nval;

        while (T-- > 0) {
            streamTokenizer.nextToken();
            int m = (int) streamTokenizer.nval;
            streamTokenizer.nextToken();
            int n = (int)streamTokenizer.nval;

            int[][] dp = new int[m+1][n+1];

            dp[0][0] = 1;

            for(int i = 0; i<=m; i++) {
                for(int j = 1; j<=n; j++) {

                    dp[i][j] = dp[i][j-1];
                    if(i - j >= 0) dp[i][j] += dp[i-j][j];
                }
            }

            System.out.println(dp[m][n]);
        }

    }

}
