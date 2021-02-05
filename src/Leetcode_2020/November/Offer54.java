package Leetcode_2020.November;

//给定一棵二叉搜索树，请找出其中第k大的节点。
//
//         
//
//        示例 1:
//
//        输入: root = [3,1,4,null,2], k = 1
//        3
//        / \
//        1   4
//        \
//           2
//        输出: 4

import java.util.ArrayList;
import java.util.List;

public class Offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int len = list.size();
        return list.get(len - k);
    }

    //这个方法就是递归的中序遍历，只是外加了一个数组，将遍历后的元素放到一个数组中去维护
    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}
