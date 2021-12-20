package Leetcode_2021.November_2021;

public class MinimumSizeSubarraySum_209 {

    // 滑动窗口解法
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int len = nums.length;
        while(left <= right && right < len){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
