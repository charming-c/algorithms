package November_2021;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//        一般来说，删除节点可分为两个步骤：
//
//        首先找到需要删除的节点；
//        如果找到了，删除它。
//         
//
//        示例 1:
//
//
//
//        输入：root = [5,3,6,2,4,null,7], key = 3
//        输出：[5,4,6,2,null,null,7]
//        解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//        一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//        另一个正确答案是 [5,2,6,null,4,null,7]。

public class DeleteNodeInABST_450 {

}

class Solution {
    /*
    One step right and then always left
    */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
