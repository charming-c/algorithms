package Leetcode_2021.May_2021;
//给你一个整数数组 nums ，你可以对它进行一些操作。
//
//        每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
//
//        开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//         
//
//        示例 1：
//
//        输入：nums = [3,4,2]
//        输出：6
//        解释：
//        删除 4 获得 4 个点数，因此 3 也被删除。
//        之后，删除 2 获得 2 个点数。总共获得 6 个点数。
//        示例 2：
//
//        输入：nums = [2,2,3,3,3,4]
//        输出：9
//        解释：
//        删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//        之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//        总共获得 9 个点数。

public class DeleteAndEarn_744 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
