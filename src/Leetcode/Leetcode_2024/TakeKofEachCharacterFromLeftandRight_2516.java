package Leetcode.Leetcode_2024;

public class TakeKofEachCharacterFromLeftandRight_2516 {
    public int takeCharacters(String s, int k) {
        char[] res = s.toCharArray();
        int[] count = new int[3];
        int l = 0, r = 0;
        int len = res.length;
        int ans = Integer.MAX_VALUE;
        for(char c : res) {
            count[c - 'a']++;
        }
        if(len == 0 || len < 3 * k) return -1;
        if(count[0] < k || count[1] < k || count[2] < k) return -1;
        while (l <= len && r < len) {
            while (l <= len && count[0] >= k && count[1] >= k && count[2] >= k) {
                ans = Math.min(r + len - l, ans);
                count[res[l % len] - 'a']--;
                l++;
            }
            count[res[r % len] - 'a']++;
            r++;
        }
        return ans;
    }
}
