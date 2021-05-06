package May_2021;

//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
//
//        换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
//
//        注意，删除一个元素后，子数组 不能为空。
//
//        请看示例：
//
//        示例 1：
//
//        输入：arr = [1,-2,0,3]
//        输出：4
//        解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。

public class MaximumSubarraySumWithOneDelete_1186 {

    // 没想到这么简单
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] f = new int[len];
        int[] g = new int[len];
        int res = arr[0];
        f[0] = arr[0];
        //题目提到至少保留一个元素，所以必须要选f(0)，即g(0)要足够小
        // g(0) + arr[1] < arr[0]
        // g(0) < arr[0] - arr[1]
        // 因为 - 10^4 <= arr[i] <= 10^4，所以arr[0]-arr[1] >= -2 * 10^4，即g(0)取-20001即可
        g[0] = -200001;
        for(int i=1;i<len;i++){
            f[i] = Math.max(f[i-1]+arr[i],arr[i]);//其实就是f(i-1)是否<0
            g[i] = Math.max(g[i-1]+arr[i],f[i-1]);
            res = Math.max(res,Math.max(f[i],g[i]));
        }
        return res;
    }
}
