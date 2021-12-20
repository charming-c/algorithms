package Leetcode_2021.October_2021;

//Given an integer array arr and an integer k, modify the array by repeating it k times.
//
//        For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
//
//        Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
//
//        As the answer can be very large, return the answer modulo 109 + 7.
//
//         
//
//        Example 1:
//
//        Input: arr = [1,2], k = 3
//        Output: 9
//        Example 2:
//
//        Input: arr = [1,-2,1], k = 5
//        Output: 2
//        Example 3:
//
//        Input: arr = [-1,-2], k = 7
//        Output: 0
//

public class K_KoncatenationMaximumSum_1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        long maxOfEnd = arr[0] > 0 ? arr[0] : 0L, maxSoFar = maxOfEnd, sum = arr[0];
        for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
            if (i < arr.length) sum += arr[i];
        }
        while (sum > 0 && --k >= 2)
            maxSoFar = (maxSoFar + sum) % 1000000007;
        return (int) maxSoFar % 1000000007;
    }
}
