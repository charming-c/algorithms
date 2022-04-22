package Leetcode.Leetcode_2021.January_2021;

//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//        示例 1:
//
//        输入: [1,2,3]
//        输出: 6
//        示例 2:
//
//        输入: [1,2,3,4]
//        输出: 24

import java.util.Arrays;

public class MaximumProductOfThreeNumbers_628 {

    // 最近最简单的每日一题
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        int a, b, c;
        Arrays.sort(nums);
        if (length == 3) return nums[0] * nums[1] * nums[2];
        else {
            return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3],
                    nums[0] * nums[1] * nums[length - 1]);
        }
    }
}
