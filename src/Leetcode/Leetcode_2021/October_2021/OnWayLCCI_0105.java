package Leetcode.Leetcode_2021.October_2021;

//There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
//
//         
//
//        Example 1:
//
//        Input:
//        first = "pale"
//        second = "ple"
//        Output: True
//        Example 2:
//
//        Input:
//        first = "pales"
//        second = "pal"
//        Output: False


public class OnWayLCCI_0105 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first.length() < second.length()) {
                String temp = first;
                first = second;
                second = temp;
            }
            int m = first.length(), n = second.length();
            if (Math.abs(m - n) > 1) return false;
            if (m == n) {
                for (int i = 0, j = 0; i < m; i++) {
                    if (first.charAt(i) == second.charAt(i)) continue;
                    j += 1;
                    if (j == 2) return false;
                }
                return true;
            }

            int i = 0, j = n - 1;
            while (i <= j && first.charAt(i) == second.charAt(i)) i++;
            while (i <= j && first.charAt(j + 1) == second.charAt(j)) j--;
            return i > j;
        }
    }

}
