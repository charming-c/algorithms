package LanQiaoCup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        int k = m + n + 1;

        arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long res = 0;
        if(m == 0) {
            for(int i = 0; i<k; i++) {
                res += arr[i];
            }
        }
        else {
            Arrays.sort(arr);
            res = arr[k-1] - arr[0];

            for(int i = 1; i<k-1; i++) {
                res += Math.abs(arr[i]);
            }
        }
        System.out.println(res);
    }
}
