package Leetcode.Leetcode_2021.April_2021;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//         
//
//        示例 1：
//
//
//
//        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        输出：6
//        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。


public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0 || len == 1) return 0;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        right[len-1] = height[len-1];

        for(int i = 1; i<len; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }

        for(int j = len - 2; j>=0; j--){
            right[j] = Math.max(right[j+1],height[j]);
        }

        int ans = 0;
        for(int i = 0; i<len; i++){
            ans += Math.min(left[i],right[i]) - height[i];
        }

        return ans;
    }
}
