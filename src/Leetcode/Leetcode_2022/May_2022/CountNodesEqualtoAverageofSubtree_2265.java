package Leetcode.Leetcode_2022.May_2022;

import template.TreeNode;

public class CountNodesEqualtoAverageofSubtree_2265 {

    // 写得稀烂
    public int averageOfSubtree(TreeNode root) {
        int ans = 0;
        if(root.left != null)
            ans += averageOfSubtree(root.left);

        if(root.right != null)
            ans += averageOfSubtree(root.right);

        if(root.val == (getSum(root) / getNum(root))) ans++;

        return ans;
    }

    public int getNum(TreeNode root) {
        int ans = 1;
        if(root.left == null && root.right == null) return 1;
        if(root.left != null) {
            ans += getNum(root.left);
        }
        if(root.right != null) {
            ans += getNum(root.right);
        }

        return ans;
    }

    public int getSum(TreeNode root) {
        int ans = root.val;
        if(root.left == null && root.right == null) {
            return root.val;
        }
        if(root.left != null) {
            ans += getSum(root.left);
        }
        if(root.right != null) {
            ans += getSum(root.right);
        }

        return ans;
    }
}
