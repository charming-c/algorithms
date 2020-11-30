package November;

//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
//
//         
//
//        示例 ：
//
//        输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
//
//        5
//        / \
//        3    6
//        / \    \
//        2   4    8
//         /        / \
//        1        7   9
//
//        输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
//        1
//          \
//           2
//            \
//             3
//              \
//               4
//                \
//                 5
//                  \
//                   6
//                    \
//                     7
//                      \
//                       8
//                        \
//        9

import java.util.ArrayList;
import java.util.List;

public class No897_递增顺序查找树 {

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

    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> vals = new ArrayList();
            inorder(root, vals);
            TreeNode ans = new TreeNode(0), cur = ans;
            for (int v : vals) {
                cur.right = new TreeNode(v);
                cur = cur.right;
            }
            return ans.right;
        }

        //这个方法就是递归的中序遍历，只是外加了一个数组，将遍历后的元素放到一个数组中去维护
        public void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) return;
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }

    }
}
