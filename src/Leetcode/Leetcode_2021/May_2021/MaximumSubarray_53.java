package Leetcode.Leetcode_2021.May_2021;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//         
//
//        示例 1：
//
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
//        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

public class MaximumSubarray_53 {
    // 渐渐地，简单题是真的简单，这应该是我能想到的时间和空间最优的算法了
    // 想到了简单做法，题解的分治法也懒得看了。。。
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int pre = nums[0];
        int ans = nums[0];
        int later = 0;
        for(int i = 1; i<len; i++){
            later = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans,later);
            pre = later;
        }
        return ans;
    }
}
