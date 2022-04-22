package Leetcode.Leetcode_2020.December;

//统计所有小于非负整数 n 的质数的数量。
//
//         
//
//        示例 1：
//
//        输入：n = 10
//        输出：4
//        解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

import java.util.Arrays;

public class CountPrimes {

    //自己写的基础算法
    public int countPrimes1(int n) {
        int count = 0;
        n--;
        while (n > 1) {
            if (isPrime(n) == true) count++;
            n--;
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        else for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    class Solution {
        //这里使用的筛选法，先讲所有的小于n的数制成一个布尔数组
        //从2枚举到sqrt(n)，把所有能够被其整除的数的布尔数组值变为false
        //最终读出里面true的计数即可
        public int countPrimes2(int n) {
            boolean[] isPrim = new boolean[n];
            Arrays.fill(isPrim, true);
            // 从 2 开始枚举到 sqrt(n)。
            for (int i = 2; i * i < n; i++) {
                // 如果当前是素数
                if (isPrim[i]) {
                    // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                    for (int j = i * i; j < n; j += i) {
                        isPrim[j] = false;
                    }
                }
            }

            // 计数
            int cnt = 0;
            for (int i = 2; i < n; i++) {
                if (isPrim[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
