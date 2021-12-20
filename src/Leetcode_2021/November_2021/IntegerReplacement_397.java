package Leetcode_2021.November_2021;

//给定一个正整数 n ，你可以做如下操作：
//
//        如果 n 是偶数，则用 n / 2替换 n 。
//        如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
//        n 变为 1 所需的最小替换次数是多少？
//
//         
//
//        示例 1：
//
//        输入：n = 8
//        输出：3
//        解释：8 -> 4 -> 2 -> 1

public class IntegerReplacement_397 {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n == Integer.MAX_VALUE) return 32;
        if (n % 2 == 0) return integerReplacement(n >> 1) + 1;
        else
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
    }
}
