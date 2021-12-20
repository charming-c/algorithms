package Leetcode_2021.October_2021;

//如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
//
//        给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
//
//         
//
//        示例 1：
//
//        输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
//        输出：[true,false,true,true,false]
//        示例：
//        "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//        "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//        "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int len = queries.length;
        List<Boolean> ans = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            ans.add(match(queries[i], pattern));
        }
        return ans;
    }

    public Boolean match(String target, String pattern) {
        int len1 = target.length();
        int len2 = pattern.length();

        int i = 0;
        int j = 0;

        while (i < len1) {
            if (j < len2) {
                if (target.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (target.charAt(i) >= 'a' && target.charAt(i) <= 'z' && i != len1 - 1) {
                        i++;
                    } else return false;
                }
            } else {
                if (target.charAt(i) >= 'A' && target.charAt(i) <= 'Z')
                    return false;
                else i++;
            }
        }
        return true;
    }
}
