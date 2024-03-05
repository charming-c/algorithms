package Leetcode.Leetcode_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
 *
 * 同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。
 *
 * 一开始你的分数为 0 ，每次操作中，你将执行：
 *
 * 选择节点 i 。
 * 将 values[i] 加入你的分数。
 * 将 values[i] 变为 0 。
 * 如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。
 *
 * 你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：edges = [[0,1],[0,2],[0,3],[2,4],[4,5]], values = [5,2,5,2,1,1]
 * 输出：11
 * 解释：我们可以选择节点 1 ，2 ，3 ，4 和 5 。根节点的值是非 0 的。所以从根出发到任意叶子节点路径上节点值之和都不为 0 。所以树是健康的。你的得分之和为 values[1] + values[2] + values[3] + values[4] + values[5] = 11 。
 * 11 是你对树执行任意次操作以后可以获得的最大得分之和。
 */
public class MaximumScoreAfterApplyingOperationsonaTree_100118 {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        long ans = 0l;
        int n = values.length;
        List[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            ans += values[i];
        }
        int[] visit = new int[n];
        Arrays.fill(visit, 0);
        long[] count = new long[n];
        dfs(graph, 0, count, values, visit);
        Arrays.fill(visit, 0);
        return dfs_search(graph, values, 0, count, visit);
    }

    public void dfs(List<Integer>[] graph, int index, long[] count, int[] values, int[] visit) {
        visit[index] = 1;
        if (graph[index].size() == 1 && index != 0) {
            count[index] = values[index];
            return;
        }
        List<Integer> list = graph[index];
        long res = values[index];
        for (int i = 0; i < graph[index].size(); i++) {
            int next = list.get(i);
            if(visit[next] == 1) continue;
            dfs(graph, next, count, values, visit);
            res += count[next];
        }
        count[index] = res;
    }

    public long dfs_search(List[] graph, int[] values, int index, long[] count, int[] visit) {
        visit[index] = 1;
        if (graph[index].size() == 1 && index != 0) {
            return 0;
        }
        long ans = values[index];
        // 后面取不为 0 的
        List<Integer> list = graph[index];
        for (int j = 0; j < graph[index].size(); j++) {
            if(visit[list.get(j)] == 1) continue;
            ans += dfs_search(graph, values, list.get(j), count, visit);
        }
        ans = Math.max(ans, count[index] - values[index]);
        return ans;
    }
}
