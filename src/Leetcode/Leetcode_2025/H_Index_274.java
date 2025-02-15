package Leetcode.Leetcode_2025;

import java.util.Arrays;

public class H_Index_274 {
    public int hIndex(int[] citations) {
        int len = citations.length;

        Arrays.sort(citations);
        int l = 0;
        int r = citations[len - 1];
        while (l < r) {
            int mid = (l + r + 1) / 2;
            int count = bs(citations, mid);
            System.out.println(mid);
            if(count >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int bs(int[] citations, int num) {
        int len = citations.length;
        int l = 0;
        int r = len - 1;

        if (num <= citations[0]) return len;
        if (num > citations[len - 1]) return 0;

        while (l < r) {
            int mid = (l + r + 1) / 2;
            if(citations[mid] < num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (r < 0) return len;
        if (l > len - 1) return 0;
        System.out.println(r);
        return len - r - 1;
    }
}
