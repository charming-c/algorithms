package Leetcode.Leetcode_2024;

import java.util.LinkedList;
import java.util.Queue;

public class ReachableNodesWithRestrictions_2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        LinkedList<Integer>[] g = new LinkedList[n];
        for(int i = 0; i<n; i++) {
            g[i] = new LinkedList<>();
        }

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            g[x].add(y);
            g[y].add(x);
        }
        int[] access =  new int[n];
        for(int r : restricted) {
            access[r] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ans = 1;
        while(queue.size() != 0) {
            int node = queue.poll();
            for(int next : g[node]) {
                if(access[next] != 1) {
                    queue.offer(next);
                    ans++;
                }
            }
        }
        return ans;
    }

}
