package Leetcode.Leetcode_2020.November;

//        给定两个二叉树，编写一个函数来检验它们是否相同。
//
//        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

public class No100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        else return false;
    }

    public class TreeNode {
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
}
