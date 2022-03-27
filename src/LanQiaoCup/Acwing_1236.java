package LanQiaoCup;

import java.util.*;
import java.io.*;

/**
 * 给定三个整数数组
 * <p>
 * A=[A1,A2,…AN],
 * B=[B1,B2,…BN],
 * C=[C1,C2,…CN],
 * <p>
 * 请你统计有多少个三元组 (i,j,k) 满足：
 * <p>
 * 1≤i,j,k≤N
 * Ai<Bj<Ck
 * 输入格式
 * 第一行包含一个整数 N。
 * <p>
 * 第二行包含 N 个整数 A1,A2,…AN。
 * <p>
 * 第三行包含 N 个整数 B1,B2,…BN。
 * <p>
 * 第四行包含 N 个整数 C1,C2,…CN。
 * <p>
 * 输出格式
 * 一个整数表示答案。
 * <p>
 * 数据范围
 * 1≤N≤105,
 * 0≤Ai,Bi,Ci≤105
 * 输入样例：
 * 3
 * 1 1 1
 * 2 2 2
 * 3 3 3
 * 输出样例：
 * 27
 */

public class Acwing_1236 {


    // 解法一：二分做法
    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(br.readLine());
            int[] res1 = new int[len];
            int[] res2 = new int[len];
            int[] res3 = new int[len];
            long ans = 0L;

            res1 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            res2 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            res3 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

            Arrays.sort(res1);
            Arrays.sort(res3);

            for (int i = 0; i < len; i++) {
                if (res2[i] <= res1[0] || res2[i] >= res3[len - 1]) {
                    continue;
                }
                int l = bs1(res1, res2[i]);
                int r = bs2(res3, res2[i]);
                ans += (long) (l + 1) * (len - r);
            }

            System.out.println(ans);
        }

        private static int bs2(int[] res, int num) {
            int l = 0, r = res.length - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (res[mid] <= num) {
                    l = mid + 1;
                } else r = mid;
            }
            return r;
        }

        private static int bs1(int[] res, int num) {
            int l = 0, r = res.length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (res[mid] >= num) {
                    r = mid - 1;
                } else l = mid;
            }

            return l;
        }
    }

    // 前缀和做法
    public static class Main2 {

        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            int N = 100010;
            int len = scanner.nextInt();
            int[] res1 = new int[len];
            int[] res2 = new int[len];
            int[] res3 = new int[len];
            long ans = 0L;

            for (int i = 0; i < len; i++) res1[i] = scanner.nextInt();
            for (int i = 0; i < len; i++) res2[i] = scanner.nextInt();
            for (int i = 0; i < len; i++) res3[i] = scanner.nextInt();

            int[] pre1 = new int[N];
            int[] lat1 = new int[N];
            for (int i = 0; i < len; i++) pre1[res1[i]]++;
            for (int i = 0; i < len; i++) lat1[res3[i]]++;

            for (int i = 1; i < N; i++) pre1[i] += pre1[i - 1];
            for (int i = N - 2; i >= 0; i--) lat1[i] += lat1[i + 1];

            for (int i = 0; i < len; i++) {
                if (res2[i] == 0 || res2[i] == 100000) continue;
                ans += (long) pre1[res2[i] - 1] * lat1[res2[i] + 1];
            }

            System.out.println(ans);
        }

    }
}
