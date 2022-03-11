package LanQiaoCup;

import java.util.Scanner;

/**
 * 给定一个长度为 N 的数列，A1,A2,…AN，如果其中一段连续的子序列 Ai,Ai+1,…Aj 之和是 K 的倍数，我们就称这个区间 [i,j] 是 K 倍区间。
 * <p>
 * 你能求出数列中总共有多少个 K 倍区间吗？
 * <p>
 * 输入格式
 * 第一行包含两个整数 N 和 K。
 * <p>
 * 以下 N 行每行包含一个整数 Ai。
 * <p>
 * 输出格式
 * 输出一个整数，代表 K 倍区间的数目。
 * <p>
 * 数据范围
 * 1≤N,K≤100000,
 * 1≤Ai≤100000
 * 输入样例：
 * 5 2
 * 1
 * 2
 * 3
 * 4
 * 5
 * 输出样例：
 * 6
 */

public class Acwing_1230 {


    // 这道题一直给我的感觉就是好像在哪里写过，像这种双指针要从头开始遍历的题目有必要思考一下
    // 重复便利时是否可以用额外的空间去记录下以往遍历的历史
    // 还有一个小tip，就是记得在数据比较大的时候开long！！！
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int len = reader.nextInt();
        int[] arr = new int[len];
        int tar = reader.nextInt();
        for (int i = 0; i < len; i++) {
            arr[i] = reader.nextInt();
        }
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (i == 0) sum[i] = arr[i] % tar;
            else sum[i] = (sum[i - 1] + arr[i]) % tar;
        }

        long ans = 0;
        int[] res = new int[tar];
        res[0] = 1;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (sum[i] == 0) ans++;
            } else {
                int temp = sum[i];
                ans += res[temp];
            }
            res[sum[i]]++;
        }

        System.out.print(ans);
    }


}

