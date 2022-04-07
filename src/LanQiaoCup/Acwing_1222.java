package LanQiaoCup;

import java.io.IOException;
import java.util.Scanner;

public class Acwing_1222 {

    // 区间dp板子题 非常神奇
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        char[] res = str.toCharArray();

        int[][] dp = new int[len][len];

        for(int i = 1; i <= len; i++) {
            for(int l = 0; l + i - 1 < len; l++) {
                int r = l + i - 1;
                if(i == 1) dp[l][r] = 1;
                else {
                    if(res[l] == res[r]) {
                        dp[l][r] = dp[l + 1][r - 1] + 2;
                    }
                    if(dp[l + 1][r] > dp[l][r]) dp[l][r] = dp[l + 1][r];
                    if(dp[l][r - 1] > dp[l][r]) dp[l][r] = dp[l][r - 1];
                }
            }
        }
        System.out.println(len - dp[0][len - 1]);
    }
}
