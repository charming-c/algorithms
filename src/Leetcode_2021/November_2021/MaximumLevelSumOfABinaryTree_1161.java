package Leetcode_2021.November_2021;

//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
//
//        请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
//
//         
//
//        示例 1：
//
//
//
//        输入：root = [1,7,0,7,-8,null,null]
//        输出：2
//        解释：
//        第 1 层各元素之和为 1，
//        第 2 层各元素之和为 7 + 0 = 7，
//        第 3 层各元素之和为 7 + -8 = -1，
//        所以我们返回第 2 层的层号，它的层内元素之和最大。


import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree_1161 {
    public int maxLevelSum(TreeNode root) {
        int depth = 0;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() != true) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                sum += node.val;
            }
            depth++;
            if (sum > max) {
                ans = depth;
                max = sum;
            }
        }
        return ans;
    }
}
