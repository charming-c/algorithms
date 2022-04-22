package Leetcode.Leetcode_2021.November_2021;

//给你一个二进制数组 nums ，你需要从中删掉一个元素。
//
//        请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
//        如果不存在这样的子数组，请返回 0 。
//
//         
//
//        提示 1：
//
//        输入：nums = [1,1,0,1]
//        输出：3
//        解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。


public class LongestSubarrayof1sAfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left[] = new int[len];
        int right[] = new int[len];

        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == 1) {
                left[i] = left[i - 1] + 1;
            } else left[i] = 0;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] == 1) {
                right[i] = right[i + 1] + 1;
            } else right[i] = 0;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, right[i] + left[i]);
        }
        return ans;
    }


    // 滑动窗口
    public int longestSubarray2(int[] nums) {
        int n = nums.length;
        //左边界l ， 初始化为0 ， 右边界r ， 初始化为0
        int l = 0 , r = 0;
        //0的个数
        int num = 0;
        while(r < n){
            if(nums[r] == 0) num++;
            //左边界条件右移
            if(num >= 2){
                if(nums[l++] == 0) num--;
            }
            //右边界持续右移
            r++;
        }
        //一定需要删除元素
        return r - l - 1;
    }
}
