package January_2021;

//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
//
//        字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
//
//         
//
//        示例 1：
//
//        输入：n = 1
//        输出：5
//        解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]


public class CountingSortedVowelStrings_1641 {

    // 这题其实没有用动态规划，反而我用递归给写完了
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += count(i, n - 1);
        }
        return ans;
    }

    // 这个函数的关键就是每次迭代的是下一层，从这一层的一个位置开始，
    // 当下一层的优先级比这一层的位置要大时就直接过渡到下一个，不计算这个
    public int count(int num, int n) {
        int ans = 0;
        // 第二层时，使用
        if (n == 1) return 5 - num;
        // 啊，说不清，感觉自己是蒙对的
        for (int i = num; i < 5; i++) {

            ans += count(i, n - 1);

        }
        return ans;
    }

    // 数学思想不够啊，别人怎么写的这么简单
    int countVowelStrings2(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

}
