package Leetcode.Leetcode_2021.January_2021;

//实现一个函数，检查一棵二叉树是否为二叉搜索树。
//
//        示例 1:
//        输入:
//        2
//        / \
//        1   3
//        输出: true
//        示例 2:
//        输入:
//        5
//        / \
//        1   4
//             / \
//            3   6
//        输出: false
//        解释: 输入为: [5,1,4,null,null,3,6]。
//             根节点的值为 5 ，但是其右子节点值为 4 。

import java.util.Deque;
import java.util.LinkedList;

// 自己写的有很多重复代码，不知道如何优化，官方题解就很简洁
public class LegalBinarySearchTree_0405 {
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return isBST(root.left,null,root.val)&&isBST(root.right,root.val,null);
    }
    public boolean isBST(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(root.left == null && root.right == null){
            if(min != null && max !=null)
                return root.val<max  && root.val>min;
            if(min != null)
                return root.val>min;
            if(max != null)
                return root.val<max;
        }
        if(root.left == null){
            if(min != null && max !=null)
                return root.val<max  && root.val>min&& isBST(root.right,root.val,max);
            if(min != null)
                return root.val>min&& isBST(root.right,root.val,max);
            if(max != null)
                return root.val<max&& isBST(root.right,root.val,max);
        }

        if(root.right == null){
            if(min != null && max !=null)
                return root.val<max  && root.val>min&& isBST(root.left,min,root.val);
            if(min != null)
                return root.val>min&& isBST(root.left,min,root.val);
            if(max != null)
                return root.val<max&& isBST(root.left,min,root.val);
        }

        else{
            if(min != null && max !=null)
                return root.val<max  && root.val>min&&isBST(root.left, min,root.val)&&isBST(root.right,root.val,max);
            if(min != null)
                return root.val>min&&isBST(root.left, min,root.val)&&isBST(root.right,root.val,max);
            if(max != null)
                return root.val<max&&isBST(root.left, min,root.val)&&isBST(root.right,root.val,max);
        }
        return  true;
    }
}

// 思路一样，但是这个就写得很优雅，自叹不如
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }
}

// 利用中序遍历解决，因为二叉搜索树中序遍历是一个升序序列，利用这个特性就可以解决这个问题
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}