package Leetcode.Leetcode_2021.October_2021;

//给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
//
//         
//
//        示例 1：
//
//        输入：num = 5
//        输出：2
//        解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。

public class NumberComplement_476 {
    class Solution {
        public int findComplement(int num) {
            long ans=1;
            while(ans<=num){ans*=2;}
            return (int)ans-1-num;
        }
    }
}
