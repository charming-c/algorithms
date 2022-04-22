package Leetcode.Leetcode_2020.November;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//         
//
//        示例 1：
//
//
//        输入：root = [1,null,2,3]
//        输出：[1,3,2]
//        示例 2：
//
//        输入：root = []
//        输出：[]
//        示例 3：
//
//        输入：root = [1]
//        输出：[1]
//        示例 4：
//
//
//        输入：root = [1,2]
//        输出：[2,1]
//        示例 5：
//
//
//        输入：root = [1,null,2]
//        输出：[1,2]

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {

    //  递归算法很简单
    public List<Integer> inorderTraversal(对称二叉树.TreeNode root) {
        List<Integer> list;
        list = new ArrayList<>();
        if(root == null) return list;

        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));

        return list;
    }

    //迭代，利用栈来迭代
    //每次利用一个循环找到树最左端的节点，并一路把经过的左节点加入到栈里面
    //当到头了以后，弹出栈顶元素，写入值到列表，并顺延到右边节点，再进行取左节点操作
    //当左又边走到头了，就重复前面的操作，每次弹出的都是上一级的元素
    public List<Integer> inorderTraversal2(对称二叉树.TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Deque<对称二叉树.TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;

            //右节点什么时候打印呢：
            //这里没有显示的打印右节点，因为最底层的右节点他的左节点一定是空的，会弹栈打印
            //而其他的右节点，由于有左节点，会在上面的while循环进入栈中，后面也会弹栈打印，其实迭代要比递归难一点
        }
        return ans;
    }
}
