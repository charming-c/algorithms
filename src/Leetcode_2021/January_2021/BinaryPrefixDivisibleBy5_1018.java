package Leetcode_2021.January_2021;

import java.util.ArrayList;
import java.util.List;

//给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
//
//        返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
//
//         
//
//        示例 1：
//
//        输入：[0,1,1]
//        输出：[true,false,false]
//        解释：
//        输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。

public class BinaryPrefixDivisibleBy5_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int len = A.length;
        int ans = 0;
        List<Boolean> B = new ArrayList<>();
        for(int i = 0; i<len; i++){
            int temp = A[i];
            // 注意计算机里数据类型是有表示范围的，当A数组的长度过大时，会出现ans的数值爆栈的情况，所以这里对5取个模，
            // 这样就把ans的范围缩小到0-4之间，不影响最后结果的输出
            ans = ((ans<<1) + temp) % 5;
            if(ans % 5 == 0) B.add(true);
            else B.add(false);
        }
        return B;
    }
}
