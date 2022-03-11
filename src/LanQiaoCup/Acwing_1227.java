package LanQiaoCup;

import java.util.Scanner;

/**
 * 儿童节那天有 K 位小朋友到小明家做客。
 *
 * 小明拿出了珍藏的巧克力招待小朋友们。
 *
 * 小明一共有 N 块巧克力，其中第 i 块是 Hi×Wi 的方格组成的长方形。
 *
 * 为了公平起见，小明需要从这 N 块巧克力中切出 K 块巧克力分给小朋友们。
 *
 * 切出的巧克力需要满足：
 *
 * 形状是正方形，边长是整数
 * 大小相同
 * 例如一块 6×5 的巧克力可以切出 6 块 2×2 的巧克力或者 2 块 3×3 的巧克力。
 *
 * 当然小朋友们都希望得到的巧克力尽可能大，你能帮小明计算出最大的边长是多少么？
 *
 * 输入格式
 * 第一行包含两个整数 N 和 K。
 *
 * 以下 N 行每行包含两个整数 Hi 和 Wi。
 *
 * 输入保证每位小朋友至少能获得一块 1×1 的巧克力。
 *
 * 输出格式
 * 输出切出的正方形巧克力最大可能的边长。
 *
 * 数据范围
 * 1≤N,K≤105,
 * 1≤Hi,Wi≤105
 * 输入样例：
 * 2 10
 * 6 5
 * 5 6
 * 输出样例：
 * 2
 */

public class Acwing_1227 {

    // 又是一个答案二分
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int cnt = scanner.nextInt();

        int[][] res = new int[len][2];

        for (int i = 0; i < len; i++) {
            res[i][0] = scanner.nextInt();
            res[i][1] = scanner.nextInt();
        }

        int l = 1, r = (int) 1e5;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, res, cnt)) {
                l = mid;
            } else r = mid - 1;
        }

        System.out.print(l);
    }

    private static boolean check(int mid, int[][] res, int cnt) {
        int len = res.length;
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int m = res[i][0] / mid;
            int n = res[i][1] / mid;
            ans += (long) m * n;
        }
        return ans >= cnt;
    }
}
