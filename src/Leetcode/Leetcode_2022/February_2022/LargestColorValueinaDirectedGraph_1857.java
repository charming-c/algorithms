package Leetcode.Leetcode_2022.February_2022;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。
 * <p>
 * 给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。同时给你一个二维数组 edges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。
 * <p>
 * 图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。
 * <p>
 * 请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
 * 输出：3
 * 解释：路径 0 -> 2 -> 3 -> 4 含有 3 个颜色为 "a" 的节点（上图中的红色节点）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-color-value-in-a-directed-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LargestColorValueinaDirectedGraph_1857 {
    class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            LinkedList<Integer>[] graph = new LinkedList[n];
            int indeg[] = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < edges.length; i++) {
                graph[edges[i][0]].add(edges[i][1]);
                indeg[edges[i][1]]++;
            }

            int[][] dp = new int[n][26];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
            int found = 0;
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int u = queue.poll();
                    found++;
                    dp[u][colors.charAt(u) - 'a']++;
                    for (int c = 0; c < 26; c++)
                        ans = Math.max(ans, dp[u][c]);
                    for (int v : graph[u]) {
                        indeg[v]--;
                        for (int c = 0; c < 26; c++) {
                            dp[v][c] = Math.max(dp[v][c], dp[u][c]);

                        }
                        if (indeg[v] == 0) {
                            queue.offer(v);
                        }
                    }
                }

            }
            if (found != n) return -1;
            return ans;
        }
    }
}
