package Leetcode_2022.January_2022;

/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 *
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 *
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："GGLLGG"
 * 输出：true
 * 解释：
 * 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
 * 重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-bounded-in-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class RobotBoundedInCircle_1041 {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int len = instructions.length();
            int count = 0;
            int step = 0;
            int ret[] = new int[4];

            for(int i = 0; i<len; i++) {
                switch(instructions.charAt(i)) {
                    case 'G':
                        ret[count]++;
                        break;
                    case 'L':
                        count++;
                        count %= 4;
                        break;
                    case 'R':
                        count += 3;
                        count %= 4;
                        break;
                }
            }

            if(count % 4 == 0) {
                return (ret[0] - ret[2] == 0) && (ret[1] - ret[3] == 0);
            }
            else return true;

        }
    }
}
