package Leetcode.Leetcode_2022.May_2022;

public class CountPrefixesofaGivenString_6051 {
    public int countPrefixes(String[] words, String s) {
        int len = words.length;
        char[] res = s.toCharArray();
        int ans = 0;
        for(int i = 0; i<len; i++) {
            if(check(words[i], res)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(String word, char[] res) {
        int l1 = word.length();
        int l2 = res.length;

        if(l1 > l2) return false;
        for(int i = 0; i<l1; i++) {
            if(word.charAt(i) != res[i]) {
                return false;
            }
        }
        return true;
    }
}
