package LanQiaoCup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100  可以表示为带分数的形式：100=3+69258714
 * 还可以表示为：100=82+3546197
 * 注意特征：带分数中，数字 1∼9 分别出现且只出现一次（不包含 0）。
 *
 * 类似这样的带分数，100 有 11 种表示法。
 *
 * 输入格式
 * 一个正整数。
 *
 * 输出格式
 * 输出输入数字用数码 1∼9 不重复不遗漏地组成带分数表示的全部种数。
 *
 * 数据范围
 * 1≤N<106
 * 输入样例1：
 * 100
 * 输出样例1：
 * 11
 * 输入样例2：
 * 105
 * 输出样例2：
 * 6
 */

public class Acwing_1209_2 {

    static int ans = 0;
    static int[] st = new int[10];
    static int tar = 0;
    static int count = 0;

    /**
     * 由题意可以设 tar = a + b / c
     * 可以化为 tar * c = a * c + b
     * 这样就可以只枚举 a 和 c 的值就根据数字情况判断 b 中的数位是否填满剩下的 1～9
     * 此时b不用求排列，而且在枚举 a 时，可以进行剪枝处理，比全排列的时间复杂度要小很多
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tar = scanner.nextInt();
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int u, int num) {

        if(u >= 10 || num > tar) {
            return;
        }

        for(int i = 1; i<10; i++) {
            if(st[i] == 0) {
                st[i] = 1;
                int temp = num * 10 + i;
                if(temp >= tar) {
                    st[i] = 0;
                    continue;
                }

                // 递归对于当前的a是否可以找到c使得等式成立
                dfs_c(u + 1, temp, 0);
                // 继续寻找 a
                dfs(u + 1, temp);
                count++;
                st[i] = 0;

            }
        }
    }

    private static void dfs_c(int u, int a, int c) {
        if(u >= 10) {
            return;
        }
        if(c != 0 && check(a, c)) {
            ans++;
            return;
        }
        for(int i = 1; i<10; i++) {
            if(st[i] == 0) {
                int temp = c;
                st[i] = 1;
                temp = temp * 10 + i;

                dfs_c(u + 1, a, temp);
                st[i] = 0;
            }
        }
    }

    private static boolean check(int a, int c) {

        int[] temp = Arrays.copyOf(st,st.length);
        int b = c * (tar - a);
        if(b <= 0) return false;
        while(b != 0) {
            if(temp[b % 10] == 1 || b % 10 == 0) return false;
            else {
                temp[b % 10] = 1;
                b /= 10;
            }
        }

        for(int i = 1; i<=9; i++) {
            if(temp[i] == 0) {
                return false;
            }
        }
        return true;
    }

}
