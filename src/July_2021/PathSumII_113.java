package July_2021;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
//        叶子节点 是指没有子节点的节点。
//
//         
//
//        示例 1：
//
//
//        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        输出：[[5,4,11,2],[5,8,4,5]]

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        path(root, targetSum, list);
        return ans;
    }

    public void path(TreeNode root, int target, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            List<Integer> list1 = new ArrayList<>();
            list1.addAll(list);
            if (target == 0)
                ans.add(list1);
            else return;
        }

        if (root.left != null) {
            List<Integer> list2 = new ArrayList<>();
            list2.addAll(list);
            path(root.left, target, list2);
        }

        if (root.right != null) {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list);
            path(root.right, target, list3);
        }
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