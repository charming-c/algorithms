package template;

public class 滑动窗口_不定长版 {

    /**
     * 这类题目一般是求一个最长的持有某个属性的子数组
     * 核心思想就是：当前已经求得一个符合要求的窗口，则继续以这个窗口大小右移，
     * 直到找到下一个符合要求的子数组，并更新状态，或者直接到数组结尾
     */
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;

        // 维护子数组的性质
        int count = 0;
        // 答案
        int ans = 0;
        while (r < len) {
            // 滑动窗口右边，更新状态
            if(nums[r++] == 0) count++;
            // 在当前窗口下是否满足性质，若满足就更新答案
            if(count <= 1) {
                ans = Math.max(ans, r - l);
            }
            // 不满足性质，则左边窗口左移
            else {
                if(nums[l] == 0) count--;
                l++;
            }

        }
        return ans;
    }
}
