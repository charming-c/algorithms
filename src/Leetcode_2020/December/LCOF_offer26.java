package Leetcode_2020.December;

//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
//        例如:
//        给定的树 A:
//
//             3
//            / \
//           4   5
//          / \
//         1   2
//        给定的树 B：
//
//           4 
//          /
//         1
//        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
//        示例 1：
//
//        输入：A = [1,2,3], B = [3,1]
//        输出：false

public class LCOF_offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean flag = false;
        if(A == null || B == null) return false;
        if (A.val == B.val) {
            if(B.left == null && B.right == null) return true;
            else if(B.left == null)
                flag =  isSubStructure(A.right,B.right)&&(A.right.val==B.right.val);
                //|| isSubStructure(A.left,B) || isSubStructure(A.right,B);
            else if(B.right == null)
                flag =  isSubStructure(A.left, B.left)&&(A.left.val==B.left.val);
                // isSubStructure(A.left,B) || isSubStructure(A.right,B);
            else flag = isSubStructure(A.left,B.left)&&isSubStructure(A.right,B.right)&&(A.right.val==B.right.val)&&(A.left.val==B.left.val);
            //|| isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
        return flag || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
}
