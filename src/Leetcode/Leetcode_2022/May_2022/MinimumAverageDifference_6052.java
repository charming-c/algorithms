package Leetcode.Leetcode_2022.May_2022;

public class MinimumAverageDifference_6052 {
    public int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        long[] res = new long[len];
        res[0] = nums[0];
        for(int i = 1; i<len; i++) {
            res[i] = nums[i] + res[i-1];
        }

        int ans = 0;
        long sum = Integer.MAX_VALUE;
        for(int i = 0; i<len-1; i++) {
            long tmp = Math.abs(res[i] / (i + 1) - (res[len - 1] - res[i]) / (len - 1 - i));
            if(tmp < sum) {
                ans = i;
                sum = tmp;
            }
        }
        long t = Math.abs(res[len-1] / len);
        if(t < sum) {
            ans = len-1;
            sum = t;
        }
        return ans;
    }
}
