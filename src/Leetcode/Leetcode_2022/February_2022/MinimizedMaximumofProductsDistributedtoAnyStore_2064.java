package Leetcode.Leetcode_2022.February_2022;

import java.util.Arrays;

public class MinimizedMaximumofProductsDistributedtoAnyStore_2064 {
    public int minimizedMaximum(int n, int[] q) {
        Arrays.sort(q);
        int right = q[q.length - 1];
        int left = 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (legal(mid, n, q)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean legal(int max, int n, int[] q) {
        int len = q.length;

        for (int i = 0; i < len; i++) {

            if (q[i] <= max) {
                n--;
                continue;
            } else {
                if (q[i] % max == 0) {
                    n -= q[i] / max;
                } else n -= q[i] / max + 1;
            }

            if (n < 0) return false;
        }
        return true;
    }
}
