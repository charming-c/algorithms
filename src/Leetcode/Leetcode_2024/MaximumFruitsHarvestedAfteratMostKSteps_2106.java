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
//        int left = lowerBound(fruits, startPos - k);
//        int right = left, s = 0, n = fruits.length;
//
//        for (; right < n && fruits[right][0] <= startPos; right++)
//            s += fruits[right][1]; // 从 fruits[left][0] 到 startPos 的水果数
//        int ans = s;
//        for (; right < n && fruits[right][0] <= startPos + k; right++) {
//            s += fruits[right][1]; // 枚举最右位置为 fruits[right][0]
//            while (fruits[right][0] * 2 - fruits[left][0] - startPos > k &&
//                    fruits[right][0] - fruits[left][0] * 2 + startPos > k)
//                s -= fruits[left++][1]; // fruits[left][0] 无法到达
//            ans = Math.max(ans, s); // 更新答案最大值
//        }
//        return ans;
    }

    private int lowerBound(int[][] fruits, int target) {
        int left = -1, right = fruits.length; // 开区间 (left, right)
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // fruits[left][0] < target
            // fruits[right][0] >= target
            int mid = (left + right) >>> 1;
            if (fruits[mid][0] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;
    }
}
