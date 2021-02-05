package Leetcode_2020.November;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        示例:
//
//        输入: [0,1,0,3,12]
//        输出: [1,3,12,0,0]

public class 移动零 {
    //解法一：双指针
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != 0) continue;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == 0) continue;
                int x = nums[i];
                nums[i] = nums[j];
                nums[j] = x;
                break;
            }
        }
    }
    //这个是自己写的破产的算法，无法处理全部是零的数组
    //     int len = nums.length;
    //     for(int i = 0; i<len; i++){
    //         if(nums[i] != 0) continue;
    //         int j = i;
    //         while(j<len-i-1){
    //             nums[j++] = nums[j];
    //         }
    //         nums[j] = 0;
    //         if(nums[i] == 0 && i<j){
    //             --i;
    //             continue;
    //         }
    //     }
    // }

    //标答：
//    使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
//
//    右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
//
//    注意到以下性质：
//
//    左指针左边均为非零数；
//
//    右指针左边直到左指针处均为零。
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}
