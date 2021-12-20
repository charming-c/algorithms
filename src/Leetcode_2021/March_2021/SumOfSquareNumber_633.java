package Leetcode_2021.March_2021;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
//
//         
//
//        示例 1：
//
//        输入：c = 5
//        输出：true
//        解释：1 * 1 + 2 * 2 = 5


public class SumOfSquareNumber_633 {

    // 这么这么简单的二分查找，现在居然不会了，冲冲冲！！！
    public boolean judgeSquareSum(int c) {
        for(long i = 0; i<= Math.sqrt(c); i++){
            if(binarySearch(0,c-i*i,i,c))
                return true;
        }
        return false;
    }
    public boolean binarySearch(long start, long end, long a, int c){
        if(start > end) return false;
        long b = (start + end) / 2;
        if(b*b + a*a > c)
            return binarySearch(start,b-1,a,c);
        else if(b*b + a*a < c)
            return binarySearch(b+1,end,a,c);
        else return true;
    }
}
