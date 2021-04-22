package April_2021;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
//        每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//         
//
//        示例 1：
//
//        输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        输出：11
//        解释：如下面简图所示：
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

import java.util.List;

public class Triangle_120 {
    // 无脑递归，直接超时
    class Solution {
        int maxDepth;
        public int minimumTotal(List<List<Integer>> triangle) {
            maxDepth = triangle.size();
            return minTotal(triangle, triangle.get(0).get(0), 0, 1);
        }

        public int minTotal(List<List<Integer>> triangle, int sum , int location, int depth){
            if(depth >= maxDepth) return sum;
            else
                return Math.min(minTotal(triangle, sum + triangle.get(depth).get(location),location, depth + 1),minTotal(triangle, sum + triangle.get(depth).get(location+1),location + 1, depth+ 1));
        }
    }
    // 动态规划，简简单单
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for(int i = m-1; i>=0; i--){
            for(int j = 0; j<=i; j++){
                if(i == m-1){
                    dp[i][j] = triangle.get(i).get(j);
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }
}
