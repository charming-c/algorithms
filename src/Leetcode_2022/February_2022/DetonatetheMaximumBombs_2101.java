package Leetcode_2022.February_2022;

import java.util.HashSet;
import java.util.LinkedList;

public class DetonatetheMaximumBombs_2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i<n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i<n; i++) {
            int pos[] = new int[2];
            pos[0] = bombs[i][0];
            pos[1] = bombs[i][1];
            for(int j = 0; j<n; j++) {
                if(j == i) continue;
                int cur[] = new int[2];
                cur[0] = bombs[j][0];
                cur[1] = bombs[j][1];
                if(distance(pos, cur, bombs[i][2])) {
                    graph[i].add(j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++) {
            HashSet<Integer> set = new HashSet<>();
            putSet(graph, i, set);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    public boolean distance(int[] start, int end[], int d) {
        // long a = (long)((start[0] - end[0]));
        // long b = (long)((start[1] - end[1]));
        // long c = (long)(d);
        // if(a*a + b*b <= c*c) {
        //     return true;
        // }
        // else return false;
        long a = ((long)start[0] - end[0]) * ((long)start[0] - end[0]);
        long b = ((long)start[1] - end[1]) * ((long)start[1] - end[1]);
        long c = (long)d * d;
        if(a + b <= c) {
            return true;
        }
        else return false;
    }

    public void putSet(LinkedList[] graph, int i, HashSet set) {
        set.add(i);
        for(int a : (LinkedList<Integer>)graph[i]) {
            if(set.contains(a)) {
                continue;
            }
            putSet(graph, a, set);
        }
    }
}
