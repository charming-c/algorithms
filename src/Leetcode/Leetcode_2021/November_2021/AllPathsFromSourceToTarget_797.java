package Leetcode.Leetcode_2021.November_2021;

//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
//
//        二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
//
//        译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
//
//         
//
//        示例 1：
//
//
//
//        输入：graph = [[1,2],[3],[3],[]]
//        输出：[[0,1,3],[0,2,3]]
//        解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return ans;
    }

    void traverse(int[][] graph, int pos, LinkedList<Integer> path){
        int n = graph.length;
        path.add(pos);
        if(pos == n-1){
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        for(int p : graph[pos]){
            traverse(graph, p, path);
        }
        path.removeLast();
    }
}

