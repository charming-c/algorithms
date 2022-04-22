package Leetcode.Leetcode_2021.February_2021;

//给定一个二进制数组， 计算其中最大连续1的个数。
//
//        示例 1:
//
//        输入: [1,1,0,1,1,1]
//        输出: 3
//        解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

public class MaxConsecutiveOnes_485 {

    // 动态数组
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        if(nums[0] == 1)
            ans[0] = 1;
        else ans[0] = 0;
        int max = ans[0];
        for(int i = 1; i<len; i++){
            if(nums[i] == 1){
                ans[i] = ans[i-1] + 1;
            }
            else{
                ans[i] = 0;
            }
            max = Math.max(max,ans[i]);
        }
        return max;
    }


    // 滑动窗口
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int len = nums.length;
            int left = 0, right = 0;
            int ans = 0;
            while(right < len){
                if(nums[right] != 1){
                    while(nums[left] == 1){
                        left++;
                    }
                    left++;
                }
                right++;
                ans = Math.max(ans,right - left);

            }
            return ans;
        }
    }
}
