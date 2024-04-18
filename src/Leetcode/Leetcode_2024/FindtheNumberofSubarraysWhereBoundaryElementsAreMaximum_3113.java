package Leetcode.Leetcode_2024;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindtheNumberofSubarraysWhereBoundaryElementsAreMaximum_3113 {
    public long numberOfSubarrays(int[] nums) {
        long ans = nums.length;
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{Integer.MAX_VALUE, 0}); // 无穷大哨兵
        for (int x : nums) {
            while (x > st.peek()[0]) {
                st.pop();
            }
            if (x == st.peek()[0]) {
                ans += st.peek()[1]++;
            } else {
                st.push(new int[]{x, 1});
            }
        }
        return ans;
    }
}
