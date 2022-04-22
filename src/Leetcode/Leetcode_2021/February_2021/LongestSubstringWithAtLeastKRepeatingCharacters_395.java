package Leetcode.Leetcode_2021.February_2021;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
//         
//
//        示例 1：
//
//        输入：s = "aaabb", k = 3
//        输出：3
//        解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {

    // 看了题解自己试着写了一遍
    public int longestSubstring(String s, int k) {
        int len = s.length();
        return searchLongest(s, k, 0, len-1);
    }

    public int searchLongest(String s, int k, int left, int right){
        int[] map = new int[26];
        char split = 0;
        int ans = 0;

        for(int i = left; i<=right; i++){
            map[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i<26; i++){
            if(map[i] > 0 && map[i] < k){
                split = (char)(i + 'a');
                break;
            }
        }

        if(split == 0) return right - left + 1;

        while(left <= right){
            while(left<=right && s.charAt(left) == split){
                left++;
            }
            if(left > right) break;

            int end = left;
            while(end<=right && s.charAt(end) != split){
                end++;
            }
            int length = searchLongest(s,k,left,end-1);
            ans = Math.max(ans,length);
            left = end;
        }
        return ans;
        // int i = left;
        // int ret = 0;
        // while (i <= right) {
        //     while (i <= right && s.charAt(i) == split) {
        //         i++;
        //     }
        //     if (i > right) {
        //         break;
        //     }
        //     int start = i;
        //     while (i <= right && s.charAt(i) != split) {
        //         i++;
        //     }

        //     int length = searchLongest(s,k, start, i - 1);
        //     ret = Math.max(ret, length);
        // }
        // return ret;


    }
}
