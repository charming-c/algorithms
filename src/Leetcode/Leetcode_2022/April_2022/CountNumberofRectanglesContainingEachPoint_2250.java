package Leetcode.Leetcode_2022.April_2022;

import java.util.*;

/**
 * 给你一个二维整数数组 rectangles ，其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi 。给你一个二维整数数组 points ，其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点。
 *
 * 第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi) 。
 *
 * 请你返回一个整数数组 count ，长度为 points.length，其中 count[j]是 包含 第 j 个点的矩形数目。
 *
 * 如果 0 <= xj <= li 且 0 <= yj <= hi ，那么我们说第 i 个矩形包含第 j 个点。如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
 * 输出：[2,1]
 * 解释：
 * 第一个矩形不包含任何点。
 * 第二个矩形只包含一个点 (2, 1) 。
 * 第三个矩形包含点 (2, 1) 和 (1, 4) 。
 * 包含点 (2, 1) 的矩形数目为 2 。
 * 包含点 (1, 4) 的矩形数目为 1 。
 * 所以，我们返回 [2, 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-rectangles-containing-each-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class CountNumberofRectanglesContainingEachPoint_2250 {

     // 按照y轴的大小逐步插入排序，然后二分查找
    public int[] countRectangles(int[][] rectangles, int[][] points) {

        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i<points.length; i++) {
            map.put((((long)points[i][0]) << 31) + points[i][1], i);
        }
        Arrays.sort(rectangles, (a, b) -> {
            return b[1] - a[1];
        });

        Arrays.sort(points, (a, b) -> {
            return b[1] - a[1];
        });

        int len = points.length;
        int[] ans = new int[len];

        List<Integer> list = new ArrayList<>();
        int cur = 0;
        for(int i = 0; i<len; i++) {
            int temp = cur;
            while(cur < rectangles.length && rectangles[cur][1] >= points[i][1]) {
                list.add(rectangles[cur][0]);
                cur++;
            }
            if(cur > temp)
                Collections.sort(list);
            int pivot = points[i][0];
            int l = 0, r = list.size();
            while(l < r) {
                int mid = l + r >> 1;
                if(list.get(mid) < pivot) {
                    l = mid + 1;
                }
                else r = mid;
            }
            long k = (((long)points[i][0]) << 31) + points[i][1];
            ans[map.get(k)] = list.size() - l;
        }
        return ans;
    }
}
