package January_2021;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
//         
//
//        示例 1：
//
//        输入：nums = [2,3,2]
//        输出：3
//        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//        示例 2：
//
//        输入：nums = [1,2,3,1]
//        输出：4
//        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//             偷窃到的最高金额 = 1 + 3 = 4 。
//        示例 3：
//
//        输入：nums = [0]
//        输出：0

public class HouseRobber_213 {
    public int rob(int[] nums) {
        int len = nums.length;

        // 特殊情况
        if (nums == null || len == 0) return 0;
        if (len == 1) return nums[0];

        // 一般情况
        // 我们开辟一个数组记录当前位置往前回溯能够抢劫的最大收益
        // 同时有两种状态，就是打劫第一家和不打劫第一家，分别放到dp[][0]和dp[1]中
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        // 没打劫第一家，所以初值为0
        dp[0][1] = 0;
        dp[1][0] = Math.max(nums[0], nums[1]);
        // 最优就是只打劫第二家，直接赋值就可以
        dp[1][1] = nums[1];
        for (int i = 2; i < len; i++) {

            // 状态转移方程：每个位置的取值有两种情况，分别取自之前的状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);

        }

        // 这里将最后一个位置的值和第一个位置的值做比较
        if (nums[len - 1] < nums[0])
            dp[len - 1][0] = dp[len - 1][0] + nums[0] - nums[len - 1];

        // 返回值有三种情况，打劫第一家，减去最小损失，没打劫第一家的当前位置和打劫第一家的前一个位置
        if (dp[len - 1][0] > dp[len - 1][1]) {
            return Math.max(dp[len - 1][1], dp[len - 2][0]);
        } else return dp[len - 1][0];
    }
}
