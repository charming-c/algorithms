package LanQiaoCup;

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

public class Acwing_1209 {

    //解法一：先求出1-9这个九个数的排列，再然后再每个排列中选择两处划分，划分出a—b-c三个部分，最后求解是否符合题意

    static int ans = 0;
    static int[] res = new int[9];
    static int[] st = new int[10];
    static int tar = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tar = scanner.nextInt();
        dfs(0);
        System.out.print(ans);
    }

    public static void dfs(int u) {
        if(u == 9) {
            dfs_t();
            return;
        }

        for(int i = 1; i<10; i++) {
            if(st[i] == 0) {
                st[i] = 1;
                res[u] = i;
                dfs(u + 1);
                st[i] = 0;
            }
        }
    }

    private static void dfs_t() {

        for(int i = 0; i<7; i++) {
            for(int j = i + 1; j<8; j++) {
                int a = getNum(0, i);
                int b = getNum(i + 1, j);
                int c = getNum(j + 1, 8);

                if(b % c == 0 && a + b / c == tar) {
                    ans++;
                }
            }
        }

    }

    private static int getNum(int i, int j) {
        int ans = 0;
        for(int x = i; x<=j; x++) {
            ans = ans * 10 + res[x];
        }
        return ans;
    }
}
