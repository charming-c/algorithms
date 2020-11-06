package November;

//给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
//
//         
//
//        示例:
//
//        输入:
//        [1,2,3]
//
//        输出:
//        3
//
//        解释:
//        只需要3次移动（注意每次移动会增加两个元素的值）：
//
//        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

import java.util.Arrays;

public class 最小移动次数使数组元素相等 {

    public int minMoves(int[] nums) {
        int len = nums.length;
        int n = 0;
        Arrays.sort(nums);
        if(len == 1){
            return 0;
        }

        while(len != 0){
            n += nums[len-1] - nums[0];
            len--;
        }

        return n;
    }



}
