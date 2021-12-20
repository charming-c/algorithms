package Leetcode_2021.January_2021;

//给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
//
//        返回使字符串任意相邻两个字母不相同的最小删除成本。
//
//        请注意，删除一个字符后，删除其他字符的成本不会改变。

//        输入：s = "abaac", cost = [1,2,3,4,5]
//        输出：3
//        解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）

public class MinimumDeletionCostToAvoidRepeatingLetters_1578 {

    // 简单地遍历比较字符是否相等，若相等，则考虑处理掉较小的那一个，若较小的一个在前面，则不必对cost数组进行处理
    // 若较小的在后面，则将删除位置的cost值用前一个覆盖，进行下一次比较
    public int minCost(String s, int[] cost) {
        int expense = 0;
        int length = s.length();
        if (length == 0) return 0;
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (cost[i] >= cost[i + 1]) {
                    expense += cost[i + 1];
                    cost[i + 1] = cost[i];
                } else {
                    expense += cost[i];
                }
            }
        }
        return expense;
    }
}
