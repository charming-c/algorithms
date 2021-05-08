package May_2021;

//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//
//        给定一个数字 n，找出可形成完整阶梯行的总行数。
//
//        n 是一个非负整数，并且在32位有符号整型的范围内。
//
//        示例 1:
//
//        n = 5
//
//        硬币可排列成以下几行:
//        ¤
//        ¤ ¤
//        ¤ ¤
//
//        因为第三行不完整，所以返回2.

public class ArrangingCoins_441 {
    public int arrangeCoins(int n) {
        long left = 0;
        long right = n;
        long sum = 0;
        long midth = 0;
        while(left <= right){
            midth = (left + right) / 2;
            sum = midth * (midth + 1) / 2;
            if(sum == n) return (int)midth;
            else if(sum < n) left = midth + 1;
            else right = midth - 1;
        }
        return (int)left - 1;
    }
}
