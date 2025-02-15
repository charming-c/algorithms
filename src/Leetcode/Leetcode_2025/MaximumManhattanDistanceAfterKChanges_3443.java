package Leetcode.Leetcode_2025;

public class MaximumManhattanDistanceAfterKChanges_3443 {
    public int maxDistance(String s, int k) {
        char[] res = s.toCharArray();
        int len = res.length;
        int ans = 0;

        int[] count = {0, 0, 0, 0};

        for (char re : res) {
            switch (re) {
                case 'N':
                    count[0]++;
                    break;
                case 'S':
                    count[1]++;
                    break;
                case 'E':
                    count[2]++;
                    break;
                case 'W':
                    count[3]++;
                    break;
            }

            ans = Math.max(ans, calculate(count, k));
        }


        return ans;
    }

    private int calculate(int[] count, int k) {
        int x = Math.max(count[0], count[1]);
        int x1 = Math.min(count[0], count[1]);
        int y = Math.max(count[2], count[3]);
        int y1 = Math.min(count[2], count[3]);

        return x - x1 + y - y1 + Math.min(x1 + y1, k) * 2;
    }
}
