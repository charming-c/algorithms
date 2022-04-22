package Leetcode.Leetcode_2022.January_2022;

/**
 * 给定整数 p 和 m ，一个长度为 k 且下标从 0 开始的字符串 s 的哈希值按照如下函数计算：
 * <p>
 * hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.
 * 其中 val(s[i]) 表示 s[i] 在字母表中的下标，从 val('a') = 1 到 val('z') = 26 。
 * <p>
 * 给你一个字符串 s 和整数 power，modulo，k 和 hashValue 。请你返回 s 中 第一个 长度为 k 的 子串 sub ，满足 hash(sub, power, modulo) == hashValue 。
 * <p>
 * 测试数据保证一定 存在 至少一个这样的子串。
 * <p>
 * 子串 定义为一个字符串中连续非空字符组成的序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode", power = 7, modulo = 20, k = 2, hashValue = 0
 * 输出："ee"
 * 解释："ee" 的哈希值为 hash("ee", 7, 20) = (5 * 1 + 5 * 7) mod 20 = 40 mod 20 = 0 。
 * "ee" 是长度为 2 的第一个哈希值为 0 的子串，所以我们返回 "ee" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-substring-with-given-hash-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FindSubstringWithGivenHashValue_5994 {


    // 这道题真的很多坑，比如数据的溢出，取模的负数，还有时间复杂度
    // 思想其实不难想是一个滑动窗口的问题，
    // 但是正向滑动的时候是没有办法去去处理power的右移，因为power和modulo不一定是互质的，可能产生影响
    // 所以这里可以尝试使用反向滑动，这样就很好处理了
    // btw Rk算法 https://blog.csdn.net/xlxxcc/article/details/64125265
    long[] pp;

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long value = 0;
        int len = s.length();
        int al = 0;
        int ar = 0;
        pp = new long[k];
        pow(power, k, modulo);
        for (int i = 0; i < k; i++) {
            value += (long) (s.charAt(len - 1 - i) - 'a' + 1) * pp[k - i - 1] % modulo;
            value %= modulo;
        }

        int left = len - k;
        int right = len;
        if (value == hashValue) {
            al = left;
            ar = right;
        }

        while (left - 1 >= 0) {
            value += modulo;
            value -= (long) (s.charAt(right - 1) - 'a' + 1) * pp[k - 1] % (long) modulo;
            value *= power;
            value %= modulo;
            value += (long) (s.charAt(left - 1) - 'a' + 1) * pp[0] % (long) modulo;
            value %= modulo;

            if (value == hashValue) {
                al = left - 1;
                ar = right - 1;
            }
            left--;
            right--;
        }
        return s.substring(al, ar);
    }


    public void pow(int power, int time, int modulo) {
        long ans = 1;
        pp[0] = 1;
        for (int i = 1; i < time; i++) {
            ans = ans * (long) (power) % (long) modulo;
            pp[i] = ans;
        }
    }
}
