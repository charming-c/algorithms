package Leetcode.Leetcode_2024;

public class MaximumFruitsHarvestedAfteratMostKSteps_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int size = fruits.length;
        int len = fruits[size - 1][0] + 1;
        int[] res = new int[len];

        for(int i = 0; i<size; i++) {
            res[fruits[i][0]] = fruits[i][1];
        }

        int count = 0;
        int ans = 0;
        int l = Math.max(0, startPos - k);
        int r = l;
        while (r < Math.min(startPos + k + 1, len)) {
            count += res[r];
            int extra = 0;
            if(l < startPos && r > startPos) {
                extra = Math.min(startPos - l, r  - startPos);
            }
            while (r - l + extra > k) {
                count -= res[l++];
                if(l < startPos && r > startPos) {
                    extra = Math.min(startPos - l, r  - startPos);
                }
            }
            ans = Math.max(ans, count);
            r++;
        }
        return ans;
    }
}
