package January_2021;

//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
//
//        连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,3,5,4,7]
//        输出：3
//        解释：最长连续递增序列是 [1,3,5], 长度为3。
//        尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

public class LongestContinuousIncreasingSubsequence_674 {

    // 我终于会写简单的动态规划了
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else dp[i] = 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 暴力解法，实在拉垮
    public int findLengthOfLCIS2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int max = 1;
        int count = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[j - 1]) {
                    count++;
                }
                if (nums[j] <= nums[j - 1]) break;
            }
            max = Math.max(max, count);
            count = 1;
        }
        return max;
    }
}
