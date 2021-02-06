package February_2021;

//几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
//
//        每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
//
//        你的点数就是你拿到手中的所有卡牌的点数之和。
//
//        给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
//
//         
//
//        示例 1：
//
//        输入：cardPoints = [1,2,3,4,5,6,1], k = 3
//        输出：12
//        解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。

public class MaximumPointsYouCanObtainFromCards_1423 {

    // 这道题的核心就是将其转换成一个长度为n-k的滑动窗口
    // 这个窗口一定是连续的，所以我们可以求出数组总和，
    // 然后动态维护这个滑动窗口的最小值就可以了
    // 具体的维护可以参考最简单的一类动态规划的方法
    // 利用一个变量在迭代时进行条件判定
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
        int sumOfWindow = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
        }
        for (int i = 0; i < len; i++) {
            sumOfWindow += cardPoints[i];
            if (i >= len - k) {
                sumOfWindow -= cardPoints[i + k - len];
                ans = Math.max(ans, sum - sumOfWindow);
            }
            if (i == len - k - 1) {
                ans = sum - sumOfWindow;
            }
        }
        return ans;
    }

    // 这个方法比较容易想到，但是超时了，时间复杂度时o(n*n)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int len = cardPoints.length;
            int sum = 0;
            int sumOfCurrentWindow = 0;
            int ans = 0;
            for (int i = 0; i < len; i++) {
                sum += cardPoints[i];
            }
            int i = 0;
            while (i <= k) {
                for (int j = i; j < len - k + i; j++) {
                    sumOfCurrentWindow += cardPoints[j];
                }
                ans = Math.max(sum - sumOfCurrentWindow, ans);
                sumOfCurrentWindow = 0;
                i++;
            }
            return ans;
        }
    }
}
