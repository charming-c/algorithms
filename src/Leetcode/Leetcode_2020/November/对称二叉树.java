package Leetcode.Leetcode_2020.November;

//给定一个二叉树，检查它是否是镜像对称的。
//
//         
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//        1
//        / \
//        2   2
//        \   \
//        3    3

import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //    我只会用递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        else if (root.left == null || root.right == null) return false;
        else if (root.left.val == root.right.val) return isDuichen(root.left, root.right);
        else return false;
    }

    public boolean isDuichen(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null)
            return false;
        else if (root1.val == root2.val)
            return isDuichen(root1.left, root2.right) && isDuichen(root1.right, root2.left);
        else return false;
    }

    //  迭代，就是一层一层循环比较，官方题解
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}


