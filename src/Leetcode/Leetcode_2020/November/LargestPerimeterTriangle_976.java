package Leetcode.Leetcode_2020.November;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {
    public int largestPerimeter1(int[] A) {
        int length = A.length;
        if (length < 2) return 0;
        Arrays.sort(A);
        while (length > 2) {
            int a = A[length - 1];
            int b = A[length - 2];
            for (int i = length - 3; i >= 0; i--) {
                if (A[i] > a - b) {
                    return a + b + A[i];
                }
            }
            length--;
        }
        return 0;
    }
    //    方法一：贪心 + 排序
//    不失一般性，我们假设三角形的边长满足 a≤b≤c，那么这三条边组成面积不为零的三角形的充分必要条件为 a+b>c
//
//    基于此，我们可以选择枚举三角形的最长边 c，而从贪心的角度考虑，我们一定是选「小于 c 的最大的两个数」作为边长 a 和 b，此时最有可能满足 a+b>c
//    使得三条边能够组成一个三角形，且此时的三角形的周长是最大的。
//
//    因此，我们先对整个数组排序，倒序枚举第 i 个数作为最长边，
//    那么我们只要看其前两个数 A[i-2]A[i−2] 和 A[i-1]A[i−1]，
//    判断 A[i-2]+A[i-1]A[i−2]+A[i−1] 是否大于 A[i]A[i] 即可，
//    如果能组成三角形我们就找到了最大周长的三角形，返回答案 A[i-2]+A[i-1]+A[i]A[i−2]+A[i−1]+A[i] 即可。
//    如果对于任何数作为最长边都不存在面积不为零的三角形，则返回答案 0。


    public int largestPerimeter2(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

}
