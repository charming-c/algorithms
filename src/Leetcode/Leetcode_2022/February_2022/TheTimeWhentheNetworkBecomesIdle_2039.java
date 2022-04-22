package Leetcode.Leetcode_2022.February_2022;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 你一个有 n 个服务器的计算机网络，服务器编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示服务器 ui 和 vi 之间有一条信息线路，在 一秒 内它们之间可以传输 任意 数目的信息。再给你一个长度为 n 且下标从 0 开始的整数数组 patience 。
 * <p>
 * 题目保证所有服务器都是 相通 的，也就是说一个信息从任意服务器出发，都可以通过这些信息线路直接或间接地到达任何其他服务器。
 * <p>
 * 编号为 0 的服务器是 主 服务器，其他服务器为 数据 服务器。每个数据服务器都要向主服务器发送信息，并等待回复。信息在服务器之间按 最优 线路传输，也就是说每个信息都会以 最少时间 到达主服务器。主服务器会处理 所有 新到达的信息并 立即 按照每条信息来时的路线 反方向 发送回复信息。
 * <p>
 * 在 0 秒的开始，所有数据服务器都会发送各自需要处理的信息。从第 1 秒开始，每 一秒最 开始 时，每个数据服务器都会检查它是否收到了主服务器的回复信息（包括新发出信息的回复信息）：
 * <p>
 * 如果还没收到任何回复信息，那么该服务器会周期性 重发 信息。数据服务器 i 每 patience[i] 秒都会重发一条信息，也就是说，数据服务器 i 在上一次发送信息给主服务器后的 patience[i] 秒 后 会重发一条信息给主服务器。
 * 否则，该数据服务器 不会重发 信息。
 * 当没有任何信息在线路上传输或者到达某服务器时，该计算机网络变为 空闲 状态。
 * <p>
 * 请返回计算机网络变为 空闲 状态的 最早秒数 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TheTimeWhentheNetworkBecomesIdle_2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int ret[] = new int[n];
        int path[] = new int[n];

        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);

        }

        Queue<Integer> queue = new LinkedList<>();
        ret[0] = 0;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                path[cur] = 1;
                for (int node : graph[cur]) {
                    if (path[node] == 0) {
                        ret[node] = ret[cur] + 1;
                        path[node] = 1;
                        queue.offer(node);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (patience[i] > 2 * ret[i]) {
                max = Math.max(max, 2 * ret[i] + 1);
            } else {
                int temp = 0;
                if (2 * ret[i] % patience[i] == 0)
                    temp = (2 * ret[i] - patience[i]);
                else
                    temp = 2 * ret[i] - (2 * ret[i] % patience[i]);
                max = Math.max(2 * ret[i] + temp + 1, max);
            }
        }
        return max;
    }
}
