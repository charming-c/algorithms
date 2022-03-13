package Leetcode_2022.March_2022;

import java.util.*;

public class MinimumWeightedSubgraphWiththeRequiredPaths_6032 {

    int n = 0;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        this.n = n;
        List<int[]>[] g = new List[n];
        List<int[]>[] g2 = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            g2[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int val = edges[i][2];
            g[to].add(new int[]{from, val});
            g2[from].add(new int[]{to, val});
        }

        long[] dist = getPath(dest, g);
        long[] dist1 = getPath(src1, g2);
        long[] dist2 = getPath(src2, g2);

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[i] != Long.MAX_VALUE && dist1[i] != Long.MAX_VALUE && dist2[i] != Long.MAX_VALUE)
                ans = Math.min(dist1[i] + dist2[i] + dist[i], ans);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    public long[] getPath(int dest, List<int[]>[] g) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int) (a[1] - b[1]));
        dist[dest] = 0;
        pq.offer(new long[]{dest, 0});
        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int cur = (int) node[0];
            long val = node[1];

            if (val > dist[cur]) continue;

            for (int[] next : g[cur]) {
                int e = next[0];
                long c = next[1];
                dist[e] = Math.min(c + val, dist[e]);
                pq.offer(new long[]{e, val + c});
            }
        }
        return dist;
    }

}
