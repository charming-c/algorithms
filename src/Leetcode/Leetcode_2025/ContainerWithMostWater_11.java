package Leetcode.Leetcode_2025;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int ans = 0;

        while (l < r) {
            int min = Math.min(height[l], height[r]);
            ans = Math.max(ans, (r - l) * min);
            if(height[l] == min) l++;
            else r--;
        }
        return ans;
    }
}
