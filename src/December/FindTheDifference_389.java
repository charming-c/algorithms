package December;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
//        字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
//        请找出在 t 中被添加的字母。



public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);


    }
}
