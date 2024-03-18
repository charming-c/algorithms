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
        int pre = 0;
        int[] next = new int[m];
        Arrays.fill(next, 0);
        for (int i = 1; i < m; i++) {
            while(pre > 0 && pattern[i] != pattern[pre]) {
                pre = next[pre - 1];
            }
            if(pattern[i] == pattern[pre]) {
                pre++;
            }
            next[i] = pre;

        }
        int p = 0;
        int cur = 0;
        int ans = 0;
        while (p < n) {
            if (res[p] == pattern[cur]) {
                p++;
                cur++;
            }
            else if(cur > 0) {
                cur = next[cur - 1];
            }
            else p++;
            if(cur == m) {
                ans++;
                cur = next[cur - 1];
            }

        }
        return ans;
    }
}
