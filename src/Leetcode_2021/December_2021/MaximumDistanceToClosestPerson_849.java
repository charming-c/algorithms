package Leetcode_2021.December_2021;

//给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
//
//        至少有一个空座位，且至少有一人已经坐在座位上。
//
//        亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//
//        返回他到离他最近的人的最大距离。
//
//         
//
//        示例 1：
//
//
//        输入：seats = [1,0,0,0,1,0,1]
//        输出：2
//        解释：
//        如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
//        如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
//        因此，他到离他最近的人的最大距离是 2 。

public class MaximumDistanceToClosestPerson_849 {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                left = i;
                break;
            }
        }
        right = left + 1;
        int ans = left;
        while (right < len) {
            if (right == len - 1 && seats[right] == 0) {
                ans = Math.max(ans, right - left);
                right++;
            } else if (seats[right] == 1) {
                ans = Math.max((right - left) / 2, ans);
                left = right;
                right++;
            } else {
                right++;
            }
        }
        return ans;
    }
}
