package Leetcode.Leetcode_2025;

public class Candy_135 {
    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] left = new int[len];
        for(int i = 0; i< len; i++) {
            if(i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int ans = 0;
        int right = 1;
        for(int j = len - 1; j >= 0; j--) {
            if(j < len - 1 && ratings[j] > ratings[j + 1]) {
                right = right + 1;
            } else {
                right = 1;
            }

            ans += Math.max(left[j], right);
        }
        return ans;
    }
}
