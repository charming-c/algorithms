package Leetcode_2021.January_2021;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//        注意:
//        你可以假设树中没有重复的元素。
//
//        例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len1 = preorder.length;
        int len2 = preorder.length;
        if (len1 == 0 || len2 == 0) return null;
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        for (int i = 0; i < len1; i++) {
            if (inorder[i] == val) {
                // 注意这里的copyOfRange是复制from到to的数组内容，但是不包括to，这就很好的解决了左子树为空，或者右子树为空的情况
                // 因为左子树为空，则buildTree函数的参数就是两个空的数组
                // 右子树为空，则i+1刚好就是数组的长度，则也是空的
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, len1), Arrays.copyOfRange(inorder, i + 1, len2));
                break;
            }
        }
        return root;
    }
}
