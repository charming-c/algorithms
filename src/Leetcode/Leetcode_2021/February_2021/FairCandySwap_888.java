package Leetcode.Leetcode_2021.February_2021;

//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
//
//        因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//
//        返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
//
//        如果有多个答案，你可以返回其中任何一个。保证答案存在。
//
//         
//
//        示例 1：
//
//        输入：A = [1,1], B = [2,2]
//        输出：[1,2]

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap_888 {

    // 双指针解法，时间复杂度很高，因为有双重循环
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans= new int[2];
        int sumA = 0;
        for(int i = 0; i<A.length; i++){
            sumA += A[i];
        }
        int sumB = 0;
        for(int i = 0; i<B.length; i++){
            sumB += B[i];
        }
        for(int i = 0; i<A.length; i++){
            for(int j = 0; j<B.length; j++){
                if(sumA + 2* B[j] == sumB + 2*A[i]){
                    ans[0] = A[i];
                    ans[1] = B[j];
                }
            }
        }
        return ans;
    }

    // 将A中的元素逐个添加到哈希表中，利用delta，和b计算出相应的a应该的取值
    // 然后再哈希表中查询元素，会比之前的方法快很多
    public int[] fairCandySwap2(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[] ans= new int[2];
        int sumA = 0;
        for(int i = 0; i<len1; i++){
            sumA += A[i];
        }
        int sumB = 0;
        for(int i = 0; i<len2; i++){
            sumB += B[i];
        }
        Set<Integer> rec = new HashSet<>();
        for(int a : A){
            rec.add(a);
        }
        int delta = (sumA-sumB)/2;
        for(int b :B){
            if(rec.contains(delta + b)){
                ans[0] = delta + b;
                ans[1] = b;
                break;
            }
        }

        return ans;
    }
}
