package Leetcode.Leetcode_2021.February_2021;

//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
//        我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//         
//
//        示例 1:
//
//        输入: nums = [4,2,3]
//        输出: true
//        解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

public class Non_decreasingArray_665 {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                nums[i] = y;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = x; // 复原
                nums[i + 1] = x;
                return isSorted(nums);
            }
        }
        return true;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
