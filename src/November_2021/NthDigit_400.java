package November_2021;

//Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
//
//         
//
//        Example 1:
//
//        Input: n = 3
//        Output: 3

public class NthDigit_400 {
    public int findNthDigit(int n) {
        int digit = 1;
        long nine = 9;
        long count = 0;

        //按位数分组，并找到属于哪一组
        while (true) {
            count = digit * nine;
            if (n <= count) {
                break;
            }
            n -= count;
            digit++;
            nine *= 10;
        }

        //定位到数字
        long num = (long) Math.pow(10, digit - 1) + (n - 1) / digit;
        //定位到具体某个字符
        char c = String.valueOf(num).charAt((n - 1) % digit);
        return (int) (c - '0');

    }
}
