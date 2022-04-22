package Leetcode.Leetcode_2020.December;

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
//         
//
//        示例：
//
//        输入：3
//        输出：
//        [
//          [1,null,3,2],
//          [3,2,null,1],
//          [3,1,null,null,2],
//          [2,1,3],
//          [1,null,2,null,3]
//        ]
//        解释：
//        以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII_95 {
    /**
     * 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
     * 因此在生成所有可行的二叉搜索树的时候，假设当前序列长度为 nn，如果我们枚举根节点的值为 ii，
     * 那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1 \ldots i-1][1…i−1]
     * ，右子树的节点值的集合为 [i+1 \ldots n][i+1…n]。而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，
     * 因此我们可以想到用递归的方法来解决这道题目。
     * <p>
     * 我们定义 generateTrees(start, end)
     * 函数表示当前值的集合为 [\textit{start},\textit{end}][start,end]，
     * 返回序列 [\textit{start},\textit{end}][start,end] 生成的所有可行的二叉搜索树。
     * 按照上文的思路，我们考虑枚举 [\textit{start},\textit{end}][start,end] 中的值 ii 为当前二叉搜索树的根，
     * 那么序列划分为了 [\textit{start},i-1][start,i−1] 和 [i+1,\textit{end}][i+1,end] 两部分。
     * 我们递归调用这两部分，即 generateTrees(start, i - 1) 和 generateTrees(i + 1, end)，获得所有可行的左子树和可行的右子树，
     * 那么最后一步我们只要从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上，并将生成的二叉搜索树放入答案数组即可。
     * <p>
     * 递归的入口即为 generateTrees(1, n)，出口为当 \textit{start}>\textit{end}start>end 的时候，当前二叉搜索树为空，返回空节点即可。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        } else
            return getTrees(1, n);
    }

    public List<TreeNode> getTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            left = getTrees(start, i - 1);
            right = getTrees(i + 1, end);
            for (TreeNode leftnode : left) {
                for (TreeNode rightnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
