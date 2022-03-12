package LanQiaoCup;

import java.io.IOException;
import java.util.Scanner;

public class Acwing_895 {

    // 二分加贪心 nlogn 时间复杂度
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] res = new int[len + 1];
        res[1] = arr[0];
        int ans = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] > res[ans]) {
                ans++;
                res[ans] = arr[i];
            } else {
                int l = 1, r = ans;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (arr[i] <= res[mid]) {
                        r = mid;
                    } else l = mid + 1;
                }
                res[l] = arr[i];
            }
        }
        System.out.println(ans);
    }
}
