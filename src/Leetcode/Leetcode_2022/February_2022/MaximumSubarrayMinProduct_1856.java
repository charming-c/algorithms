package Leetcode.Leetcode_2022.February_2022;

import java.util.Stack;

/**
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的 连续 部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaximumSubarrayMinProduct_1856 {

    // 单调栈 + 前缀和 有点难想
    public int maxSumMinProduct(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] leftLower = new int[len];
        int[] rightLower = new int[len];
        long[] sum = new long[len];

        for(int i = len - 1; i>=0; i--) {
            while(!stack1.isEmpty() && nums[stack1.peek()] >= nums[i]) {
                stack1.pop();
            }
            if(!stack1.isEmpty()) {
                rightLower[i] = stack1.peek();
            }
            else rightLower[i] = -1;
            stack1.push(i);
        }
        for(int i = 0; i<len; i++) {
            while(!stack2.isEmpty() && nums[stack2.peek()] >= nums[i]) {
                stack2.pop();
            }
            if(!stack2.isEmpty()) {
                leftLower[i] = stack2.peek();
            }
            else leftLower[i] = -1;
            stack2.push(i);
        }
        sum[0] = nums[0];
        for(int i = 1; i<len; i++) {
            sum[i] += sum[i-1] + nums[i];
        }
        long ans = Long.MIN_VALUE;
        for(int i = 0; i<len; i++) {
            long left = 0;
            long right = sum[len-1];
            if(leftLower[i] != -1) {
                left = sum[leftLower[i]];
            }
            if(rightLower[i] != -1) {
                right = sum[rightLower[i]] - nums[rightLower[i]];
            }

            ans = Math.max(ans, nums[i] * (right - left));
        }
        int a = (int)(ans % 1000000007);
        return a;
    }
}
