package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class MaximumPalindromesAfterOperations_3035 {
    public int maxPalindromesAfterOperations(String[] words) {
        int tot = 0;
        int mask = 0; // 奇数个数的字母集合
        for (String w : words) {
            tot += w.length();
            for (char c : w.toCharArray()) {
                mask ^= 1 << (c - 'a');
            }
        }
        tot -= Integer.bitCount(mask); // 减去出现次数为奇数的字母

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int ans = 0;
        for (String w : words) {
            tot -= w.length() / 2 * 2; // 长为奇数的字符串，长度要减一
            if (tot < 0) break;
            ans++;
        }
        return ans;
    }
}
