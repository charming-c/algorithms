package Leetcode.Leetcode_2021.January_2021;

//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
//        返回被除数 dividend 除以除数 divisor 得到的商。
//
//        整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//         
//
//        示例 1:
//
//        输入: dividend = 10, divisor = 3
//        输出: 3
//        解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//

public class DivideTwoInteger_29 {
    public int divide(int dividend, int divisor) {
        long ans = divide((long) dividend, (long) (divisor));
        long m = 2147483648L;
        if (ans == m) {
            return Integer.MAX_VALUE;
        } else {
            return (int) ans;
        }
    }

    public long divide(long dividend, long divisor) {
        long ans = 1;
        long sign = 1;
        if (dividend < 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor < 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }
        long origin_dividend = dividend;
        long origin_divisor = divisor;

        if (dividend < divisor) {
            return 0;
        }

        dividend -= divisor;
        while (divisor <= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        long a = ans + divide(origin_dividend - divisor, origin_divisor);
        return sign > 0 ? a : opposite(a);
    }

    public long opposite(long x) {
        return ~x + 1;
    }
}
