package December;

//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//        二叉树的根是数组中的最大元素。
//        左子树是通过数组中最大值左边部分构造出的最大二叉树。
//        右子树是通过数组中最大值右边部分构造出的最大二叉树。
//        通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//         
//
//        示例 ：
//
//        输入：[3,2,1,6,0,5]
//        输出：返回下面这棵树的根节点：
//
//        6
//        /   \
//        3     5
//        \    /
//        2  0
//        \
//        1

import java.util.ArrayList;
import java.util.List;

public class MaximumBinaryTree_654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int len = nums.length;

        //递归出口：当数组为空的时候
        if (len == 0) return null;

        int max = getMax(nums);
        int i = 0;

        //将最大值作为一个根节点
        TreeNode root = new TreeNode(max);

        //将最大值左边的数组放进另一个数组
        while (nums[i] != max) leftList.add(nums[i++]);
        i++;
        //将最大值右边的数组放进一个数组
        while (i < len) rightList.add(nums[i++]);

        //将泛型数组转化为int型数组
        int[] left = new int[leftList.size()];
        for (int j = 0; j < leftList.size(); j++) left[j] = leftList.get(j);
        int[] right = new int[rightList.size()];
        for (int j = 0; j < rightList.size(); j++) right[j] = rightList.get(j);

        //进行递归，分别对左边和右边进行递归，每次递归都会获得一个子树
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

    //用来获得整个数组的最大值
    public int getMax(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (max < nums[i]) max = nums[i];
        }
        return max;
    }
}
