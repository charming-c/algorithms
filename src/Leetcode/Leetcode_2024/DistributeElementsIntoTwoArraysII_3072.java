package Leetcode.Leetcode_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 *
 * 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 *
 * 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 *
 * 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
 * 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
 * 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
 * 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 *
 * 返回整数数组 result 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,3,3]
 * 输出：[2,3,1,3]
 * 解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
 * 在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * 在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
 * 在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
 * 因此，连接形成的数组 result 是 [2,3,1,3] 。
 */

public class DistributeElementsIntoTwoArraysII_3072 {
    public int[] resultArray(int[] nums) {

        List<Integer> arr1Sorted = new ArrayList<>();
        List<Integer> arr2Sorted = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1Sorted.add(nums[0]);
        arr1.add(nums[0]);
        arr2Sorted.add(nums[1]);
        arr2.add(nums[1]);
        for(int i = 2; i < nums.length; i++){
            int count1 = greaterCount(arr1Sorted, nums[i]);
            int count2 = greaterCount(arr2Sorted, nums[i]);
            if(count1 > count2){
                int insert_index = binarySearch(arr1Sorted, nums[i]);
                arr1Sorted.add(insert_index, nums[i]);
                arr1.add(nums[i]);
            }
            else if(count1 < count2){
                int insert_index = binarySearch(arr2Sorted, nums[i]);
                arr2Sorted.add(insert_index, nums[i]);
                arr2.add(nums[i]);
            }
            else{
                if(arr1Sorted.size() <= arr2Sorted.size()){
                    int insert_index = binarySearch(arr1Sorted, nums[i]);
                    arr1Sorted.add(insert_index, nums[i]);
                    arr1.add(nums[i]);
                }
                else{
                    int insert_index = binarySearch(arr2Sorted, nums[i]);
                    arr2Sorted.add(insert_index, nums[i]);
                    arr2.add(nums[i]);
                }
            }
        }

        int[] result = new int[nums.length];
        for(int i = 0 ; i < arr1.size(); i++){
            result[i] = arr1.get(i);
        }

        for(int i = 0 ; i < arr2.size(); i++){
            result[arr1.size() + i] = arr2.get(i);
        }

        return result;
    }

    public int greaterCount(List<Integer> arr, int x){
        int index = binarySearch(arr, x);
        return arr.size() - index;
    }

    public int binarySearch(List<Integer> arr, int x){
        int left = 0;
        int right = arr.size() - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr.get(mid) <= x){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return arr.get(left) > x ? left : left + 1;
    }
}
