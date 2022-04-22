package Leetcode.Leetcode_2020.November;

//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
//
//
//        示例 1:
//        给定二叉树 [3,9,20,null,null,15,7]
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回 true 。
//        示例 2:
//        给定二叉树 [1,2,2,3,3,null,null,4,4]
//        1
//        / \
//        2   2
//        / \
//        3   3
//        / \
//        4   4
//        返回 false 。

public class 检查平衡性 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            if (Math.abs(getLength(root.left) - getLength(root.right)) >= 2)
                return false;
            else return isBalanced(root.left) && isBalanced(root.right);
        }

        public int getLength(TreeNode root) {
            int len = 0;
            if (root == null) return 0;
            else return Math.max(getLength(root.left), getLength(root.right)) + 1;
        }
    }
}
