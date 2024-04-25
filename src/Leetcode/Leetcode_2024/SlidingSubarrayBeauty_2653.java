package Leetcode.Leetcode_2024;

import java.util.ArrayList;
import java.util.List;

public class SlidingSubarrayBeauty_2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;
        int l = 0, r = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(r = 0; r<k; r++) {
            if(nums[r] < 0) {
                insert(list, nums[r]);
            }
        }
        if(list.size() >= x) res.add(list.get(x - 1));
        else res.add(0);
        while (r < len) {
            if(nums[l++] < 0) remove(list, nums[l - 1]);
            if(nums[r++] < 0) insert(list, nums[r - 1]);
            if(list.size() >= x) res.add(list.get(x - 1));
            else res.add(0);
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for(int n : res)
            ans[idx++] = n;
        return ans;
    }

    private void remove(List<Integer> list, int num) {
        if(list.isEmpty()) {
            list.remove(0);
            return;
        }
        int l = 0, r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if(list.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        System.out.println(r);
        list.remove(r);
    }

    private void insert(List<Integer> list, int num) {
        if(list.isEmpty()) {
            list.add(num);
            return;
        }
        int l = 0, r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if(list.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        if(list.get(r) >= num)
            list.add(r, num);
        else list.add(num);
    }
}
