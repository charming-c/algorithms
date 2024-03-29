package Leetcode.Leetcode_2021.February_2021;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//         
//
//        示例 1:
//
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    // 只包含字母的我很轻松解决
    public int lengthOfLongestSubstring(String s) {
        int[] graph = new int[26];
        int ans = 0;
        int left = -1, right = 0;
        int len = s.length();
        if(len == 0) return 0;
        while(right < len){
            graph[s.charAt(right) - 'a']++;

            if(graph[s.charAt(right) - 'a'] > 1){
                while(graph[s.charAt(right) - 'a'] > 1){
                    left++;
                    graph[s.charAt(left) - 'a']--;
                }
                ans = Math.max(ans,right - left);
            }
            right++;
        }
        return ans;
    }
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
}
