package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class KRadiusSubarrayAverages_2090 {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        if(2 * k + 1 > len) return ans;

        int l = 0, r = 0;
        long sum = 0L;

        for(r = 0; r<2 * k + 1; r++) {
            sum += nums[r];
        }
        int cur = k;
        ans[cur++] = (int)Math.floorDiv(sum, 2L * k + 1);

        while (r < len) {
            sum -= nums[l];
            l++;
            sum += nums[r];
            r++;
            ans[cur++] = (int)Math.floorDiv(sum, 2L * k + 1);
        }
        return ans;
    }
}
