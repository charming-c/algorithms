package Leetcode.Leetcode_2024;

import java.util.HashMap;

public class LengthofLongestSubarrayWithatMostKFrequency_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < len) {
            map.merge(nums[r], 1, Integer::sum);
            if(map.get(nums[r]) > k) {
                while (map.get(nums[r]) > k) {
                    map.merge(nums[l++], -1, Integer::sum);
                }
            }
            else ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}
