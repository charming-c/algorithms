package July_2021;

//给定一个二叉树，它的每个结点都存放着一个整数值。
//
//        找出路径和等于给定数值的路径总数。
//
//        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//        示例：
//
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        返回 3。和等于 8 的路径有:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3.  -3 -> 11

import java.util.ArrayList;
import java.util.List;

public class PathSumIII_437 {
    class Solution {
        int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            List<Integer> list = new ArrayList<>();
            path(root,targetSum,list);
            return count;
        }

        public void path(TreeNode root, int targetSum, List<Integer> list){
            if( root == null ) return;
            if(list.size() == 0)
                list.add(root.val);
            else list.add(list.get(list.size() - 1) + root.val);

            check(list,targetSum);

            if(root.left == null && root.right == null){
                return;
            }

            if(root.left != null){
                List<Integer> list1 = new ArrayList<>();
                list1.addAll(list);
                path(root.left, targetSum, list1);
            }

            if(root.right != null){
                List<Integer> list2 = new ArrayList<>();
                list2.addAll(list);
                path(root.right, targetSum, list2);
            }
        }

        public void check(List<Integer> list, int targetSum){
            int temp = list.size();
            if(list.get(temp - 1) == targetSum) count++;
            for(int i = 0; i<temp - 1; i++){
                if(list.get(temp - 1) - list.get(i) == targetSum)
                    count++;
            }
        }
    }
}
