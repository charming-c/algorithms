package Leetcode_2020.November;

//给你两个数组，arr1 和 arr2，
//
//        arr2 中的元素各不相同
//        arr2 中的每个元素都出现在 arr1 中
//        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//         
//
//        示例：
//
//        输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//        输出：[2,2,2,1,4,3,3,9,6,7,19]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 数组的相对排序 {

//    菜鸡的我写这道简单题用了栈和泛型数组，用栈把和第二个数组的元素相同的元素取出
//    然后再用一个泛型数组将多余的元素复制出来，然后转化为int数组，最后排序，放到数组末尾
//    唯一的巧妙就是灵活的运用了这样的一个变量来辅助各个数组的长度
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int x = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int n = arr2[len2-1];
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(len1 == 0 || len2 == 0){
            return arr1;
        }

        for(int i = len2-1; i>=0; i--){
            for(int j = 0; j<len1; j++){
                if(arr1[j] ==  arr2[i]){
                    stack.push(arr1[j]);
                    arr1[j] = n;
                }
            }
        }

        for(int i = 0; i<len1; i++){
            if(arr1[i] != n){
                list.add(arr1[i]);
            }
        }

        while(stack.size()!=0){
            arr1[x] = stack.pop();
            x++;
        }
        int len3 = len1-x;
        int[] a = new int[len3];
        for(int i = 0; i<len3; i++){
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        for(int i = 0; i<len3; i++){
            arr1[x+i] = a[i];
        }

        return arr1;
    }
}
