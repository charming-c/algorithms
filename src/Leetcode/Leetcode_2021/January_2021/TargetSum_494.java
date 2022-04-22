package Leetcode.Leetcode_2021.January_2021;

//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
//        返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//         
//
//        示例：
//
//        输入：nums: [1, 1, 1, 1, 1], S: 3
//        输出：5
//        解释：
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        一共有5种方法让最终目标和为3。

public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0) return 0;
        return getMethods(nums, S - nums[0], 0, len - 1) + getMethods(nums, S + nums[0], 0, len - 1);

    }

    public int getMethods(int[] nums, int sum, int depth, int len) {
        if (len == depth && sum == 0) return 1;
        else if (len == depth && sum != 0) return 0;
        else {
            depth++;
            return getMethods(nums, sum + nums[depth], depth, len) + getMethods(nums, sum - nums[depth], depth, len);
        }
    }
}
