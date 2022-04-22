package Leetcode.Leetcode_2021.December_2021;

public class OfferII_050 {
    public int pathSum(TreeNode root, int targetSum) {
        return path(root, targetSum, 0);
    }

    public int path(TreeNode root, int targetSum, int flag) {
        if (root == null) return 0;
        if (flag == 1) {
            if (root.val == targetSum) {
                return 1 + path(root.left, 0, 1) + path(root.right, 0, 1);
            } else {
                return path(root.left, targetSum - root.val, flag) + path(root.right, targetSum - root.val, flag);
            }
        } else {
            if (root.val == targetSum) {
                return 1 + path(root.left, targetSum, 0) + path(root.right, targetSum, 0) + path(root.left, 0, 1) + path(root.right, 0, 1);
            }
            return path(root.left, targetSum, flag) + path(root.right, targetSum, flag) + path(root.left, targetSum - root.val, 1) + path(root.right, targetSum - root.val, 1);
        }

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}