package Leetcode_2020.November;

//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
//        （这里，平面上两点之间的距离是欧几里德距离。）
//
//        你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
//         
//
//        示例 1：
//
//        输入：points = [[1,3],[-2,2]], K = 1
//        输出：[[-2,2]]
//        解释：
//        (1, 3) 和原点之间的距离为 sqrt(10)，
//        (-2, 2) 和原点之间的距离为 sqrt(8)，
//        由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//        我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//        示例 2：
//
//        输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//        输出：[[3,3],[-2,4]]
//        （答案 [[-2,4],[3,3]] 也会被接受。）


public class 最接近原点的k个点 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        int len = points.length;
        int m,n;
        for(int i = 0; i<k; i++){
            for(int j = 1; j<len-i; j++){
                if(distance(points[j][0],points[j][1]) >
                        distance(points[j-1][0],points[j-1][1])){
                    m = points[j][0]; n = points[j][1];
                    points[j][0] = points[j-1][0];
                    points[j][1] = points[j-1][1];
                    points[j-1][0] = m;
                    points[j-1][1] = n;
                }
            }
        }
        for(int i = 0; i<k; i++){
            ans[i][0] = points[len-i-1][0];
            ans[i][1] = points[len-i-1][1];
        }
        return ans;
    }
    public int distance(int a, int b){
        return a*a+b*b;
    }
}
