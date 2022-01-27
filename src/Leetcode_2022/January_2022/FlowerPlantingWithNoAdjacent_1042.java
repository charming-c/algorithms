package Leetcode_2022.January_2022;

import java.util.LinkedList;
import java.util.List;

/**
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 * <p>
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FlowerPlantingWithNoAdjacent_1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new LinkedList[n];
        int ans[] = new int[n];
        int len = paths.length;

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 根据边用邻接表建图
        for (int i = 0; i < len; i++) {
            graph[paths[i][0] - 1].add(paths[i][1] - 1);
            graph[paths[i][1] - 1].add(paths[i][0] - 1);
        }

        for (int i = 0; i < n; i++) {

            // 对于每个节点的邻接节点，记录已经使用的颜色
            int color[] = new int[5];
            int size = graph[i].size();
            for (int j = 0; j < size; j++) {
                color[ans[graph[i].get(j)]] = 1;
            }
            // 将没有使用的颜色涂上该节点
            for (int j = 1; j < 5; j++) {
                if (color[j] == 0) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
