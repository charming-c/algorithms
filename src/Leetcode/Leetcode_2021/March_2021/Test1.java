package Leetcode.Leetcode_2021.March_2021;

//今年是国际数学联盟确定的“ 2000 ——世界数学年”，又恰逢我国著名数学家华罗庚先生诞辰 90 周年。在华罗庚先生的家乡江苏金坛，
// 组织了一场别开生面的数学智力竞赛的活动，你的一个好朋友 XZ 也有幸得以参加。活动中，主持人给所有参加活动的选手出了这样一道题目：
//
//        设有一个长度为 N 的数字串，要求选手使用 K 个乘号将它分成 K+1 个部分，
//        找出一种分法，使得这 K+1 个部分的乘积能够为最大。
//
//        同时，为了帮助选手能够正确理解题意，主持人还举了如下的一个例子：
//
//        有一个数字串：312， 当 N=3，K=1 时会有以下两种分法：
//
//        3×12=36
//        31×2=62
//        这时，符合题目要求的结果是：31×2=62
//        现在，请你帮助你的好朋友 XZ 设计一个程序，求得正确的答案。
//
//        输入描述
//        输入共有两行：
//
//        第一行共有 2 个自然数 N，K（6≤N≤40，1≤K≤6）。
//
//        第二行是一个长度为 N 的数字串。

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class  Test1{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String s = scan.next();
        int [] a = new int[n+1];
        for(int i = 0; i < s.length(); i++) { // 获取s每一位上的值
            a[i+1] = s.charAt(i) - '0';
        }
        int[][] dp = new int[n+1][k+1];
        int[][] v = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {//v[i][j]表示 从i到j构成的数
            for (int j = i; j <= n; j++) {
                v[i][j] = v[i][j-1] * 10 + a[j];
            }
        }
        for(int i = 1; i <= n; i++) {//初始化,0个乘号时即为1到i数的大小
            dp[i][0] = v[1][i];
        }
        for(int t = 1; t <= k; t++) { // t个乘号
            for(int i = 1; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i][t] = Math.max(dp[i][t], dp[j][t-1] * v[j+1][i]);
                }
            }
        }
        System.out.println(dp[n][k]);
        scan.close();
    }
}