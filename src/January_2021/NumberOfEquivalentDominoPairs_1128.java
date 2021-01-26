package January_2021;

//给你一个由一些多米诺骨牌组成的列表 dominoes。
//
//        如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
//
//        形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
//
//        在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
//
//         
//
//        示例：
//
//        输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//        输出：1

import java.util.Arrays;

public class NumberOfEquivalentDominoPairs_1128 {

    // 放一个map，每次出现就统计次数，并将前一个数字填进答案。很妙
    public int numEquivDominoPairs(int[][] dominoes) {
        int len = dominoes.length;
        int ans = 0;
        int[] arr = new int[100];
        for(int i = 0; i<len; i++){
            Arrays.sort(dominoes[i]);
            ans += arr[dominoes[i][0] * 10 + dominoes[i][1]]++;
        }
        return ans;
    }

    // 这个自己写的方法，暴力双重循环，最后再通过巨长的测试用例的时候超时了
    public int numEquivDominoPairs2(int[][] dominoes) {
        int len = dominoes.length;
        if(len == 0 || len == 1) return 1;
        int[] dp = new int[len];
        int ans = 0;
        dp[0] = 0;
        for(int i = 0; i<len-1; i++){
            for(int j = i+1; j<len; j++){
                if(dominoes[j][0] == dominoes[i][0] && dominoes[j][1] == dominoes[i][1]){
                    ans++;
                }
                else if(dominoes[j][0] == dominoes[i][1] && dominoes[j][1] == dominoes[i][0]){
                    ans++;
                }
                else continue;
            }

        }
        return ans;
    }
}
