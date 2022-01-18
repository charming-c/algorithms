package Leetcode_2022.January_2022;

/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class JumpGameIII_1306 {
    class Solution {
        int len = 0;
        public boolean canReach(int[] arr, int start) {
            len = arr.length;
            int[] path = new int[len];
            return reach(arr,start,path);
        }

        public boolean reach(int[] arr, int start,int[] path) {
            if(start >= len || start < 0 || path[start] == 1) return false;
            else if(arr[start] == 0) {
                return true;
            }
            else {
                path[start] = 1;
                return reach(arr,start + arr[start],path) || reach(arr, start - arr[start],path);
            }
        }
    }
}
