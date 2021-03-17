package extend;

import java.util.Arrays;
import java.util.Scanner;

public class test5 {
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++)
            Arrays.fill(dp[i],0);
        if(t.charAt(0) == s.charAt(0)) dp[0][0] = 1;
        for(int i = 1; i<m; i++){
            for(int j = 0; j<n; j++){
                if(t.charAt(j) != s.charAt(i))
                    dp[i][j] = dp[i-1][j];
                if(t.charAt(j) == s.charAt(i))
                    if(j != 0)
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    else
                        dp[i][j] = dp[i-1][j] + 1;
                if(j > i) break;
            }

        }
        for(int i = 0; i<m; i++){
            for (int j  = 0; j<n; j++){
                System.out.print(" " + dp[i][j]);
            }
            System.out.print("\n");
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        String s = "babgbag";
        String t = "bag";
        numDistinct(s,t);
//        System.out.println("please input your grade:");
//        Scanner scanner = new Scanner(System.in);
//        int grade = scanner.nextInt();
//        if(grade < 90){
//            if(grade < 60)
//                System.out.println("C");
//            else System.out.println("B");
//        }
//        else System.out.println("A");
    }
}
