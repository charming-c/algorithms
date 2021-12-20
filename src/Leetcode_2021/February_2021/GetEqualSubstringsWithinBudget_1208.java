package Leetcode_2021.February_2021;

//        给你两个长度相同的字符串，s 和 t。
//
//        将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
//
//        用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
//
//        如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
//
//        如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
//
//         
//
//        示例 1：
//
//        输入：s = "abcd", t = "bcdf", cost = 3
//        输出：3
//        解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。

import java.util.LinkedList;
import java.util.Queue;

public class GetEqualSubstringsWithinBudget_1208 {

    // 这里是自己想的利用一个队列来处理各个开销，空间复杂度较高
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(t.charAt(i) - s.charAt(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        int sumCost = 0;
        for (int i = 0; i < len; i++) {
            sumCost += cost[i];
            queue.add(cost[i]);
            if (sumCost <= maxCost) {
                ans = Math.max(ans, queue.size());
            } else {
                while (sumCost > maxCost) {
                    int temp = queue.poll();
                    sumCost -= temp;
                }
            }
        }
        return ans;
    }

    // 这里是来自某评论的题解，和昨天的题目的解法有异曲同工之妙
    // 每次都将窗口右沿后移，如果开销过大就左沿右移
    // 这样最大长度其实没有变
    public int equalSubstring2(String s, String t, int maxCost) {
        int len = s.length();
        int right = 0, left = 0;
        int sum = 0;
        while (right < len) {
            sum += Math.abs(t.charAt(right) - s.charAt(right));
            if (sum > maxCost) {
                sum -= Math.abs(t.charAt(left) - s.charAt(left));
                left++;
            }
            right++;
        }
        return right - left;

    }
}
