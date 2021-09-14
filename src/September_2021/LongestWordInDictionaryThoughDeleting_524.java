package September_2021;

//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
//
//        如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
//
//         
//
//        示例 1：
//
//        输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//        输出："apple"
//        示例 2：
//
//        输入：s = "abpcplea", dictionary = ["a","b","c"]
//        输出："a"

import java.util.List;

public class LongestWordInDictionaryThoughDeleting_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
