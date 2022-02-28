package Leetcode_2022.February_2022;

/**
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 *
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 *
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：word = "aba"
 * 输出：6
 * 解释：
 * 所有子字符串是："a"、"ab"、"aba"、"b"、"ba" 和 "a" 。
 * - "b" 中有 0 个元音
 * - "a"、"ab"、"ba" 和 "a" 每个都有 1 个元音
 * - "aba" 中有 2 个元音
 * 因此，元音总数 = 0 + 1 + 1 + 1 + 1 + 2 = 6 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vowels-of-all-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class VowelsofAllSubstrings_2063 {

    public long countVowels(String word) {

        // 为什么觉得这题是一道脑筋急转弯
        char[] words = word.toCharArray();
        int len = words.length;
        long ans = 0;
        for(int i = 0; i<len; i++) {
            if(words[i] == 'a' || words[i] == 'e' || words[i] == 'i' || words[i] == 'o' || words[i] == 'u') {
                ans += (i+1) * (long)(len - i);
            }

        }

        return ans;
    }
}
