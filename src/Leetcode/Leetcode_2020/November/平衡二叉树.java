package Leetcode.Leetcode_2020.November;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//        本题中，一棵高度平衡二叉树定义为：
//
//        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//        示例 1：
//
//
//        输入：root = [3,9,20,null,null,15,7]
//        输出：true
//        示例 2：
//
//
//        输入：root = [1,2,2,3,3,null,null,4,4]
//        输出：false
//        示例 3：
//
//        输入：root = []
//        输出：true


public class 平衡二叉树 {
    public class TreeNode {
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

    //我的思路：先利用递归函数来获得一个节点为根的树的深度
    //当深度匹配后，我们仍然要考虑子树是否是平衡二叉树的情况，用递归解决
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //方法二：
//    自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，
//    先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
//    如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1。
//    如果存在一棵子树不平衡，则整个二叉树一定不平衡。

    public boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        //用一个if，else先判断是否是平衡树，再选择返回高度
        //很妙
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
