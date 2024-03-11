package Leetcode.Leetcode_2024;

import java.util.Arrays;

public class CanIWin_464 {
    private int[] visit = new int[1<<21];
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Arrays.fill(visit, 0);
        if(maxChoosableInteger > desiredTotal) return true;
        if((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) return false;

        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        if (visit[state] == 1) return true;
        if (visit[state] == 2) return false;


        for(int i = 1; i<=maxChoosableInteger; i++) {

            if((state & (1<<i)) == (1<<i)) continue;
            if(visit[state | (1 << i)] != 0) {
                if(visit[state | (1 << i)] == 1) return true;
                else continue;
            }
            if(sum + i >= desiredTotal) {
                visit[state | (1 << i)] = 1;
                return true;
            }
            else {
                if(!dfs(state | (1 << i), sum + i, maxChoosableInteger, desiredTotal)) {
                    visit[state | (1 << i)] = 1;
                    return true;
                }
            }

        }
        visit[state] = 2;
        return false;
    }
}
