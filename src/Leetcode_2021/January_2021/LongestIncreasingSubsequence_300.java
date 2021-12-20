package Leetcode_2021.January_2021;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//        子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//         
//        示例 1：
//
//        输入：nums = [10,9,2,5,3,7,101,18]
//        输出：4
//        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

public class LongestIncreasingSubsequence_300 {

    // 我这里用了一个数组，从头开始遍历数组，然后逐步填充数组里的数字
    // 没想到一下就想出来了
    // 动态规划，不过如此，哈哈哈
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] list = new int[length];
        for(int i = 0; i<length; i++){
            list[i] = 0;
        }
        for(int i = 0; i<length-1; i++){
            for(int j = i+1; j<length; j++){
                if(nums[i] < nums[j]){
                    list[j] = Math.max(list[j],list[i] + 1);
                }
            }
        }
        return getMax(list)+1;
    }
    public int getMax(int[] nums){
        int max = nums[0];
        int length = nums.length;
        for(int i = 0; i<length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }

    // 官方题解和我的基本一样，但是额外利用一个变量maxans，利用这个变量在填充数组的过程中动态保存最大的值
    // 还有解释在遍历数组时就给新开辟的动态规划数组赋初值，这些基本的技巧我还要多学习
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }
            return maxans;
        }
    }
}
