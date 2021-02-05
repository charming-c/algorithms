package Leetcode_2020.October;

import java.util.Arrays;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//        示例 1:
//
//        输入: s = "anagram", t = "nagaram"
//        输出: true
//        示例 2:
//
//        输入: s = "rat", t = "car"
//        输出: false
//        说明:
//        你可以假设字符串只包含小写字母。



public class 有效的字母异位词 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()){
                return false;
            }
            char[] s1=s.toCharArray();
            char[] s2=t.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            return Arrays.equals(s1,s2);

        }
    }
}
