package Leetcode_2021.January_2021;

//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        3
//        解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]

public class PathsWithSumLCCI_0412 {

    // 双层递归，先写好判断每一个节点的函数，在利用深度优先逐个排查是否符合要求
    // 说实话不配作为中等题
    // 说实话挺简单的，但我为什么写的这么，慢。还有今天的数字逻辑考得一团糟，不知道怎么办了，保研好难啊，加油冲
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        else return isSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int isSum(TreeNode root, int sum) {
        if (root == null) return 0;
        if (sum == root.val) return 1 +
                isSum(root.left, sum - root.val) + isSum(root.right, sum - root.val);
        else return isSum(root.left, sum - root.val) + isSum(root.right, sum - root.val);
    }
}
