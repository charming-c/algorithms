package March_2021;

//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
//
//         
//
//        提示：
//
//        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
//        因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。

public class NumberOf1Bits_191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            if (n >= 0) {
                return weight1(n);
            }
            return weight2(n);
        }

        public int weight1(int n) {
            int count = 0;
            while (n != 0) {
                count += n % 2;
                n = n / 2;
            }
            return count;
        }

        public int weight2(int n) {
            int count = 0;
            n = n + 1;
            n = -n;
            while (n != 0) {
                if (n % 2 == 1) count++;
                n = n / 2;
            }
            return 32 - count;
        }
    }

    //左移
    public int hammingWeight1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    // 位运算，运用了一个性质，n与n-1做位运算，会将最后一个1换成0，直至n为0
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
