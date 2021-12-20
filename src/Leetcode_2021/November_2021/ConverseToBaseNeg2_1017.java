package Leetcode_2021.November_2021;

//给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
//
//        除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
//
//         
//
//        示例 1：
//
//        输入：2
//        输出："110"
//        解释：(-2) ^ 2 + (-2) ^ 1 = 2

public class ConverseToBaseNeg2_1017 {
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder(40);
        while (N != 0) {
            int mod = N % (-2);
            N /= -2;
            if (mod == -1) {
                res.append(1);
                N++;//修正N
            } else {
                res.append(mod);
            }
        }
        return res.length() == 0 ? "0" : res.reverse().toString();
    }

}
