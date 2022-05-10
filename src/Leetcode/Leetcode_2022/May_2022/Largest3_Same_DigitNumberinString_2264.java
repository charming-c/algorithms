package Leetcode.Leetcode_2022.May_2022;

public class Largest3_Same_DigitNumberinString_2264 {
    public String largestGoodInteger(String num) {
        char[] res = num.toCharArray();
        int len = res.length;

        int l = 0, r = 0;
        int ans = -1;
        while( r < len) {
            if(res[l] == res[r]) {
                if(r - l + 1 == 3) {
                    ans = Math.max(ans, Integer.parseInt(String.valueOf(res[r])));
                }

            }

            else {
                l = r;
            }
            r++;
        }
        if(ans == -1) return "";

        return ans + "" + ans + "" + ans;
    }
}
