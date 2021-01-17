package January_2021;

//在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
//
//        请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
//
//         
//
//        示例 1：
//
//
//
//        输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//        输出：true

public class CheckIfItIsAStraightLine_1232 {
    // 一道简单的题目
    public boolean checkStraightLine(int[][] coordinates) {
        double k = 0;
        double b = 0;
        int length = coordinates.length;
        if (length <= 2) return true;
        if ((coordinates[1][0] - coordinates[0][0]) == 0) {
            for (int i = 2; i < length; i++) {
                if (coordinates[i][0] != coordinates[0][0])
                    return false;
            }
        } else if ((coordinates[1][0] - coordinates[0][0]) != 0) {
            k = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
            b = coordinates[0][1] - k * coordinates[0][0];
            for (int i = 2; i < length; i++) {
                if (k * coordinates[i][0] + b != coordinates[i][1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
