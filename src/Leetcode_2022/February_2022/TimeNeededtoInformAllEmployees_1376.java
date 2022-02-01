package Leetcode_2022.February_2022;

import java.util.LinkedList;
import java.util.List;

/**
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * <p>
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * <p>
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * <p>
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 * <p>
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-needed-to-inform-all-employees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TimeNeededtoInformAllEmployees_1376 {
    int ans;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new LinkedList[n];
        ans = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                graph[manager[i]].add(i);
        }

        ans = dfs(graph, headID, informTime, 0);
        return ans;

    }

    public int dfs(List<Integer>[] graph, int headID, int[] informTime, int cost) {
        if (informTime[headID] == 0) return cost;
        int temp = 0;
        for (int node : graph[headID]) {
            temp = Math.max(temp, dfs(graph, node, informTime, cost + informTime[headID]));
        }

        return temp;
    }

}
