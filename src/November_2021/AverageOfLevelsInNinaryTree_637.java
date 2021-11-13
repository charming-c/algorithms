package November_2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//         
//
//        示例 1：
//
//        输入：
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        输出：[3, 14.5, 11]
//        解释：
//        第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
public class AverageOfLevelsInNinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        queue.offer(root);
        while (queue.isEmpty() != true) {
            Double sum = 0.0;
            Double temp = 0.0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            temp = sum / len;
            ans.add(temp);
        }
        return ans;
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