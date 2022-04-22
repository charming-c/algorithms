package Leetcode.Leetcode_2021.March_2021;

//有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
//
//        省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
//
//        给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
//
//        返回矩阵中 省份 的数量。
//
//         
//
//        示例 1：
//
//
//        输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//        输出：2

import java.util.Arrays;

public class NumberOfProvinces_547 {

    // 简单的并查集思路
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int[] ret = new int[m];
        Arrays.fill(ret, -1);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    union(ret, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (ret[i] == -1)
                count++;
        }
        return count;
    }

    public int find(int[] parents, int index) {
        if (parents[index] == -1) return index;
        else {
            parents[index] = find(parents, parents[index]);
            return parents[index];
        }
    }

    public void union(int[] parents, int index1, int index2) {
        if (find(parents, index1) != find(parents, index2))
            parents[find(parents, index1)] = find(parents, index2);
    }
}
