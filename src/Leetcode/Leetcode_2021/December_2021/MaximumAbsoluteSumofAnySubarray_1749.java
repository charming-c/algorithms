package Leetcode.Leetcode_2021.December_2021;
/*
给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。

请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。

abs(x) 定义如下：

如果 x 是负整数，那么 abs(x) = -x 。
如果 x 是非负整数，那么 abs(x) = x 。
 

示例 1：

输入：nums = [1,-3,2,3,-4]
输出：5
解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。

 */

public class MaximumAbsoluteSumofAnySubarray_1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int ret[][] = new int[n][2];

        ret[0][0] = nums[0];
        ret[0][1] = 0;

        for (int i = 1; i < n; i++) {
            ret[i][0] = Math.max(ret[i - 1][0] + nums[i], nums[i]);
            ret[i][1] = Math.max(ret[i - 1][0], ret[i - 1][1]);
        }

        int max = Math.max(ret[n - 1][0], ret[n - 1][1]);

        for (int i = 1; i < n; i++) {
            ret[i][0] = Math.min(ret[i - 1][0] + nums[i], nums[i]);
            ret[i][1] = Math.min(ret[i - 1][0], ret[i - 1][1]);
        }

        int min = Math.min(ret[n - 1][0], ret[n - 1][1]);

        return Math.max(Math.abs(max), Math.abs(min));
    }

    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int length = nums.length;
            if (length < 2) return Math.abs(nums[0]);
            int max = nums[0], min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
                if (nums[i] > max) {
                    max = nums[i];
                } else if (nums[i] < min) {
                    min = nums[i];
                }
            }
            return Math.max(max - min, Math.max(Math.abs(min), Math.abs(max)));
        }
    }


}
