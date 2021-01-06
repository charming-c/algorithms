package January_2021;

// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    // 实在写不动上一题，水一水这道题
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        else{
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }
}
