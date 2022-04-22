package Leetcode.Leetcode_2020.December;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回锯齿形层次遍历如下：
//
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        int flag = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<size; i++){
                root = queue.poll();
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                list.add(root.val);

            }
            if(flag == 1){
                int length = list.size();
                List<Integer> list2 = new ArrayList<>();
                for(int i = length; i>0; i--){
                    list2.add(list.get(i-1));
                }
                ans.add(list2);
                flag = 0;
            }
            else{
                ans.add(list);
                flag = 1;
            }
        }
        return ans;
    }
}
