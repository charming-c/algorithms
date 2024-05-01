package Leetcode.Leetcode_2024;

import java.util.HashMap;

public class FruitIntoBaskets_904 {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        int ans = 0;
        while (r < len) {
            map.merge(fruits[r], 1, Integer::sum);
            r++;
            if(map.keySet().size() <= 2) ans = Math.max(ans, r - l);
            else {
                map.merge(fruits[l], -1, Integer::sum);
                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
        }
        return ans;
    }

}
