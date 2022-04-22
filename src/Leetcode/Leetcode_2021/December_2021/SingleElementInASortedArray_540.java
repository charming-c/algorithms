package Leetcode.Leetcode_2021.December_2021;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
//
//        请你找出并返回只出现一次的那个数。
//
//        你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
//
//         
//
//        示例 1:
//
//        输入: nums = [1,1,2,3,3,4,4,8,8]
//        输出: 2

public class SingleElementInASortedArray_540 {
    int ans = 0;
    int len;

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int len = end;
        search(nums, start, end);
        return ans;
    }

    public void search(int[] nums, int start, int end) {

        int mid = (end + start) / 2;
        if (mid == 0 || mid == len || start == end) {
            ans = nums[mid];
            return;
        }
        if (nums[mid] == nums[mid - 1]) {
            if (mid % 2 == 1) {
                search(nums, mid + 1, end);
                return;
            } else {
                search(nums, start, mid - 2);
                return;
            }
        } else if (nums[mid] == nums[mid + 1]) {
            if (mid % 2 == 1) {
                search(nums, start, mid - 1);
                return;
            } else {
                search(nums, mid + 2, end);
                return;
            }
        }
        ans = nums[mid];
        return;
    }
}
