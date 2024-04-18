package Leetcode.Leetcode_2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinimumTimetoVisitDisappearingNodes_3112 {

    public long numberOfSubarrays(int[] nums) {
        long ans = 0;
        int l = 0, r = 0;
        int len = nums.length;
        int max = nums[0];

        while (r < len) {
            max = Math.max(nums[r], max);
            while (l < r && max == nums[r]) {
                if (nums[l] == max && nums[r] == max) {
                    ans++;
                }
                l++;
            }
            if(l == r && nums[r] == max) ans++;
            r++;
        }
        return ans;
    }
}
