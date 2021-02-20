package February_2021;

//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
//
//        你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
//         
//
//        示例 1：
//
//        输入：[1, 2, 2, 3, 1]
//        输出：2
//        解释：
//        输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//        连续子数组里面拥有相同度的有如下所示:
//        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//        最短连续子数组[2, 2]的长度为2，所以返回2.

import java.util.ArrayList;
import java.util.List;

public class DegreeOfAnArray_697 {

    // 就我的解法这是一道差不多中等难度的题目，但我没有用哈希表，虽然做出来了
    // 但结果还是很糟糕的，没办法，哈希表不会用，虽然我一开始是想用哈希表的
    int dp = 0;

    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int min = 50000;
        List<Integer> list = getNum(nums);
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, getLen(nums, list.get(i)));
        }
        return min;
    }

    public List<Integer> getNum(int[] nums) {
        int len = nums.length;
        int[] ret = new int[50000];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ret[nums[i]]++;
            dp = Math.max(dp, ret[nums[i]]);
        }
        for (int i = 0; i < 50000; i++) {
            if (ret[i] == dp) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int getLen(int[] nums, int ans) {
        int len = nums.length;
        int left = 0, right = 0;
        int count = 0;
        while (right < len) {
            if (nums[right] == ans) {
                count++;
            }
            if (count == dp) {
                while (nums[left] != ans) {
                    left++;
                }
                break;
            }
            right++;
        }
        return right - left + 1;
    }
}
