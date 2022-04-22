package Leetcode.Leetcode_2022.February_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
 * <p>
 * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 * <p>
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * 输出：4
 * 解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
 * 四条花费 7 分钟的路径分别为：
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * 示例 2：
 * <p>
 * 输入：n = 2, roads = [[1,0,10]]
 * 输出：1
 * 解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-arrive-at-destination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NumberofWaystoArriveatDestination_1976 {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new List[n];
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < roads.length; i++) {
            int t = roads[i][2];
            int x = roads[i][0];
            int y = roads[i][1];
            graph[x].add(new int[]{y, t});
            graph[y].add(new int[]{x, t});
        }

        int[][] dist = new int[n][2];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dist[i][0] = INF;
        }

        dist[0][0] = 0;
        dist[0][1] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int cur = p[1], time = p[0];
            if (time > dist[cur][0]) {
                continue;
            }

            for (int[] e : graph[cur]) {
                int cost = dist[cur][0] + e[1];
                int next = e[0];
                if (cost < dist[next][0]) {
                    dist[next][0] = cost;
                    dist[next][1] = dist[cur][1];
                    pq.offer(new int[]{cost, next});
                } else if (cost == dist[next][0]) {
                    dist[next][1] += dist[cur][1];
                    dist[next][1] %= mod;
                }
            }
        }

        return dist[n - 1][1];
    }
}
