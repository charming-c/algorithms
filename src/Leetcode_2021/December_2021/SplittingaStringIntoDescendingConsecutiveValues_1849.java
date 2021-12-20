package Leetcode_2021.December_2021;

/**
 * 给你一个仅由数字组成的字符串 s 。
 * <p>
 * 请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。
 * <p>
 * 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
 * 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
 * 如果可以按要求拆分 s ，返回 true ；否则，返回 false 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1234"
 * 输出：false
 * 解释：不存在拆分 s 的可行方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SplittingaStringIntoDescendingConsecutiveValues_1849 {
    int len;

    public boolean splitString(String s) {
        len = s.length();
        long t = 0;
        for (int i = 0; i < len - 1; i++) {
            t = t * 10 + s.charAt(i) - '0';
            if (t > 10000000000l) {
                return false;
            }
            if (search(s, t, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(String s, long pre, int index) {
        if (index == len) return true;
        long t = 0;
        for (int i = index; i < len; i++) {
            t = t * 10 + s.charAt(i) - '0';
            if (t > 10000000000l) {
                return false;
            }
            if (pre - 1 == t && search(s, t, i + 1)) {
                return true;
            }
            if (t > pre)
                return false;
        }
        return false;
    }
}
