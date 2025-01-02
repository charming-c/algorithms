package template;

public class 二分查找 {
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;

        // 开区间 (left, right)
        // 区间没有整数就退出循环
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 关于这里为什么返回的是 right？
        // 在查找的过程中，是一个不断舍弃 left 以左的过程，要知道任何 left 以左包含 left 位置都不符合要求
        // 但是 right 是一个收缩的过程，是对正确结果的一个收缩
        // 当无法收缩的时候，也就是 left + 1 == right
        // left 是需要被舍弃的，而 right 是收缩的极限
        return right;
    }
}
