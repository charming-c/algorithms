package Leetcode.Leetcode_2021.November_2021;

//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
//        形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//
//        0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
//        F.length >= 3；
//        对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//        另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//
//        返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
//
//         
//
//        示例 1：
//
//        输入："123456579"
//        输出：[123,456,579]

import java.util.ArrayList;
import java.util.List;


// 非常非常经典的一道回溯的题目
public class SplitArrayIntoFibonacciSequence_842 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        search(num.toCharArray(), res, 0);
        return res;

    }

    public boolean search(char[] number, List<Integer> res, int index) {
        if(index == number.length && res.size() >= 3)
            return true;

        int len = number.length;
        for(int i = index; i<len; i++) {
            if(i > index && number[index] == '0')
                break;
            long num = subDigit(number, index, i + 1);
            //如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            if(size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if(size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int)num);
                if(search(number, res, i + 1))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
}
