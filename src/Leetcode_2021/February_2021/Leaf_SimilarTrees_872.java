package Leetcode_2021.February_2021;

//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
//
//
//        举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
//
//        如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
//        如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//

import java.util.ArrayList;
import java.util.List;

public class Leaf_SimilarTrees_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaves(root1);
        List<Integer> list2 = getLeaves(root2);
        return list1.equals(list2);
    }

    public List<Integer> getLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left != null) list.addAll(getLeaves(root.left));
        if (root.right != null) list.addAll(getLeaves(root.right));
        if (root.left == null && root.right == null) list.add(root.val);
        return list;
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
