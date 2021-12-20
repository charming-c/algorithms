package Leetcode_2021.March_2021;

import java.util.Arrays;

// 自己写的代码就跟shit是一样的
public class PossibleBipartition_886 {
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int[] ans = new int[N];
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                ret[i][j] = 1;
            }
        }
        Arrays.fill(ans, -1);
        int len = dislikes.length;
        for (int i = 0; i < len; i++) {
            ret[dislikes[i][0] - 1][dislikes[i][1] - 1] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (ret[i][j] == 1) {
                    union(ans, i, j);

                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (find(ans, dislikes[i][0] - 1) == find(ans, dislikes[i][1] - 1)) {
                ans[dislikes[i][0] - 1] = -1;

            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i] + " ");
            if (ans[i] == -1) count++;
        }
        if (count > 2) return false;
        else return true;
    }

    public static int find(int[] parent, int index) {
        if (parent[index] == -1) return index;
        else {
            parent[index] = find(parent, parent[index]);
            return parent[index];
        }
    }

    public static void union(int[] parent, int index1, int index2) {
        if (find(parent, index1) != find(parent, index2))
            parent[find(parent, index1)] = find(parent, index2);
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        possibleBipartition(N, dislikes);
    }
}

// 标答，牛皮
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        UnionFind uf = new UnionFind(N * 2 + 1);
        for (int i = 0; i < dislikes.length; i++) {
            int x = uf.find(dislikes[i][0]); //查找自己的根节点
            int y = uf.find(dislikes[i][1]); //不喜欢的人的根节点
            int a = uf.find(dislikes[i][0] + N); //查找自己不喜欢的人群根节点
            int b = uf.find(dislikes[i][1] + N);  // 自己不喜欢的人不喜欢的人群节点
            if (x == y) {
                return false; //发现这俩人已经在一组，GG
            } else {
                uf.union(y, a); // Union persons that are disliked
                uf.union(b, x);
            }
        }
        return true;
    }

    private class UnionFind {
        int roots;
        int[] parent;

        public UnionFind(int size) {
            this.roots = size;
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        void union(int p, int q) {
            int rootP = parent[p];
            int rootQ = parent[q];

            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                roots--;
            }

            return;
        }

        int find(int p) {
            while (p != parent[p]) {
                p = parent[parent[p]];
            }

            return p;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}