package Leetcode.Leetcode_2022.May_2022;

import java.util.Arrays;

/**
 * 字符串的 引力 定义为：字符串中 不同 字符的数量。
 *
 * 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
 * 给你一个字符串 s ，返回 其所有子字符串的总引力 。
 *
 * 子字符串 定义为：字符串中的一个连续字符序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbca"
 * 输出：28
 * 解释："abbca" 的子字符串有：
 * - 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
 * - 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
 * - 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
 * - 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
 * 引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/total-appeal-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TotalAppealofAString_2262 {
    public long appealSum(String s) {
        char[] res = s.toCharArray();
        int len = res.length;
        int[] last = new int[len];
        Arrays.fill(last, -1);

        long ans = 0l;

        for(int i = 0, sum = 0; i<len; i++) {
            int num = res[i] - 'a';
            sum += i - last[num];
            ans += sum;
            last[num] = i;
        }

        return ans;
    }
}
