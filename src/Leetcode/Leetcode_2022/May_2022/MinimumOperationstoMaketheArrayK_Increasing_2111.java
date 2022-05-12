package Leetcode.Leetcode_2022.May_2022;

import java.util.ArrayList;
import java.util.List;

public class MinimumOperationstoMaketheArrayK_Increasing_2111 {
    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            int j = i;
            while (j < arr.length) {
                list.add(arr[j]);
                j += k;
            }
            Integer[] nums = list.toArray(new Integer[list.size()]);
            int temp = lengthOfLIS(nums);
            ans += nums.length - temp;
        }
        return ans;
    }

    public int lengthOfLIS(Integer[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] >= d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] <= nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
