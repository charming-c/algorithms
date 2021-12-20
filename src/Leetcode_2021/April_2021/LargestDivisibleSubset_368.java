package Leetcode_2021.April_2021;

//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
//        answer[i] % answer[j] == 0 ，或
//        answer[j] % answer[i] == 0
//        如果存在多个有效解子集，返回其中任何一个均可。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[1,2]
//        解释：[1,3] 也会被视为正确答案。
//        示例 2：
//
//        输入：nums = [1,2,4,8]
//        输出：[1,2,4,8]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        Arrays.sort(nums);
        for (int i = 0; i < len; i++)
            Arrays.fill(dp[i], -1);
        dp[0][0] = -1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                    if (dp[i][1] == dp[j][1] + 1) {
                        dp[i][0] = j;
                    }
                    max = Math.max(max, dp[i][1]);
                }
            }
            if (dp[i][1] == -1) {
                dp[i][0] = -1;
                dp[i][1] = 1;
            }
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i][1] == max) {
                index = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (dp[index][0] != -1) {
            ans.add(nums[index]);
            index = dp[index][0];
        }
        ans.add(nums[index]);
        return ans;
    }
}
