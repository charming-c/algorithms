package Leetcode.Leetcode_2022.February_2022;

import java.util.Arrays;

public class MaximumNumberofAchievableTransferRequests_1601 {
    int[] res;
    int ans = 0;
    int countZero;
    int count = 0;
    int len;
    int n;

    public int maximumRequests(int n, int[][] requests) {
        len = requests.length;
        this.n = n;
        res = new int[n];
        Arrays.fill(res, 0);
        countZero = n;
        dfs(requests, 0);
        return ans;
    }

    public void dfs(int[][] r, int pos) {
        if (pos == len) {
            if (countZero == n)
                ans = Math.max(ans, count);
            return;
        }

        dfs(r, pos + 1);

        int z = countZero;
        int x = r[pos][0];
        int y = r[pos][1];
        countZero -= res[x] == 0 ? 1 : 0;
        countZero += res[x] == 1 ? 1 : 0;
        res[x]--;
        countZero -= res[y] == 0 ? 1 : 0;
        countZero += res[y] == -1 ? 1 : 0;
        res[y]++;
        count++;
        dfs(r, pos + 1);
        res[x]++;
        res[y]--;
        count--;
        countZero = z;
    }
}
