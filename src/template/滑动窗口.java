package template;

public class 滑动窗口 {

    // 定长滑动窗口 模版
    public int minimumRecolors(String blocks, int k) {
        char[] res = blocks.toCharArray();
        int len = res.length;

        int l = 0, r;
        int count = 0;

        // 初始计算，k 为窗口长度
        for(r = 0; r < k; r++) {
            if(res[r] == 'W') count++;
        }
        // 初始答案
        int ans = count;
        while (r < len) {
            // 更新左端
            if(res[l++] == 'W') count--;
            // 更新右端
            if(res[r++] == 'W') count++;
            // 更新答案
            ans = Math.min(ans, count);
        }

        return ans;
    }
}
