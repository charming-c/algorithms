package LanQiaoCup;

import java.util.Scanner;

/**
 * 器人正在玩一个古老的基于 DOS 的游戏。
 *
 * 游戏中有 N+1 座建筑——从 0 到 N 编号，从左到右排列。
 *
 * 编号为 0 的建筑高度为 0 个单位，编号为 i 的建筑高度为 H(i) 个单位。
 *
 * 起初，机器人在编号为 0 的建筑处。
 *
 * 每一步，它跳到下一个（右边）建筑。
 *
 * 假设机器人在第 k 个建筑，且它现在的能量值是 E，下一步它将跳到第 k+1 个建筑。
 *
 * 如果 H(k+1)>E，那么机器人就失去 H(k+1)−E 的能量值，否则它将得到 E−H(k+1) 的能量值。
 *
 * 游戏目标是到达第 N 个建筑，在这个过程中能量值不能为负数个单位。
 *
 * 现在的问题是机器人至少以多少能量值开始游戏，才可以保证成功完成游戏？
 *
 * 输入格式
 * 第一行输入整数 N。
 *
 * 第二行是 N 个空格分隔的整数，H(1),H(2),…,H(N) 代表建筑物的高度。
 *
 * 输出格式
 * 输出一个整数，表示所需的最少单位的初始能量值上取整后的结果。
 *
 * 数据范围
 * 1≤N,H(i)≤105,
 *
 * 输入样例1：
 * 5
 * 3 4 3 2 4
 * 输出样例1：
 * 4
 */

public class Acwing_730 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] H = new int[len];
        for(int i =0; i<len; i++) {
            H[i] = in.nextInt();
        }

        int l = 1, r = (int)1e5;
        while(l < r) {
            int mid = (r + l) / 2;
            if(check(mid, H)) {
                r = mid;
            }
            else l = mid + 1;
        }
        System.out.println(r);
    }

    private static boolean check(int mid, int[] H) {
        int len = H.length;
        for(int i = 0; i<len; i++) {

            if(H[i] > mid) {
                mid -= H[i] - mid;
            }
            else {
                mid += mid - H[i];
            }

            // 如果不判断边界情况，这里的数据会爆掉所以要做一个特判
            if(mid > 1e5) return true;
            if(mid < 0) return false;
        }
        return  (mid >= 0);
    }
}

