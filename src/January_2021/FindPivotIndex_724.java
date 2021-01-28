package January_2021;

//给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
//
//        我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
//
//        如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
//
//         
//
//        示例 1：
//
//        输入：
//        nums = [1, 7, 3, 6, 5, 6]
//        输出：3
//        解释：
//        索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//        同时, 3 也是第一个符合要求的中心索引。

import java.util.Queue;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        if (len == 0) return -1;
        if (len == 1) return 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int left = 0;
        int right = 0;
        for (int j = 0; j < len; j++) {
            left += nums[j];
            right = sum - left + nums[j];
            if (left == right) return j;
        }
        return -1;
    }

    class Solution {
        public int pivotIndex(int[] nums) {
            int len = nums.length;
            if (len == 0) return -1;
            if (len == 1) return 0;
            for (int i = 0; i < len; i++) {
                if (midSearch(nums, i, len) >= 0) return i;
            }
            return -1;
        }

        public int midSearch(int[] nums, int mid, int len) {
            int preSum = 0;
            int subSum = 0;
            for (int i = 0; i < mid; i++) {
                preSum += nums[i];
            }
            for (int j = mid + 1; j < len; j++) {
                subSum += nums[j];
            }
            if (preSum == subSum) return mid;
            else return -1;
        }
    }
}

