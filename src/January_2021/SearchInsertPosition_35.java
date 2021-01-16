package January_2021;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        你可以假设数组中无重复元素。
//
//        示例 1:
//
//        输入: [1,3,5,6], 5
//        输出: 2

public class SearchInsertPosition_35 {
    // 就是简单的二分查找
    // 加油吧
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        return binarySearch(nums, 0, len - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int midth = (start + end) / 2;
            if (target > nums[midth]) {
                return binarySearch(nums, midth + 1, end, target);
            } else if (target < nums[midth]) {
                return binarySearch(nums, start, midth - 1, target);
            } else return midth;
        } else return start;
    }
}

