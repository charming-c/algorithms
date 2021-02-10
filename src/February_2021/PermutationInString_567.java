package February_2021;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//        换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//        示例1:
//
//        输入: s1 = "ab" s2 = "eidbaooo"
//        输出: True
//        解释: s2 包含 s1 的排列之一 ("ba").

public class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }

        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen) {
            if (pFreq[text[right] - 'a'] > 0) {
                winFreq[text[right] - 'a']++;
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }
            right++;

            while (pCount == winCount) {
                if (right - left == pLen) {
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
