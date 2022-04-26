package Leetcode.Leetcode_2022.April_2022;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 persons ，persons[i] 是第 i 个人来看花的时间。
 *
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], persons = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-flowers-in-full-bloom
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NumberofFlowersinFullBloom_6044 {

    /*第 i 个人能看到的花的数目，等价于 start 不晚于 persons i
    ​
      的花的数目，减去 end 早于 persons i
    ​
      的花的数目，即开花数减去凋落数。

    所以单独统计开花时间和凋落时间，排序后二分就得到了答案。

    作者：endlesscheng
    链接：https://leetcode-cn.com/problems/number-of-flowers-in-full-bloom/solution/chai-fen-pythonjavacgo-by-endlesscheng-wz35/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        var starts = Arrays.stream(flowers).mapToInt(f -> f[0]).sorted().toArray();
        var ends = Arrays.stream(flowers).mapToInt(f -> f[1]).sorted().toArray();
        return Arrays.stream(persons).map(p -> lowerBound(starts, p + 1) - lowerBound(ends, p)).toArray();
    }

    int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            var mid = (left + right) / 2;
            if (arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
