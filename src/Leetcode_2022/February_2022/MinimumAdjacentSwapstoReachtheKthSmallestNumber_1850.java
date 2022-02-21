package Leetcode_2022.February_2022;

public class MinimumAdjacentSwapstoReachtheKthSmallestNumber_1850 {
    public int getMinSwaps(String num, int k) {
        char[] n = num.toCharArray();
        char[] m = num.toCharArray();
        int ans = 0;
        while (k != 0) {
            getNext(n);
            k--;
        }
        for (int i = 0; i < n.length; i++) {
            if (m[i] != n[i]) {
                int j = i;
                while (n[i] != m[j]) {
                    j++;
                }
                for (int a = j; a > i; a--) {
                    swap(m, a, a - 1);
                    ++ans;
                }

            }
        }
        return ans;
    }

    public void getNext(char[] n) {
        int len = n.length;
        int i = len - 2, j = len - 1;
        while (i >= 0 && n[i] >= n[i + 1]) {
            i--;
        }

        if (i >= 0) {
            while (j > i) {
                if (n[j] > n[i]) {
                    swap(n, i, j);
                    break;
                }
                j--;
            }
        }

        reverse(n, i + 1, len - 1);
    }

    public void swap(char[] n, int i, int j) {
        char temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    public void reverse(char[] n, int s, int e) {
        while (s < e) {
            swap(n, s, e);
            s++;
            e--;
        }
    }
}
