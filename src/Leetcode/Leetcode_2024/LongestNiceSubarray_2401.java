package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class LongestNiceSubarray_2401 {
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        int ans = 0;
        long num = 0L;

        while (r < len) {
            if((num & nums[r]) == 0) ans = Math.max(r - l + 1, ans);
            else {
                while ((num & nums[r]) != 0) {
                    num ^= nums[l];
                    l++;
                }
            }
            num ^= nums[r];
            r++;
        }
        return ans;
    }
}
