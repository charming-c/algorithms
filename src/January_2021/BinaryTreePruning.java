package January_2021;

//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//
//        返回移除了所有不包含 1 的子树的原二叉树。
//
//        ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
//
//        示例1:
//        输入: [1,null,0,0,1]
//        输出: [1,null,0,null,1]


public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        if (root.val == 0 && root.left == null && root.right == null) return null;
        if (root.left != null)
            root.left = pruneTree(root.left);
        if (root.right != null)
            root.right = pruneTree(root.right);
        if (root.val == 0) {
            if (root.left == null && root.right == null)
                return null;
        }
        return root;
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