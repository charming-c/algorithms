package Leetcode.Leetcode_2024;

import java.util.HashMap;

public class MaximumErasureValue_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        long ans = 0;
        long sum = 0L;
        while (r < len) {
            sum += nums[r];
            map.merge(nums[r++], 1, Integer::sum);
            if(map.keySet().size() == r - l) ans = Math.max(ans, sum);
            else {
                while(l < r && map.keySet().size() != r - l) {
                    sum -= nums[l];
                    map.merge(nums[l], -1, Integer::sum);
                    if(map.get(nums[l]) == 0) map.remove(nums[l]);
                    l++;
                }

            }
        }
        return (int)ans;
    }
}
