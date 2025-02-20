package Leetcode.Leetcode_2025;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0 || len == 1) return 0;

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        right[len-1] = height[len-1];

        for(int i = 1; i<len; i++){
            left[i] = Math.max(left[i-1],height[i]);
        }

        for(int j = len - 2; j>=0; j--){
            right[j] = Math.max(right[j+1],height[j]);
        }

        int ans = 0;
        for(int i = 0; i<len; i++){
            ans += Math.min(left[i],right[i]) - height[i];
        }

        return ans;
    }
}
