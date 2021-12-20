package Leetcode_2021.January_2021;

//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
//
//        若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
//        或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
//        也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
//
//        返回 A 的最大湍流子数组的长度。
//
//         
//
//        示例 1：
//
//        输入：[9,4,2,10,7,8,8,1,9]
//        输出：5
//        解释：(A[1] > A[2] < A[3] > A[4] < A[5])

public class LongestTurbulentSubarray_978 {
    // 动态规划不过如此，我承认我膨胀了
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        int max = 1;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = 1;
            if (i == 0 || getSign(arr[i - 1], arr[i]) == 0) {
                temp[i] = 1;
            } else if (i == 1) temp[i] = 2;
            else if (getSign(arr[i - 2], arr[i - 1]) * getSign(arr[i - 1], arr[i]) == -1) {
                temp[i] = temp[i - 1] + 1;
            } else temp[i] = 2;
            max = Math.max(max, temp[i]);

        }
        return max;
    }

    public int getSign(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;
    }
}
