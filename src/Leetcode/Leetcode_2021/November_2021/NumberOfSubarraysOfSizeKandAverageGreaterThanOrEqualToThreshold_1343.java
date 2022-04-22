package Leetcode.Leetcode_2021.November_2021;

//给你一个整数数组 arr 和两个整数 k 和 threshold 。
//
//        请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
//
//         
//
//        示例 1：
//
//        输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//        输出：3
//        解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。

public class NumberOfSubarraysOfSizeKandAverageGreaterThanOrEqualToThreshold_1343 {
    // 滑动窗口简单题
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, ans = 0;
        int left = 0, right = 0;
        int len = arr.length;
        while(right < len) {
            sum += arr[right];
            if(sum >= k * threshold && right - left + 1 == k)
                ans++;
            if(right - left + 1 == k){
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}
