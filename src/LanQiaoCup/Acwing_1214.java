package LanQiaoCup;

import java.io.IOException;
import java.util.Scanner;

/**
 * 观察这个数列：
 * <p>
 * 1 3 0 2 -1 1 -2 …
 * <p>
 * 这个数列中后一项总是比前一项增加2或者减少3，且每一项都为整数。
 * <p>
 * 栋栋对这种数列很好奇，他想知道长度为 n 和为 s 而且后一项总是比前一项增加 a 或者减少 b 的整数数列可能有多少种呢？
 * <p>
 * 输入格式
 * 共一行，包含四个整数 n,s,a,b，含义如前面所述。
 * <p>
 * 输出格式
 * 共一行，包含一个整数，表示满足条件的方案数。
 * <p>
 * 由于这个数很大，请输出方案数除以 100000007 的余数。
 * <p>
 * 数据范围
 * 1≤n≤1000,
 * −109≤s≤109,
 * 1≤a,b≤106
 * 输入样例：
 * 4 10 2 3
 * 输出样例：
 * 2
 * 样例解释
 * 两个满足条件的数列分别是2 4 1 3和7 4 1 -2。
 */

public class Acwing_1214 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int mod = 100000007;
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (f[i - 1][getMod(j - i * a, n)] + f[i - 1][getMod(j + i * b, n)]) % mod;
            }
        }
        System.out.println(f[n - 1][getMod(s, n)]);
    }

    private static int getMod(int a, int b) {
        return (a % b + b) % b;
    }
}
