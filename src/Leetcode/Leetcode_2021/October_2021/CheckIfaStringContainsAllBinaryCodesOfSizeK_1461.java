package Leetcode.Leetcode_2021.October_2021;

//给你一个二进制字符串 s 和一个整数 k 。
//
//        如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
//
//         
//
//        示例 1：
//
//        输入：s = "00110110", k = 2
//        输出：true
//        解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
//        示例 2：
//
//        输入：s = "00110", k = 2
//        输出：true

public class CheckIfaStringContainsAllBinaryCodesOfSizeK_1461 {
    public boolean hasAllCodes(String s, int k) {
        int count = 1 << k;
        int map[] = new int[count + 1];
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i - k + 1 >= 0; i--) {
            int temp = Character.getNumericValue(s.charAt(i));
            for (int j = i - 1; i - j + 1 <= k; j--) {
                temp = temp << 1;
                temp += Character.getNumericValue(s.charAt(j));
            }
            if (map[temp] == 1) continue;
            else {
                map[temp] = 1;
                sum++;
            }
        }

        return count == sum;
    }
}
