package Leetcode_2020.December;

//给定一个二叉树，计算 整个树 的坡度 。
//
//        一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
//
//        整个树 的坡度就是其所有节点的坡度之和。
//
//         
//
//        示例 1：
//
//             1              1
//            / \     ->     / \
//           2   3          0   0
//
//        输入：root = [1,2,3]
//        输出：1
//        解释：
//        节点 2 的坡度：|0-0| = 0（没有子节点）
//        节点 3 的坡度：|0-0| = 0（没有子节点）
//        节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
//        坡度总和：0 + 0 + 1 = 1


import java.util.Arrays;

public class BinaryTreeTilt_563 {

    // 自己写的代码永远不如别人的好
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        else if (root.left == null) {
            return Math.abs(getSum(root.right)) + findTilt(root.right);
        } else if (root.right == null) {
            return Math.abs(getSum(root.left)) + findTilt(root.left);
        } else {
            return Math.abs(getSum(root.left) - getSum(root.right)) +
                    findTilt(root.left) + findTilt(root.right);
        }

    }

    public int getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

    // leetcode官方题解
    int tilt = 0;

    public int findTilt2(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
