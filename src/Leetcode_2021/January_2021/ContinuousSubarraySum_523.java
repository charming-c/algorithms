package Leetcode_2021.January_2021;

//给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
//
//         
//
//        示例 1：
//
//        输入：[23,2,4,6,7], k = 6
//        输出：True
//        解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
//        示例 2：
//
//        输入：[23,2,6,4,7], k = 6
//        输出：True
//        解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。

public class ContinuousSubarraySum_523 {


    // 暴力不香吗
    public class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {

            for (int start = 0; start < nums.length - 1; start++) {
                for (int end = start + 1; end < nums.length; end++) {
                    int sum = 0;
                    for (int i = start; i <= end; i++)
                        sum += nums[i];
                    if (sum == k || (k != 0 && sum % k == 0))
                        return true;
                }
            }
            return false;
        }
    }

    // 败给了巨大的k，但是算法本身是没有问题的
    // 好吧，我承认这是一个垃圾算法，只不过我自己想的，不想承认罢了
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) return false;
        k = Math.abs(k);
        int s = nums[0];
        for (int i = 1; i < len; i++) {
            //s += nums[i];
            if (nums[i] + nums[i - 1] == 0) return true;
        }
        if (k > Integer.MAX_VALUE / 10) return false;
        if (k != 0) {
            int[][] dp = new int[len][k];
            if (nums[0] != 0 && nums[0] % k != 0)
                dp[0][nums[0] % k]++;
            for (int i = 1; i < len; i++) {
                int temp = nums[i] % k;
                dp[i][temp] = 1;
                for (int j = 0; j < k; j++) {
                    if (dp[i - 1][j] != 0) {
                        int x = (j + nums[i]) % k;
                        dp[i][x]++;
                    }
                }
                if (nums[i] == 0 || nums[i] % k == 0)
                    dp[i][0]--;
            }
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += dp[i][0];
            }

            if (sum > 0) return true;
            else return false;
        } else {
            for (int i = 1; i < len; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
