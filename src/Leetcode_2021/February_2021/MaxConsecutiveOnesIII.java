package Leetcode_2021.February_2021;

//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
//        返回仅包含 1 的最长（连续）子数组的长度。
//
//         
//
//        示例 1：
//
//        输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        输出：6
//        解释：
//        [1,1,1,0,0,1,1,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 6。

public class MaxConsecutiveOnesIII {

    // 自己理解的滑动窗口，左右都会移动，相当于两次遍历的时间复杂度
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int count = 0, ans = 0;
        while (right < A.length) {
            if (count > K) {
                while (A[left] == 1) {
                    left++;
                }
                if (A[left] == 0) {
                    count--;
                    left++;
                }
            }

            if (A[right] == 0) count++;
            if (count <= K) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }
}

