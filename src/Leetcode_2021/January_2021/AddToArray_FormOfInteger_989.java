package Leetcode_2021.January_2021;

//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
//        给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
//         
//
//        示例 1：
//
//        输入：A = [1,2,0,0], K = 34
//        输出：[1,2,3,4]
//        解释：1200 + 34 = 1234

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArray_FormOfInteger_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        Integer sum = 0;
        Integer flag = 0;
        List<Integer> ans = new ArrayList<>(length);
        for (int i = length - 1; i >= 0; i--) {
            sum = A[i] + K % 10 + flag;
            K = K / 10;
            ans.add(sum % 10);
            flag = sum / 10;
        }
        while (K != 0) {
            ans.add((K % 10 + flag) % 10);
            flag = (K % 10 + flag) / 10;
            K /= 10;
        }
        if (flag != 0)
            ans.add(flag);
        Collections.reverse(ans);
        return ans;
    }
}
