package Leetcode.Leetcode_2024;

import java.util.HashMap;
import java.util.List;

public class FindtheLongestEqualSubarray_2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int count = 0;
        int len = nums.size();
        while (r < len) {
            map.merge(nums.get(r), 1, Integer::sum);
            count = Math.max(count, map.get(nums.get(r)));
            if(r - l + 1 - count > k) {
                map.merge(nums.get(l++), -1, Integer::sum);
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;

    }
}
