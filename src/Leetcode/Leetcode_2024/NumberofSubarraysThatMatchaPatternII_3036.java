package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class NumberofSubarraysThatMatchaPatternII_3036 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;

        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1])
                res[i] = 1;
            else if (nums[i] == nums[i + 1])
                res[i] = 0;
            else res[i] = -1;
        }
        int cnt = 0;
        int[] next = new int[m];
        Arrays.fill(next, 0);
        for (int i = 1; i < m; i++) {
            int v = pattern[i];
            while (cnt > 0 && pattern[cnt] != v) {
                cnt = next[cnt - 1];
            }
            if (pattern[cnt] == v) {
                cnt++;
            }
            next[i] = cnt;

        }
        int p = 0;
        int cur = 0;
        int ans = 0;
        while (p < n) {
            if (cur == m) {
                cur = next[cur - 1];
                ans++;
            }
            if (res[p] == pattern[cur]) {
                p++;
                cur++;
                continue;
            } else {
                if (cur == 0) {
                    p++;
                    continue;
                }
                cur = next[cur - 1];
            }

        }
        return ans;
    }
}
