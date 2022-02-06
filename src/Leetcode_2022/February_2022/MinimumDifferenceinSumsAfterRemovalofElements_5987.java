package Leetcode_2022.February_2022;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 3 * n 个元素。
 * <p>
 * 你可以从 nums 中删除 恰好 n 个元素，剩下的 2 * n 个元素将会被分成两个 相同大小 的部分。
 * <p>
 * 前面 n 个元素属于第一部分，它们的和记为 sumfirst 。
 * 后面 n 个元素属于第二部分，它们的和记为 sumsecond 。
 * 两部分和的 差值 记为 sumfirst - sumsecond 。
 * <p>
 * 比方说，sumfirst = 3 且 sumsecond = 2 ，它们的差值为 1 。
 * 再比方，sumfirst = 2 且 sumsecond = 3 ，它们的差值为 -1 。
 * 请你返回删除 n 个元素之后，剩下两部分和的 差值的最小值 是多少。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2]
 * 输出：-1
 * 解释：nums 有 3 个元素，所以 n = 1 。
 * 所以我们需要从 nums 中删除 1 个元素，并将剩下的元素分成两部分。
 * - 如果我们删除 nums[0] = 3 ，数组变为 [1,2] 。两部分和的差值为 1 - 2 = -1 。
 * - 如果我们删除 nums[1] = 1 ，数组变为 [3,2] 。两部分和的差值为 3 - 2 = 1 。
 * - 如果我们删除 nums[2] = 2 ，数组变为 [3,1] 。两部分和的差值为 3 - 1 = 2 。
 * 两部分和的最小差值为 min(-1,1,2) = -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-difference-in-sums-after-removal-of-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimumDifferenceinSumsAfterRemovalofElements_5987 {

//    这道题的核心是利用优先队列，去维护一个数组前n位数的最小和和后n位数最大和
//    然后用一个数组表示划分，下标位i，则i前n位数的最小和（包含i），i后n位数的最大和，不包含i
//    最后的结果就只需要用i前的和减去i后的和，结果取最小的就好了
//    其实困难题理清楚的思路也没那么难
    public long minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len / 3;

        PriorityQueue<Integer> ql = new PriorityQueue<>();
        PriorityQueue<Integer> qr = new PriorityQueue<>();
        long[] left = new long[3 * n];
        long[] right = new long[3 * n];
        for (int i = 0; i < 2 * n; i++) {
            ql.offer(-nums[i]);
            if (i > 0)
                left[i] = left[i - 1] + nums[i];
            else left[i] = nums[i];
            int num = 0;
            if (ql.size() > n) {
                num = ql.poll();
                left[i] += num;
            }
        }

        for (int i = 3 * n - 2; i >= n - 1; i--) {
            qr.offer(nums[i + 1]);
            if (i < 3 * n - 2) {
                right[i] = right[i + 1] + nums[i + 1];
            } else right[i] = nums[i + 1];
            int num = 0;
            if (qr.size() > n) {
                num = qr.poll();
                right[i] -= num;
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            ans = Math.min(ans, left[i] - right[i]);
        }
        return ans;
    }
}
