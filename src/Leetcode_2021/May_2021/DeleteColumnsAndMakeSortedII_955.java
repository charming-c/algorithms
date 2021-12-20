package Leetcode_2021.May_2021;

//给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
//
//        选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
//
//        比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
//
//        假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
//
//         
//
//        示例 1：
//
//        输入：strs = ["ca","bb","ac"]
//        输出：1
//        解释：
//        删除第一列后，strs = ["a", "b", "c"]。
//        现在 strs 中元素是按字典排列的 (即，strs[0] <= strs[1] <= strs[2])。
//        我们至少需要进行 1 次删除，因为最初 strs 不是按字典序排列的，所以答案是 1。

import java.util.Arrays;

public class DeleteColumnsAndMakeSortedII_955 {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int m = strs.length;
        int n = strs[0].length();

        String[] cur = new String[m];

        for (int j = 0; j < n; j++) {
            String[] cur2 = Arrays.copyOf(cur, m);
            for (int i = 0; i < m; i++) {

                cur2[i] += strs[i].charAt(j);

            }
            if (isSorted(cur2)) {
                cur = cur2;
            } else ans++;
        }

        return ans;
    }

    public boolean isSorted(String[] s) {
        int len = s.length;
        for (int i = 0; i < len - 1; i++) {
            if (s[i].compareTo(s[i + 1]) > 0)
                return false;
        }
        return true;
    }
}
