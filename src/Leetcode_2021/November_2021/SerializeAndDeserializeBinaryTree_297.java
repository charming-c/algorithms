package Leetcode_2021.November_2021;

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//        请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//        提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
//
//         
//
//        示例 1：
//
//
//        输入：root = [1,2,3,null,null,4,5]
//        输出：[1,2,3,null,null,4,5]

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_297 {
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty() != true){
            int len = queue.size();
            for(int i = 0; i<len; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    str.append(String.valueOf(node.val));
                    str.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                else str.append("null,");
            }
        }
        str.setLength(str.length() - 1);
        str.append("]");
        System.out.println(str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length()-1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            TreeNode cur = getNode(nodes[i]);
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val){
        if(val.equals("null")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
