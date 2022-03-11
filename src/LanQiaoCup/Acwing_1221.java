package LanQiaoCup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 四平方和定理，又称为拉格朗日定理：
 * <p>
 * 每个正整数都可以表示为至多 4 个正整数的平方和。
 * <p>
 * 如果把 0 包括进去，就正好可以表示为 4 个数的平方和。
 * <p>
 * 比如：
 * <p>
 * 5=02+02+12+22
 * 7=12+12+12+22
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 * <p>
 * 要求你对 4 个数排序：
 * <p>
 * 0≤a≤b≤c≤d
 * 并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法。
 * <p>
 * 输入格式
 * 输入一个正整数 N。
 * <p>
 * 输出格式
 * 输出4个非负整数，按从小到大排序，中间用空格分开。
 * <p>
 * 数据范围
 * 0<N<5∗106
 * 输入样例：
 * 5
 * 输出样例：
 * 0 0 1 2
 */

public class Acwing_1221 {
    private static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //预处理后两项
        for (int c = 0; c * c <= n; c++) {
            for (int d = c; c * c + d * d <= n; d++) {
                list.add(new int[]{c * c + d * d, c, d});
            }
        }
        //字典序排序
        list.sort(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] != 0) {
                    return o1[0] - o2[0];
                }
                if (o1[1] - o2[1] != 0) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });
        //枚举符合条件的前两项
        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a * a + b * b <= n; b++) {
                int t = n - a * a - b * b;
                //二分查找t是否存在后两项中
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {
                    int m = l + r >> 1;
                    if (list.get(m)[0] >= t) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                if (list.get(l)[0] == t) {
                    int c = list.get(l)[1];
                    int d = list.get(l)[2];
                    System.out.printf("%d %d %d %d", a, b, c, d);
                    return;
                }
            }
        }

    }
}
