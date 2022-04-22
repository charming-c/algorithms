package Leetcode.Leetcode_2022.February_2022;

/**
 * 给你一个下标从 0 开始的二进制字符串 s ，表示一个列车车厢序列。s[i] = '0' 表示第 i 节车厢 不 含违禁货物，而 s[i] = '1' 表示第 i 节车厢含违禁货物。
 * <p>
 * 作为列车长，你需要清理掉所有载有违禁货物的车厢。你可以不限次数执行下述三种操作中的任意一个：
 * <p>
 * 从列车 左 端移除一节车厢（即移除 s[0]），用去 1 单位时间。
 * 从列车 右 端移除一节车厢（即移除 s[s.length - 1]），用去 1 单位时间。
 * 从列车车厢序列的 任意位置 移除一节车厢，用去 2 单位时间。
 * 返回移除所有载有违禁货物车厢所需要的 最少 单位时间数。
 * <p>
 * 注意，空的列车车厢序列视为没有车厢含违禁货物。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1100101"
 * 输出：5
 * 解释：
 * 一种从序列中移除所有载有违禁货物的车厢的方法是：
 * - 从左端移除一节车厢 2 次。所用时间是 2 * 1 = 2 。
 * - 从右端移除一节车厢 1 次。所用时间是 1 。
 * - 移除序列中间位置载有违禁货物的车厢。所用时间是 2 。
 * 总时间是 2 + 1 + 2 = 5 。
 * <p>
 * 一种替代方法是：
 * - 从左端移除一节车厢 2 次。所用时间是 2 * 1 = 2 。
 * - 从右端移除一节车厢 3 次。所用时间是 3 * 1 = 3 。
 * 总时间也是 2 + 3 = 5 。
 * <p>
 * 5 是移除所有载有违禁货物的车厢所需要的最少单位时间数。
 * 没有其他方法能够用更少的时间移除这些车厢。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-remove-all-cars-containing-illegal-goods
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MinimumTimetoRemoveAllCarsContainingIllegalGoods_6003 {

//    动态规划yyds
//    怎么觉得双周赛的题目比周赛还要难点
//    唉。困难题感觉这辈子做不出来
    public int minimumTime(String s) {
        char[] res = s.toCharArray();
        int len = res.length;
        int left[] = new int[len + 1];
        int right[] = new int[len + 1];

        if (res[0] == '1') left[0] = 1;
        else left[0] = 0;
        for (int i = 1; i < len; i++) {
            if (res[i] == '0') {
                left[i] = left[i - 1];
            } else left[i] = Math.min(left[i - 1] + 2, i + 1);
        }

        for (int i = len - 1; i >= 0; i--) {
            if (res[i] == '0') {
                right[i] = right[i + 1];
            } else right[i] = Math.min(right[i + 1] + 2, len - i);
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, right[0]);
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, left[i] + right[i + 1]);
        }
        return ans;
    }
}
