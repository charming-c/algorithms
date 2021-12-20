package Leetcode_2021.February_2021;

public class MaximumAverageSubarrayI_643 {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        double average = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += nums[left + i];
        }
        average = Math.max(average, (double)sum/k);
        left++;
        while(left + k - 1 < len){
            sum -= nums[left-1];
            sum += nums[left + k -1];
            average = Math.max(average, (double)sum/k);
            left++;

        }
        return average;
    }

    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            double average = Integer.MIN_VALUE;
            while(left + k - 1 < len){
                average = Math.max(average, getAverage(nums,left,k));
                left++;
            }
            return average;
        }
        public double getAverage(int[] nums, int left, int k){
            int sum = 0;
            for(int i = 0; i<k; i++){
                sum += nums[left + i];
            }
            return (double) sum/k;
        }
    }
}
