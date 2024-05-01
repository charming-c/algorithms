package Leetcode.Leetcode_2024;

import java.util.HashMap;

public class CountCompleteSubstrings_2953 {
    public int countCompleteSubstrings(String word, int k) {
        char[] res = word.toCharArray();
        int len = res.length;
        int ans = 0;
        int[] count = new int[len];
        for (int i = 1; i < len; i++) {
            if (Math.abs(res[i] - res[i - 1]) > 2) count[i]++;
            count[i] += count[i - 1];
        }

        for (int i = 1; i <= 26 && i * k <= len; i++) {
            int l = 0, r = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (r = 0; r < i * k; r++) {
                map.merge(res[r], 1, Integer::sum);

            }
            if (count[r - 1] - count[l] == 0 && map.keySet().size() == i) {
                ans++;
                for (char c : map.keySet()) {
                    if (map.get(c) != k)
                        ans--;
                    break;
                }
            }
            while (r < len) {
                map.merge(res[l++], -1, Integer::sum);
                if (map.get(res[l - 1]) == 0) map.remove(res[l - 1]);
                map.merge(res[r++], 1, Integer::sum);
                if (count[r - 1] - count[l] == 0 && map.keySet().size() == i) {
                    ans++;
                    for (char c : map.keySet()) {
                        if (map.get(c) != k) {
                            ans--;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
