package Leetcode.Leetcode_2024;

public class MaximumNumberofVowelsinaSubstringofGivenLength_1456 {
    public int maxVowels(String s, int k) {
        char[] res = s.toCharArray();
        int len = res.length;
        int l = 0, r = 0;
        int count = 0;

        for(r = 0; r < k; r++) {
            if(res[r] == 'a' || res[r] == 'e' || res[r] == 'i' || res[r] == 'o' || res[r] == 'u')
                count++;
        }
        int ans = count;

        while(r < len) {
            System.out.println(r);
            if(res[r] == 'a' || res[r] == 'e' || res[r] == 'i' || res[r] == 'o' || res[r] == 'u')
                count++;
            if(res[l] == 'a' || res[l] == 'e' || res[l] == 'i' || res[l] == 'o' || res[l] == 'u')
                count--;
            l++;
            ans = Math.max(ans, count);
            r++;
        }
        return ans;
    }
}
