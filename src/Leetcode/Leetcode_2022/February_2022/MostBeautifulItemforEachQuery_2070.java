package Leetcode.Leetcode_2022.February_2022;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


/**
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 *
 * 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。
 *
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
 * 输出：[2,4,5,5,6,6]
 * 解释：
 * - queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
 * - queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
 *   它们中的最大美丽值为 4 。
 * - queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
 *   它们中的最大美丽值为 5 。
 * - queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
 *   所以，答案为所有物品中的最大美丽值，为 6 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-beautiful-item-for-each-query
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostBeautifulItemforEachQuery_2070 {


    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (o, p) -> o[0] - p[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>(Map.of(0, 0));
        int max = 0, result[] = new int[queries.length];
        for (int[] item : items) {
            map.put(item[0], max = Math.max(max, item[1]));
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.floorEntry(queries[i]).getValue();
        }
        return result;
    }

}
