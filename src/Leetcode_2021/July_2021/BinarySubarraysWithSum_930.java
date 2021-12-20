package Leetcode_2021.July_2021;

//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
//
//        子数组 是数组的一段连续部分。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,0,1,0,1], goal = 2
//        输出：4
//        解释：
//        有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
//        示例 2：
//
//        输入：nums = [0,0,0,0,0], goal = 0
//        输出：15

public class BinarySubarraysWithSum_930 {
    // 美妙超时，爽歪歪
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int length = nums.length;
        int count = 0;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        for (int i = 0; i < length; i++) {
            if (dp[i] == goal) count++;
            for (int j = 0; j < i; j++) {
                if (dp[i] - dp[j] == goal)
                    count++;
            }
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        // left1与left2之间夹着的是很多个0
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;

        // 右边界
        while (right < n) {
            sum1 += nums[right];
            // sum1 要等于 goal-1
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            // sum2 要等于 goal
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            // 其中的每个0都能算一种情况
            res += left2 - left1;
            // 右指针右移
            right++;
        }
        return res;
    }


}
