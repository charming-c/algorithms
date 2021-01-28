package January_2021;

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//         
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回其层次遍历结果：
//
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

import java.util.*;

public class 剑指offer32_从上到下打印二叉树III {

    // 简单的层序遍历，差点没写出来
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            int flag = 1;
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (queue.isEmpty() != true) {
                List<Integer> list = new ArrayList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.remove();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                if (flag % 2 == 0) {
                    Collections.reverse(list);
                }
                ans.add(list);
                flag++;
            }
            return ans;
        }
    }
}