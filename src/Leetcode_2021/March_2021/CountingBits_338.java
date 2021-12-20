package Leetcode_2021.March_2021;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
//        示例 1:
//
//        输入: 2
//        输出: [0,1,1]
//        示例 2:
//
//        输入: 5
//        输出: [0,1,1,2,1,2]


public class CountingBits_338 {
    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            if (num != 0) ans[0] = 0;
            for (int i = 1; i <= num; i++) {
                ans[i] = singleBits(i);
            }
            return ans;
        }

        public int singleBits(int n) {
            int count = 0;
            while (n != 0) {
                n &= (n - 1);
                count++;
            }
            return count;
        }
    }
    class Solution2 {
        public int[] countBits(int num) {
            int[] bits = new int[num + 1];
            int highBit = 0;
            for (int i = 1; i <= num; i++) {
                if ((i & (i - 1)) == 0) {
                    highBit = i;
                }
                bits[i] = bits[i - highBit] + 1;
            }
            return bits;
        }
    }

}
