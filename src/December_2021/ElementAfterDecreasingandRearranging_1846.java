package December_2021;

import java.util.Arrays;

public class ElementAfterDecreasingandRearranging_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        arr[0] = 1;

        for (int i = 1; i < len; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[len - 1];
    }
}
