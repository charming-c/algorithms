package LanQiaoCup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * “飞行员兄弟”这个游戏，需要玩家顺利的打开一个拥有 16 个把手的冰箱。
 * <p>
 * 已知每个把手可以处于以下两种状态之一：打开或关闭。
 * <p>
 * 只有当所有把手都打开时，冰箱才会打开。
 * <p>
 * 把手可以表示为一个 4×4 的矩阵，您可以改变任何一个位置 [i,j] 上把手的状态。
 * <p>
 * 但是，这也会使得第 i 行和第 j 列上的所有把手的状态也随着改变。
 * <p>
 * 请你求出打开冰箱所需的切换把手的次数最小值是多少。
 * <p>
 * 输入格式
 * 输入一共包含四行，每行包含四个把手的初始状态。
 * <p>
 * 符号 + 表示把手处于闭合状态，而符号 - 表示把手处于打开状态。
 * <p>
 * 至少一个手柄的初始状态是关闭的。
 * <p>
 * 输出格式
 * 第一行输出一个整数 N，表示所需的最小切换把手次数。
 * <p>
 * 接下来 N 行描述切换顺序，每行输出两个整数，代表被切换状态的把手的行号和列号，数字之间用空格隔开。
 * <p>
 * 注意：如果存在多种打开冰箱的方式，则按照优先级整体从上到下，同行从左到右打开。
 * <p>
 * 数据范围
 * 1≤i,j≤4
 * 输入样例：
 * -+--
 * ----
 * ----
 * -+--
 * 输出样例：
 * 6
 * 1 1
 * 1 3
 * 1 4
 * 4 1
 * 4 3
 * 4 4
 */

public class Acwing_116 {

    // 本题的核心就是利用暴力枚举出所有的可能性，利用了二进制数为每个选择做简化
    // 本身是比较暴力的做法
    static char[][] g = new char[4][4];
    static char[][] backup = new char[4][4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++)
            g[i] = scanner.next().toCharArray();

        List<int[]> ans = new ArrayList<>();
        for (int op = 0; op < 1 << 16; op++) {
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                backup[i] = Arrays.copyOf(g[i], g[i].length);
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (((op >> get(i, j)) & 1) == 1) {
                        turn(i, j);
                        temp.add(new int[]{i, j});
                    }
                }
            }

            boolean shut = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (g[i][j] == '+') {
                        shut = true;
                        break;
                    }
                }
            }
            if (!shut) {
                if (ans.isEmpty() || ans.size() > temp.size()) {
                    ans = temp;
                }
            }

            for (int i = 0; i < 4; i++) {
                g[i] = Arrays.copyOf(backup[i], backup[i].length);
            }
        }

        System.out.println(ans.size());
        for (int[] p : ans) {
            System.out.println((p[0] + 1) + " " + (p[1] + 1));
        }
    }

    private static void turn(int x, int y) {
        for (int i = 0; i < 4; i++) {
            change(x, i);
            change(i, y);
        }
        change(x, y);
    }

    private static void change(int i, int j) {
        if (g[i][j] == '+') {
            g[i][j] = '-';
        } else g[i][j] = '+';
    }

    private static int get(int i, int j) {
        return 4 * i + j;
    }

}
