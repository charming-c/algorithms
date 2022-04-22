package Leetcode.Leetcode_2021.October_2021;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
//
//         
//
//        示例 1：
//
//
//        输入：root = [3,1,4,null,2], k = 1
//        输出：1


public class KthSmallestElementInABST_230 {
    public int kthSmallest(TreeNode root, int k) {
        int left = getNodeCount(root.left);
        if (k == left + 1) return root.val;
        else if (k > left) return kthSmallest(root.right, k - left - 1);
        else return kthSmallest(root.left, k);
    }

    public int getNodeCount(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        else res += 1;
        if (root.left != null)
            res += getNodeCount(root.left);
        if (root.right != null)
            res += getNodeCount(root.right);

        return res;
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
