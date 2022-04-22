package Leetcode.Leetcode_2020.December;

//定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
//        在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//        示例:
//
//        输入: 5
//        输出:
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]

import java.util.ArrayList;
import java.util.List;

public class PasicalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> p = new ArrayList<List<Integer>>();
        for(int j = 0; j < numRows; j++){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i <= j; i++){
                if(i == 0 || i == j){
                    list.add(1);
                    continue;
                }
                List<Integer> l1 = p.get(j-1);
                list.add(l1.get(i)+l1.get(i-1));
            }
            p.add(list);
        }
        return p;
    }

    // 官方题解，一个意思
     public List<List<Integer>> generate2(int numRows) {
         List<List<Integer>> ret = new ArrayList<List<Integer>>();
         for (int i = 0; i < numRows; ++i) {
             List<Integer> row = new ArrayList<Integer>();
             for (int j = 0; j <= i; ++j) {
                 if (j == 0 || j == i) {
                     row.add(1);
                 } else {
                     row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                 }
             }
             ret.add(row);
         }
         return ret;
     }
}
