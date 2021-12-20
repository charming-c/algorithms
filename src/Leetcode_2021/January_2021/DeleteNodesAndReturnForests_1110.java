package Leetcode_2021.January_2021;

//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
//        如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
//
//        返回森林中的每棵树。你可以按任意顺序组织答案。
//
//         
//
//        示例：
//
//
//
//        输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//        输出：[[1,2,null,4],[6],[7]]

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForests_1110 {

    // 这其实是一道简单的后序遍历的题目
    // 利用深度优先先到达树的最底层，在比较树的节点值是否与delete数组中有相同的值
    // 如果有，就将这个节点的值设成空，同时可以直接将他的各个子节点加到最后的答案里
    // 因为在之前的深度优先里已经将子节点比过了，所有直接添加就ok
    // 做了那么久，没想到是这么简单的题目
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return ans;
        root = DFS(root, to_delete);
        if (root != null)
            ans.add(root);
        return ans;
    }

    public TreeNode DFS(TreeNode root, int[] to_delete) {
        int len = to_delete.length;
        if (root == null) return root;
        root.left = DFS(root.left, to_delete);
        root.right = DFS(root.right, to_delete);
        for (int i = 0; i < len; i++) {
            if (root.val == to_delete[i]) {
                if (root.left != null) ans.add(root.left);
                if (root.right != null) ans.add(root.right);
                root = null;
                break;
            }
        }
        return root;
    }
}
