package Leetcode_2021.February_2021;

//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
//
//        注意：字符串长度 和 k 不会超过 104。
//
//         
//
//        示例 1：
//
//        输入：s = "ABAB", k = 2
//        输出：4
//        解释：用两个'A'替换为两个'B',反之亦然。

public class LongestRepeatingCharacterReplacement_424 {

    // 官方题解，看了一遍记了下来，直接默写
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int[] num = new int[26];
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < length){
            num[s.charAt(right) - 'A']++;
            max = Math.max(max, num[s.charAt(right) - 'A']);
            if(right - left + 1 - max > k){
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
