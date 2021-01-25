package January_2021;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//         
//
//        示例 1：
//
//        输入：strs = ["flower","flow","flight"]
//        输出："fl"
//        示例 2：
//
//        输入：strs = ["dog","racecar","car"]
//        输出：""
//        解释：输入不存在公共前缀。

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int min = Integer.MAX_VALUE;
        if (len == 1) return strs[0];
        for (int i = 0; i < len - 1; i++) {
            min = Math.min(min, getLength(strs[i], strs[i + 1]));
        }
        if (min != Integer.MAX_VALUE)
            return strs[0].substring(0, min);
        else return new String();
    }

    public int getLength(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int count = 0;
        len1 = len1 > len2 ? len2 : len1;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            } else count++;
        }
        return count;
    }
}
