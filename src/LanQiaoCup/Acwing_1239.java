package LanQiaoCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定 N 个整数 A1,A2,…AN。
 * <p>
 * 请你从中选出 K 个数，使其乘积最大。
 * <p>
 * 请你求出最大的乘积，由于乘积可能超出整型范围，你只需输出乘积除以 1000000009 的余数。
 * <p>
 * 注意，如果 X<0， 我们定义 X 除以 1000000009 的余数是负(−X)除以 1000000009 的余数，即：0−((0−x)%1000000009)
 * 输入格式
 * 第一行包含两个整数 N 和 K。
 * <p>
 * 以下 N 行每行一个整数 Ai。
 * <p>
 * 输出格式
 * 输出一个整数，表示答案。
 * <p>
 * 数据范围
 * 1≤K≤N≤105,
 * −105≤Ai≤105
 * 输入样例1：
 * 5 3
 * -100000
 * -10000
 * 2
 * 100000
 * 10000
 * 输出样例1：
 * 999100009
 */

public class Acwing_1239 {
    private static int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];

        arr = new int[n + 1];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(arr, 0, n);
        long res = 1;
        int l = 0, r = n - 1;
        int sign = 1;
        if (k % 2 == 1) {
            res = arr[r--];
            k--;
            if (res < 0) sign = -1;
        }

        while (k != 0) {
            long x = ((long) arr[l]) * arr[l + 1], y = ((long) arr[r - 1]) * arr[r];

            if (x * sign > y * sign) {
                res = x % mod * res % mod;
                l += 2;
            } else {
                res = y % mod * res % mod;
                r -= 2;
            }
            k -= 2;
        }
        System.out.println(res);
    }
}
