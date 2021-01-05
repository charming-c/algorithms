package January_2021;

//在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
//
//        例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
//
//        分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
//
//        我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
//
//        找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
//
//         
//
//        示例 1：
//
//        输入：s = "abbxxxxzzy"
//        输出：[[3,6]]
//        解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。


import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        int len = s.length();
        int count = 1;
        char cursor = s.charAt(0);
        int start = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == cursor) {
                count++;
                continue;
            }
            if (s.charAt(i) != cursor) {
                if (count >= 3) {
                    List<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(i - 1);
                    list.add(l);
                }
                cursor = s.charAt(i);
                start = i;
                count = 1;
            }
        }
        if (count >= 3) {
            List<Integer> l = new ArrayList<>();
            l.add(start);
            l.add(len - 1);
            list.add(l);
        }
        return list;
    }
}
