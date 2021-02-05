package Leetcode_2020.November;

//给出一个区间的集合，请合并所有重叠的区间。
//
//         
//
//        示例 1:
//
//        输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出: [[1,6],[8,10],[15,18]]
//        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//        示例 2:
//
//        输入: intervals = [[1,4],[4,5]]
//        输出: [[1,5]]
//        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

import java.util.Arrays;
import java.util.Comparator;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int n = 0;
        int m = 0;
        if(len == 0 || len == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        for(int i=0; i<len-1; i++){
            //这里有两种情况是不可以合并的
            if(intervals[i][1] < intervals[i+1][0]) continue;
            if(intervals[i][1] > intervals[i+1][0] && intervals[i][0]>intervals[i+1][1]) continue;
            //可以合并的话，就很简单的赋值就好
            intervals[i][0] = intervals[i+1][0] =
                    intervals[i][0]<intervals[i+1][0]?intervals[i][0]:intervals[i+1][0];

            intervals[i][1] = intervals[i+1][1] =
                    intervals[i][1]>intervals[i+1][1]?intervals[i][1]:intervals[i+1][1];
        }
        //这个循环用来测算返回数组的长度
        for(int j = 0; j<len-1; j++){
            if(intervals[j][0] == intervals[j+1][0] && j!=len-2){
                continue;
            }
            if(j == len-2 && intervals[j][0] != intervals[j+1][0]){
                n+=2; break;
            }
            n++;
        }
        // return intervals;
        int[][] ans = new int[n][2];
        for(int i = 0; i<len-1; i++){
            if(intervals[i][0] != intervals[i+1][0]){
                ans[m][0] = intervals[i][0];
                ans[m][1] = intervals[i][1];
                m++;
            }
            else continue;
        }
        //无论如何，最后一个没办法在循环里加，但是巧了最后一个必要在最后加入ans
        ans[n-1][0] = intervals[len-1][0];
        ans[n-1][1] = intervals[len-1][1];

        return ans;
    }
}
