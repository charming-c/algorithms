package Leetcode.Leetcode_2020.November;

//        给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//        在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
//        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//        说明：你不能倾斜容器，且 n 的值至少为 2。


public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int len = height.length;
        int val = 0;
        int temp = 0;
        int j = len - 1;
        for (int i = 0; i < j; i++) {
            if (height[i] <= height[j]) {
                temp = (j - i) * height[i];
                val = Math.max(temp, val);
            } else while (j > i) {
                temp = (j - i) * height[j];
                val = Math.max(temp, val);
                j--;
                if (height[j] > height[i]) {
                    temp = (j - i) * height[i];
                    val = Math.max(temp, val);

                    break;
                }
            }
        }
        return val;
    }
}
