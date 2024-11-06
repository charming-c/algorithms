package Leetcode.Leetcode_2024;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumWhiteTilesCoveredbyaCarpet_2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        int ans = 0, cover = 0, left = 0;

        for(int[] t: tiles) {
            int tl = t[0];
            int tr = t[1];
            cover += tr - tl + 1;
            while (tiles[left][1] < tr - carpetLen + 1) {
                cover -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
            ans = Math.max(ans, cover - Math.max(0, tr - carpetLen + 1 - tiles[left][0]));
        }

        return ans;
    }
}
