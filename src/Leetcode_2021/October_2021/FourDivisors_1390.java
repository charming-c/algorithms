package Leetcode_2021.October_2021;

//给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
//
//        如果数组中不存在满足题意的整数，则返回 0 。
//
//         
//
//        示例：
//
//        输入：nums = [21,4,7]
//        输出：32
//        解释：
//        21 有 4 个因数：1, 3, 7, 21
//        4 有 3 个因数：1, 2, 4
//        7 有 2 个因数：1, 7
//        答案仅为 21 的所有因数的和。


public class FourDivisors_1390 {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // factor_cnt: 因数的个数
            // factor_sum: 因数的和
            int factor_cnt = 0, factor_sum = 0;
            for (int i = 1; i * i <= num; ++i) {
                if (num % i == 0) {
                    ++factor_cnt;
                    factor_sum += i;
                    if (i * i != num) {   // 判断 i 和 num/i 是否相等，若不相等才能将 num/i 看成新的因数
                        ++factor_cnt;
                        factor_sum += num / i;
                    }
                }
            }
            if (factor_cnt == 4) {
                ans += factor_sum;
            }
        }
        return ans;
    }
}
