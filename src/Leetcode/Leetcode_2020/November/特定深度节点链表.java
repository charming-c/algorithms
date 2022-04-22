package Leetcode.Leetcode_2020.November;

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//         
//
//        示例：
//
//        输入：[1,2,3,4,5,null,7,8]
//
//        1
//        /  \
//        2    3
//        / \    \
//        4   5    7
//        /
//        8
//
//        输出：[[1],[2,3],[4,5,7],[8]]
//        返回的是一个链表的头节点构成的节点

import java.util.LinkedList;
import java.util.Queue;

public class 特定深度节点链表 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ListNode[] ans = new ListNode[getDeep(tree)];
        ListNode head = new ListNode(-1);
        int j = 0;
        queue.offer(tree);
        while(!queue.isEmpty()){
            ListNode cur = head;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                ListNode n = new ListNode(node.val);
                cur.next = n;
                cur = n;
                if(i == 0) ans[j++] = n;
            }
        }
        return ans;
    }
    public int getDeep(TreeNode tree){
        if(tree == null) return 0;
        else return Math.max(getDeep(tree.left),getDeep(tree.right))+1;
    }
    // public ListNode getNode(TreeNode tree){

    //     if(tree.left != null && tree.right != null){
    //         tree.left.next = tree.right.next;
    //         return tree.left;
    //     }
    //     else return tree.right;

    // }

    public ListNode getNode(TreeNode tree) {
        ListNode node = new ListNode(tree.val);
        ListNode node1, node2;
        if (tree.left == null && tree.right == null) {
            return node;
        }

        if (tree.left != null) {
            node1 = getNode(tree.left);

            if (tree.right != null) {
                node2 = getNode(tree.right);
                node1.next = node2;
            }
            node.next = node1;
        } else {
            node2 = getNode(tree.right);
            node.next = node2;
        }

        return node;
    }

    public int getLength(TreeNode tree) {
        int len = 0;
        if (tree == null) {
            return len;
        } else len++;
        len += Math.max(getLength(tree.left), getLength(tree.right));
        return len;
    }
}
