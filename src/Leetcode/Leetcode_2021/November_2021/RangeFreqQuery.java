package Leetcode.Leetcode_2021.November_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
//
//        子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
//
//        请你实现 RangeFreqQuery 类：
//
//        RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
//        int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
//        一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
//
//         
//
//        示例 1：
//
//        输入：
//        ["RangeFreqQuery", "query", "query"]
//        [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
//        输出：
//        [null, 1, 2]
//
//        解释：
//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
//        rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
//        rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。

public class RangeFreqQuery {
    int[] arr;
    int len;
    HashMap<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
        this.map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    list.add(1);
                    continue;
                }
                int pre = list.get(j - 1);
                if (arr[i] == arr[j]) {
                    list.add(pre + 1);
                } else list.add((pre));
            }
            map.put(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        int ans = 0;
        List<Integer> list = map.get(value);
        if (list == null) return 0;
        ans = list.get(right) - list.get((left));
        if (arr[left] == value) ans++;
        return ans;
    }
}

// 哈希表 + 二分查找
class RangeFreqQuery1 {
    int len;
    HashMap<Integer, List<Integer>> map;

    public RangeFreqQuery1(int[] arr) {
        this.len = arr.length;
        map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list;
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
            } else list = new ArrayList<>();
            list.add(i);
            map.put(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.get(value);
        if (list == null) return 0;
        int l = search(list, left - 1);
        int r = search(list, right);
        return r - l;
    }

    public int search(List<Integer> list, int end) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) > end) {
                right = mid - 1;
            } else if (list.get(mid) == end) {
                right = mid;
                break;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
//["RangeFreqQuery","query","query","query","query","query","query"]
//        [[[8,4,2,5,4,5,8,6,2,3]],[0,3,5],[5,6,2],[6,8,4],[2,8,3],[4,5,1],[2,4,2]]