package October;
//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
//
//        示例 1：
//
//        输入：[1,2,5,9,5,9,5,5,5]
//        输出：5
//

public class 主要元素 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (nums[i] > nums[j]) {
                    int x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                }
            }
        }
        for (int i = 0; i <= len / 2; i++) {
            while (nums[i] == nums[i + len / 2]) {
                return nums[i];
            }
        }
        return -1;
    }
}
