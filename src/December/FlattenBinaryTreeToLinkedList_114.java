package December;

//给定一个二叉树，原地将它展开为一个单链表。
//
//         
//
//        例如，给定二叉树
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        将其展开为：
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_114 {

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

    //非递归的算法
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        TreeNode node = root;
        TreeNode node2;
        Stack<TreeNode> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            //先将所有左节点全部换成右节点
            //而将右节点送进栈里面
            //迭代出口就是当左节点为空的时候，之后考虑右节点
            while (node.left != null) {
                if (node.right != null) stack.push(node.right);
                node.right = node.left;
                node.left = null;
            }
            //判断当前的节点右节点是否是空的，若不是，就把它下移，并按他迭代
            if (node.right != null) {
                node = node.right;
                continue;
            }
            //此时已经将最近的左右节点全部拉成链了，我们开始出栈
            if (!stack.isEmpty()) {
                node2 = stack.pop();
                node.right = node2;
            }
            //无论出没出栈，我们都要将节点下移，
            //出栈了，就要将出栈接上链，再将node指向它
            //没有出栈，就将节点下移，看看能不能跳出大循环
            node = node.right;
        }
    }
}
