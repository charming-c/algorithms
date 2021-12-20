package Leetcode_2021.April_2021;

//有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
//
//        现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
//
//         
//
//        示例 1：
//
//        输入:
//        n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//        src = 0, dst = 2, k = 1
//        输出: 200
//        解释:
//        城市航班图如下
//
//
//        从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。

import java.util.Arrays;

public class CheapestFlightsWithinKStops_787 {

    // 单纯暴力搜索，最终超时了
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] map = new int[n][n];
        for(int i  = 0; i<n; i++){
            Arrays.fill(map[i],-1);
        }

        int len = flights.length;
        for(int i = 0; i<len; i++){
            map[flights[i][0]][flights[i][1]] = flights[i][2];
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++){
            if(map[src][j] != -1){
                if(searchPath(n,map,j,dst,map[src][j],K) != -1){
                    ans = Math.min(ans,searchPath(n,map,j,dst,map[src][j],K));
                }
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }

    public int searchPath(int n, int[][] map, int start, int end, int pay, int k){
        if(start == end && k >= 0) return pay;
        if(k<0) return -1;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            if(map[start][i] > 0){
                int temp = searchPath(n, map, i, end, pay + map[start][i], k-1);
                if(temp != -1){
                    ans = Math.min(temp, ans);
                }
                else continue;
            }
        }

        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }


    // 这里的搜索使用了剪枝，就缩短了时间
    public class Solution {

        private int[][] graph;
        private boolean[] visited;
        private int res = Integer.MAX_VALUE;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            K = Math.min(K, n - 2);

            this.graph = new int[n][n];
            for (int[] flight : flights) {
                graph[flight[0]][flight[1]] = flight[2];
            }

            this.visited = new boolean[n];
            // 开始深度优先遍历，注意：这里传 K + 1，这是因为 K 次经停，总共 K + 1 个站
            dfs(src, dst, K + 1, 0);

            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }


        /**
         * 从 src 出发，到 dst 为止，最多经过 k 站（这里 k 包括 src）
         *
         * @param src  起点站
         * @param dst  终点站
         * @param k    经过的站点数限制
         * @param cost 已经花费的价格
         */
        private void dfs(int src, int dst, int k, int cost) {
            if (src == dst) {
                res = cost;
                return;
            }

            if (k == 0) {
                return;
            }

            for (int i = 0; i < graph[src].length; i++) {
                if (graph[src][i] > 0) {
                    if (visited[i]) {
                        continue;
                    }

                    // 剪枝：跳过可能产生较高费用的路径，从而选出最少价格
                    if (cost + graph[src][i] > res) {
                        continue;
                    }

                    visited[i] = true;
                    dfs(i, dst, k - 1, cost + graph[src][i]);
                    visited[i] = false;
                }
            }
        }
    }
}
