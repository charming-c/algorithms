package Leetcode.Leetcode_2022.May_2022;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 算法好久不写，真的手生了好多
public class SubarrayProductLessThanK_713 {

    // 带前缀和的二分，稍微有点绕
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int len = nums.length;
        if(k == 0) return 0;

        double logk = Math.log(k);

        double[] pre = new double[len + 1];
        pre[0] = 0.0;
        for(int i = 1; i<=len; i++) {
            pre[i] = pre[i-1] + Math.log(nums[i-1]);
        }

        int ans = 0;
        for(int e = 1; e <= len; e++) {
            int l = 0, r = e;
            double val = pre[e] - logk + 1e-10;
            while (l < r) {
                int mid = l + r >> 1;
                if(pre[mid] < val) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            }

            ans += e - r;
        }
        return ans;
    }

    // 滑动窗口，有点生疏了
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = 0;
        int res = 1;
        int ans = 0;
        while(r < len && l <= r) {
            res *= nums[r];
            while (l < r && res >= k) {
                res /= nums[l];
                l++;
            }
            if(res < k)
                ans += r - l + 1;
            r++;
        }
        return ans;
    }
}

