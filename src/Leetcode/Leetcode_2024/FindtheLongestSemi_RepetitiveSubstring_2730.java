package Leetcode.Leetcode_2024;

public class FindtheLongestSemi_RepetitiveSubstring_2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        char[] res = s.toCharArray();
        int len = res.length;
        if(len <= 2) return len;
        int l = 0, r = 1;
        int count = 0;
        int ans = 1;

        while (r < len) {
            if(res[r] == res[r - 1]) count++;
            r++;

            if(count <= 1) ans = Math.max(ans, r - l);
            else {
                if(l + 1 < len && res[l] == res[l + 1])
                    count--;
                l++;
            }
        }

        return ans;
    }
}
