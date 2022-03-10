package LanQiaoCup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 你玩过“拉灯”游戏吗？
 *
 * 25 盏灯排成一个 5×5 的方形。
 *
 * 每一个灯都有一个开关，游戏者可以改变它的状态。
 *
 * 每一步，游戏者可以改变某一个灯的状态。
 *
 * 游戏者改变一个灯的状态会产生连锁反应：和这个灯上下左右相邻的灯也要相应地改变其状态。
 *
 * 我们用数字 1 表示一盏开着的灯，用数字 0 表示关着的灯。
 *
 * 下面这种状态
 *
 * 10111
 * 01101
 * 10111
 * 10000
 * 11011
 * 在改变了最左上角的灯的状态后将变成：
 *
 * 01111
 * 11101
 * 10111
 * 10000
 * 11011
 * 再改变它正中间的灯后状态将变成：
 *
 * 01111
 * 11001
 * 11001
 * 10100
 * 11011
 * 给定一些游戏的初始状态，编写程序判断游戏者是否可能在 6 步以内使所有的灯都变亮。
 *
 * 输入格式
 * 第一行输入正整数 n，代表数据中共有 n 个待解决的游戏初始状态。
 *
 * 以下若干行数据分为 n 组，每组数据有 5 行，每行 5 个字符。
 *
 * 每组数据描述了一个游戏的初始状态。
 *
 * 各组数据间用一个空行分隔。
 *
 * 输出格式
 * 一共输出 n 行数据，每行有一个小于等于 6 的整数，它表示对于输入数据中对应的游戏状态最少需要几步才能使所有灯变亮。
 *
 * 对于某一个游戏初始状态，若 6 步以内无法使所有灯变亮，则输出 −1。
 *
 * 数据范围
 * 0<n≤500
 * 输入样例：
 * 3
 * 00111
 * 01011
 * 10001
 * 11010
 * 11100
 *
 * 11101
 * 11101
 * 11110
 * 11111
 * 11111
 *
 * 01111
 * 11111
 * 11111
 * 11111
 * 11111
 * 输出样例：
 *
 * 3
 * 2
 * -1
 */

public class Acwing_95 {

    static char[][]g = new char[5][5];
    static char[][] backup = new char[5][5];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        while(T != 0) {

            for(int i = 0; i < 5; i++) {
                g[i] = scanner.next().toCharArray();
            }
            int res = 10;
            for(int op = 0; op < 32; op++) {
                for(int i = 0; i<5; i++) {
                    backup[i] = Arrays.copyOf(g[i], g[i].length);
                }
                int step = 0;
                for(int i = 0; i<5; i++) {
                    if(((op >> i) & 1) == 1) {
                        step++;
                        turn(0,i);
                    }
                }

                for(int i = 0; i<4; i++) {
                    for(int j = 0; j<5; j++) {
                        if(g[i][j] == '0') {
                            step++;
                            turn(i + 1, j);
                        }
                    }
                }

                boolean dark = false;
                for(int i = 0; i<5; i++) {
                    if(g[4][i] == '0') {
                        dark = true;
                        break;
                    }
                }
                if(!dark) res = Math.min(res, step);
                for(int i = 0; i<5; i++) {
                    g[i] = Arrays.copyOf(backup[i], backup[i].length);
                }
            }
            if(res > 6) res = -1;
            System.out.println(res);
            T--;
        }
    }

    static int[][] dirs = new int[][]{{0,-1}, {-1, 0}, {1,0}, {0,1}, {0,0}};
    private static void turn(int x, int y) {
        for(int i = 0; i<5; i++) {
            int a = x + dirs[i][0];
            int b = y + dirs[i][1];

            if(a < 0 || a >= 5 || b < 0 || b >= 5) continue;

            g[a][b] ^= 1;
        }
    }
}
