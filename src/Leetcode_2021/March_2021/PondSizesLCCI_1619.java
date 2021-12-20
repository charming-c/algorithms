package Leetcode_2021.March_2021;
//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
//
//        示例：
//
//        输入：
//        [
//        [0,2,1,0],
//        [0,1,0,1],
//        [1,1,0,1],
//        [0,1,0,1]
//        ]
//        输出： [1,2,4]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizesLCCI_1619 {
    public int[] pondSizes(int[][] land) {
        List<Integer> ans = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    count = DFS(land, i, j);
                    ans.add(count);
                }
            }
        }
        int l = ans.size();
        int[] ret = new int[l];
        while (l != 0) {
            ret[l - 1] = ans.get(l - 1);
            l--;
        }
        Arrays.sort(ret);
        return ret;
    }

    public int DFS(int[][] land, int start, int end) {
        if (start < 0 || end < 0 || start >= land.length || end >= land[0].length) return 0;
        if (land[start][end] != 0) return 0;
        int num = 1;
        land[start][end] = 1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                num += DFS(land, start + i, end + j);
            }
        }
        return num;
    }
}
