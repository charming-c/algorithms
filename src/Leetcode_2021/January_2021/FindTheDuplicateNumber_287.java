package Leetcode_2021.January_2021;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
//        假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,3,4,2,2]
//        输出：2

public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        quickSort(nums,0,length-1);
        for(int i = 0; i<length-2; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return nums[length-1];
    }
    public void quickSort(int[] nums, int left, int right){
        if(left <= right){
            int midth = (left+right)/2;
            int i = left;
            int j = right;
            int pivot = nums[i];
            while(true){
                // 从左向右找到第一个比基准大的
                while( i<=j && nums[i] <= pivot) i++;
                // 从右向左找到第一个比基准小的
                while( j>=i && nums[j] >= pivot) j--;

                // 若位置i，j重叠，则终止循环
                if(i >= j) break;

                // i,j位置的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            nums[left] = nums[j];
            nums[j] = pivot;
            quickSort(nums,left,j-1);
            quickSort(nums,j+1,right);
        }
        else return;
    }
}
