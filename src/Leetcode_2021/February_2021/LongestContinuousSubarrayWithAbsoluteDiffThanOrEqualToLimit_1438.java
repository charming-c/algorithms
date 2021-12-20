package Leetcode_2021.February_2021;

//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//
//        如果不存在满足条件的子数组，则返回 0 。
//
//         
//
//        示例 1：
//
//        输入：nums = [8,2,4,7], limit = 4
//        输出：2
//        解释：所有子数组如下：
//        [8] 最大绝对差 |8-8| = 0 <= 4.
//        [8,2] 最大绝对差 |8-2| = 6 > 4.
//        [8,2,4] 最大绝对差 |8-2| = 6 > 4.
//        [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//        [2] 最大绝对差 |2-2| = 0 <= 4.
//        [2,4] 最大绝对差 |2-4| = 2 <= 4.
//        [2,4,7] 最大绝对差 |2-7| = 5 > 4.
//        [4] 最大绝对差 |4-4| = 0 <= 4.
//        [4,7] 最大绝对差 |4-7| = 3 <= 4.
//        [7] 最大绝对差 |7-7| = 0 <= 4.
//        因此，满足题意的最长子数组的长度为 2 。

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffThanOrEqualToLimit_1438 {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length && left < nums.length) {
            minQueue.add(nums[right]);
            maxQueue.add(nums[right]);

            if (maxQueue.peek() - minQueue.peek() <= limit) {
                ans = Math.max(ans, right - left + 1);
                right++;
                continue;
            }

            maxQueue.remove((Integer) nums[left]);
            minQueue.remove((Integer) nums[left]);
            left++;
            right++;
        }
        return ans;
    }
}
