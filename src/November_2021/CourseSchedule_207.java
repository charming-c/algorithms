package November_2021;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//        在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//        例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//         
//
//        示例 1：
//
//        输入：numCourses = 2, prerequisites = [[1,0]]
//        输出：true
//        解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_207 {
    boolean hasCircle = false;
    int[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        int[] visit = new int[numCourses];
        onPath = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        buildGraph(graph, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i, visit);
        }
        return !hasCircle;

    }

    public void buildGraph(List<Integer>[] graph, int[][] edgs) {
        int len = edgs.length;
        for (int i = 0; i < len; i++) {
            int from = edgs[i][0];
            int to = edgs[i][1];
            graph[from].add(to);
        }
    }

    public void traverse(List<Integer>[] graph, int node, int[] visit) {
        if (onPath[node] == 1) {
            hasCircle = true;
        }
        if (visit[node] == 1 || hasCircle) {
            return;
        }
        onPath[node] = 1;
        visit[node] = 1;
        for (int next : graph[node]) {
            traverse(graph, next, visit);
        }
        onPath[node] = 0;
    }
}
