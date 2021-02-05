package Leetcode_2020.December;

//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//        例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//        计算从根到叶子节点生成的所有数字之和。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例 1:
//
//        输入: [1,2,3]
//        1
//        / \
//        2   3
//        输出: 25
//        解释:
//        从根到叶子节点路径 1->2 代表数字 12.
//        从根到叶子节点路径 1->3 代表数字 13.
//        因此，数字总和 = 12 + 13 = 25.
//        示例 2:
//
//        输入: [4,9,0,5,1]
//        4
//        / \
//        9   0
//         / \
//        5   1
//        输出: 1026
//        解释:
//        从根到叶子节点路径 4->9->5 代表数字 495.
//        从根到叶子节点路径 4->9->1 代表数字 491.
//        从根到叶子节点路径 4->0 代表数字 40.
//        因此，数字总和 = 495 + 491 + 40 = 1026.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        else return getNumbers(root, 0);
    }

    public int getNumbers(TreeNode root, int sum) {
        //如果当前节点为空，则直接返回sum和（这也是最底层）
        if (root == null) return sum;
        //如果当前节点的子节点都为空，就可以返回前面的sum和+本节点的值（这是最底层了）
        if (root.left == null && root.right == null) {
            sum = sum + root.val;
            return sum;
        }
        //如果有一个节点为空，则只需要递归到另一个子节点的值
        else if (root.left == null) {
            sum = (sum + root.val) * 10;
            return getNumbers(root.right, sum);
        } else if (root.right == null) {
            sum = (sum + root.val) * 10;
            return getNumbers(root.left, sum);
        }
        //如果都不为空，则两个方向递归相加
        else {
            sum = (sum + root.val) * 10;
            return getNumbers(root.left, sum) +
                    getNumbers(root.right, sum);
        }
    }
}
