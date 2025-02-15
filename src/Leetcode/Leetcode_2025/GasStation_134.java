package Leetcode.Leetcode_2025;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] res = new int[len];
        int sum = 0;

        for(int i = 0; i < len; i++) {
            res[i] = gas[i] - cost[i];
            sum += res[i];
        }

        if (sum < 0) return -1;
        if (len == 1) return 0;

        int contain = res[0];
        int l = 0, r = 1;

        while (l != r) {
            if(contain < 0) {
                l = r;
                contain = res[r];
            }
            else {
                contain += res[r];
            }
            r = (r + len + 1) % len;
        }
        return l;
    }
}
