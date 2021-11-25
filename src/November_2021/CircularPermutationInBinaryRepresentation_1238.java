package November_2021;

//给你两个整数 n 和 start。你的任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p，并且满足：
//
//        p[0] = start
//        p[i] 和 p[i+1] 的二进制表示形式只有一位不同
//        p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
//         
//
//        示例 1：
//
//        输入：n = 2, start = 3
//        输出：[3,2,0,1]
//        解释：这个排列的二进制表示是 (11,10,00,01)
//        所有的相邻元素都有一位是不同的，另一个有效的排列是 [3,1,0,2]

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation_1238 {

    // 自己写的没有剪枝的回溯，超时了
    // 换成数组就可以了， 不用arraylist的contains
    public List<Integer> circularPermutation2(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        search(ans, n);
        return ans;
    }

    public boolean search(List<Integer> list, int n) {
        int size = list.size();
        if (size == (1 << n)) {
            int start = list.get(0);
            int end = list.get(size - 1);
            int temp = start ^ end;
            return (temp & (temp - 1)) == 0;
        }

        int num = list.get(size - 1);
        int pivot = 1;
        for (int i = 0; i < n; i++) {
            int elm = num ^ pivot;
            if (!list.contains(elm)) {
                list.add(elm);
                if (search(list, n)) return true;
                list.remove(size);
            }
            pivot = pivot << 1;
        }
        return false;
    }

    //别人的成了
    boolean[] used;
    boolean success = false;

    public List<Integer> circularPermutation(int n, int start) {
        int m = (1 << n);
        used = new boolean[m];
        int[] res = new int[m];
        trackback(start, 0, res, n);
        List<Integer> list = new ArrayList<>(m);
        for (int e : res) {
            list.add(e);
        }
        return list;
    }

    void trackback(int val, int idx, int[] res, int n) {
        if (used[val]) return;
        if (idx >= res.length - 1) {
            int tmp = val ^ res[0];
            if ((tmp & (tmp - 1)) == 0) {
                success = true;
                res[idx] = val;
                return;
            }
        }
        used[val] = true;
        res[idx] = val;
        for (int i = 0; i < n; i++) {
            if (!success)
                trackback(val ^ (1 << i), idx + 1, res, n);
            else
                return;
        }
        used[val] = false;
    }
}
