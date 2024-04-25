package Leetcode.Leetcode_2024;

import java.util.HashMap;
import java.util.List;

public class MaximumSumofAlmostUniqueSubarray_2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        int len = nums.size();
        int l = 0, r = 0;
        long count = 0l;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(r = 0; r<k; r++) {
            map.put(nums.get(r), map.getOrDefault(nums.get(r), 0) + 1);
            count += nums.get(r);
        }
        long ans = 0l;
        if(map.keySet().size() >= m) ans = Math.max(count, ans);

        while (r < len) {
            count -= nums.get(l);
            System.out.println(l);
            if(map.get(nums.get(l)) == 1) map.remove(nums.get(l));
            else map.put(nums.get(l), map.get(nums.get(l)) - 1);
            l++;

            count += nums.get(r);
            map.put(nums.get(r), map.getOrDefault(nums.get(r), 0) + 1);
            if(map.keySet().size() >= m)
                ans = Math.max(count, ans);
            r++;
        }
        return ans;
    }
}
