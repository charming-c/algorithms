package Leetcode.Leetcode_2021.November_2021;

//You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
//
//        Count and return the number of maximum integers in the matrix after performing all the operations.
//
//         
//
//        Example 1:
//
//
//        Input: m = 3, n = 3, ops = [[2,2],[3,3]]
//        Output: 4
//        Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.

public class RangeAdditionII_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int count = ops.length;
        int maxRow = m;
        int maxCol = n;
        for (int i = 0; i < count; i++) {
            maxRow = Math.min(ops[i][0], maxRow);
            maxCol = Math.min(ops[i][1], maxCol);
        }
        return maxRow * maxCol;
    }
}
