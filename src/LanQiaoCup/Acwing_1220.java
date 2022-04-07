package LanQiaoCup;

import java.util.*;
import java.io.*;

public class Acwing_1220 {

    // 树形dp
    private static List<Integer>[] g;
    private static boolean[] visit;
    private static long[] dp;
    private static int[] w;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        g = new List[n];
        visit = new boolean[n];
        dp = new long[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        w = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < n; i++) {
            int[] edg = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = edg[0] - 1;
            int b = edg[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }

        dfs(0);

        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }

    private static void dfs(int cur) {
        dp[cur] = w[cur];
        visit[cur] = true;

        for (int n : g[cur]) {
            if (!visit[n]) {
                dfs(n);
                dp[cur] += Math.max(dp[n], 0);
            }
        }
    }


}
