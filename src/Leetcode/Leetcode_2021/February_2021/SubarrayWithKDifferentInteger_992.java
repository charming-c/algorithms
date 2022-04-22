package Leetcode.Leetcode_2021.February_2021;

public class SubarrayWithKDifferentInteger_992 {

    // 这题虽然是个困难题，但是思路理清其实不难的
    // 虽然思路我是看题解的
    // 这个月滑动窗口做腻了。我想做动态规划
    public int subarrayWithKDistinct(int[] A, int K) {
        return search(A, K) - search(A, K - 1);
    }

    public int search(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];
        int count = 0;
        int ret = 0;

        int left = 0, right = 0;
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                if (freq[A[left]] == 1) {
                    count--;
                }
                freq[A[left]]--;
                left++;
            }
            ret += right - left;
        }
        return ret;
    }
}
