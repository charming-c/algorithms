package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class FindtheK_BeautyofaNumber_2269 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length;
        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;
        for(r = 0; r<len; r++) {
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
