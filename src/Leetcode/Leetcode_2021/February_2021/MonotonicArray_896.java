package Leetcode.Leetcode_2021.February_2021;

//如果数组是单调递增或单调递减的，那么它是单调的。
//
//        如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
//
//        当给定的数组 A 是单调数组时返回 true，否则返回 false。
//
//         
//
//        示例 1：
//
//        输入：[1,2,2,3]
//        输出：true


public class MonotonicArray_896 {
    public boolean isMonotonic(int[] A) {
        return isOrder(A) || reOrder(A);
    }

    public boolean isOrder(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                return false;
        }
        return true;
    }

    public boolean reOrder(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1])
                return false;
        }
        return true;
    }
}
