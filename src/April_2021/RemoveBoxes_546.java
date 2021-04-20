package April_2021;

//给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
//
//        你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k * k 个积分。
//
//        当你将所有盒子都去掉之后，求你能获得的最大积分和。
//
//         
//
//        示例 1：
//
//        输入：boxes = [1,3,2,2,2,3,4,3,1]
//        输出：23
//        解释：
//        [1, 3, 2, 2, 2, 3, 4, 3, 1]
//        ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
//        ----> [1, 3, 3, 3, 1] (1*1=1 分)
//        ----> [1, 1] (3*3=9 分)
//        ----> [] (2*2=4 分)

public class RemoveBoxes_546 {

//    public static void removeBoxes(int[] boxes) {
//        int len = boxes.length;
//        int[][] dp = new int[len][2];
//
//        dp[0][0] = -1;
//        dp[0][1] = 1;
//
//        for(int i = 1; i<len; i++){
//            if(boxes[i] == boxes[i-1]){
//                dp[i][0] = dp[i-1][0];
//                dp[i][1] = dp[i-1][1] + 1;
//            }
//            else{
//                int temp = dp[i-1][0];
//                if(temp == -1){
//                    dp[i][0] = 0;
//                    dp[i][1] = 1;
//                    continue;
//                }
//                if(boxes[i] == boxes[temp]){
//                    dp[i][0] = dp[temp][0];
//                    dp[i][1] = dp[temp][1] + 1;
//                }
//                else{
//                    if(dp[i-1][1] != 1 && dp[i-1][0] != -1){
//                        dp[i][0] = i-1;
//                    }
//                    else dp[i][0] = dp[i-1][0];
//                    dp[i][1] = 1;
//                }
//            }
//        }
//
//        for(int i = 0; i<len; i++){
//            System.out.println(dp[i][0] + " ");
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] boxes = {1,3,2,2,2,3,4,3,1};
//        removeBoxes(boxes);
//    }

    // 又是被支配的一天
    class Solution {
        int[][][] dp;

        public int removeBoxes(int[] boxes) {
            int length = boxes.length;
            dp = new int[length][length][length];
            return calculatePoints(boxes, 0, length - 1, 0);
        }

        public int calculatePoints(int[] boxes, int l, int r, int k) {
            if (l > r) {
                return 0;
            }
            if (dp[l][r][k] == 0) {
                dp[l][r][k] = calculatePoints(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
                for (int i = l; i < r; i++) {
                    if (boxes[i] == boxes[r]) {
                        dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, l, i, k + 1) + calculatePoints(boxes, i + 1, r - 1, 0));
                    }
                }
            }
            return dp[l][r][k];
        }
    }

}
