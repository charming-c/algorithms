package Leetcode_2020.November;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
//        例如，给定一个 3叉树 :
//
//
//
//
//
//
//
//        返回其前序遍历: [1,3,5,6,2,4]。

import java.util.ArrayList;
import java.util.List;

public class No589_N叉树的前序遍历 {
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {

        if(root == null)
            return res;
        res.add(root.val);
        for(Node child:root.children)
        {
            preorder(child);
        }

        return res;
    }
}
