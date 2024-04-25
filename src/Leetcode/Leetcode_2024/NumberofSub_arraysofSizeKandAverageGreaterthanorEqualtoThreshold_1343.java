package Leetcode.Leetcode_2024;

public class NumberofSub_arraysofSizeKandAverageGreaterthanorEqualtoThreshold_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int l = 0, r = 0;
        double sum = 0;
        int ans = 0;
        for(r = 0; r<k; r++) {
            sum += arr[r];
        }
        if(sum / k >= threshold) ans++;

        while (r < len) {
            sum -= arr[l];
            l++;
            sum += arr[r];
            r++;
            if(sum / k >= threshold) ans++;
        }
        return ans;
    }
}
