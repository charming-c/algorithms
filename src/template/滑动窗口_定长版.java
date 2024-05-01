package template;

public class 滑动窗口_定长版 {

    // 定长滑动窗口 模版
    public int scrollWindow(String blocks, int k) {
        char[] res = blocks.toCharArray();
        int len = res.length;

        int l = 0, r;
        // 维护窗口内的状态
        int count = 0;

        // 初始计算，k 为窗口长度
        for(r = 0; r < k; r++) {
            // 初始计算状态的值
            if(res[r] == 'W') count++;
        }
        // 计算初始答案
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
