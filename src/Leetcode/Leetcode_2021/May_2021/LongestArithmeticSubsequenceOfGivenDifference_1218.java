package Leetcode.Leetcode_2021.May_2021;

//给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
//
//        子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
//
//         
//
//        示例 1：
//
//        输入：arr = [1,2,3,4], difference = 1
//        输出：4
//        解释：最长的等差子序列是 [1,2,3,4]。
//        示例 2：
//
//        输入：arr = [1,3,5,7], difference = 1
//        输出：1
//        解释：最长的等差子序列是任意单个元素。

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
