package Leetcode.Leetcode_2021.November_2021;

//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
//
//        例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
//        返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
//
//         
//
//        示例 1：
//
//        输入：numCourses = 2, prerequisites = [[1,0]]
//        输出：[0,1]
//        解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII_210 {
    List<Integer> postOrder = new ArrayList<>();
    boolean[] visit,onPath;
    boolean hasCircle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph;
        visit = new boolean[numCourses];
        onPath = new boolean[numCourses];
        graph = buildGraph(numCourses,prerequisites);

        for(int i = 0; i<numCourses; i++) {
            traverse(graph, i);
        }

        if(hasCircle == true) {
            return new int[]{};
        }
        else {
            int[] ans = new int[numCourses];
            int size = postOrder.size();
            for(int i = 0; i<size; i++) {
                ans[i] = postOrder.get(i);
            }
            return ans;
        }
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] edgs) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i<numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int[] edg : edgs) {
            int from = edg[0];
            int to = edg[1];
            graph[from].add(to);
        }
        return graph;
    }

    public void traverse(List<Integer>[] graph, int node){
        if(onPath[node]) {
            hasCircle = true;
        }
        if(visit[node] || hasCircle) {
            return;
        }
        visit[node] = true;
        onPath[node] = true;

        for(int next : graph[node]) {
            traverse(graph, next);
        }
        postOrder.add(node);
        onPath[node] = false;
    }
}
